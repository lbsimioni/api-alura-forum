package br.com.alura.forum.controller;

import br.com.alura.forum.dto.DetalhesTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.form.AtualizacaoTopicoForm;
import br.com.alura.forum.form.TopicoForm;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public Page<TopicoDTO> listar(
            @RequestParam(name = "nomeCurso", required = false) String nomeCurso,
            @RequestParam(name = "pagina", required = true) int pagina,
            @RequestParam(name = "qtd", required = true) int qtd,
            @RequestParam(name = "qtd", required = true) String ordenacao) {

        Pageable pageable = PageRequest.of(pagina, qtd, Sort.Direction.ASC, ordenacao); // passar o Pegeable por parametro @PeagebleDefault

        Page<Topico> topicos;

        if(nomeCurso != null && !nomeCurso.equals("")) {
            topicos = this.repository.findByCurso_NomeContainingIgnoreCase(nomeCurso, pageable);
        }
        else {
            topicos = this.repository.findAll(pageable);
        }

        return TopicoDTO.converter(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDTO> obter(@PathVariable Long id) {
        Optional<Topico> topicoOpt = repository.findById(id);
        if (topicoOpt.isPresent())
            return ResponseEntity.ok(new DetalhesTopicoDTO(topicoOpt.get()));

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(
            @RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        
        Topico topico = this.repository.save(form.converter(this.cursoRepository));

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(
            @PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topico> topicoOpt = repository.findById(id);
        if (topicoOpt.isPresent())
            return ResponseEntity.ok(new TopicoDTO(form.atualizar(topicoOpt.get())));

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topico> topicoOpt = repository.findById(id);
        if (topicoOpt.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
