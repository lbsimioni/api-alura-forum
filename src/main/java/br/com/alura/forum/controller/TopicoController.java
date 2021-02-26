package br.com.alura.forum.controller;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public List<TopicoDTO> listar(@RequestParam(name = "nomeCurso", required = false) String nomeCurso) {
        List<Topico> topicos;

        if(nomeCurso != null && nomeCurso != "") {
            topicos = this.repository.findByCurso_NomeContainingIgnoreCase(nomeCurso);
        }
        else {
            topicos = this.repository.findAll();
        }

        return TopicoDTO.converter(topicos);
    }
}
