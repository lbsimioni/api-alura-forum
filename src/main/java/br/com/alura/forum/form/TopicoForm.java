package br.com.alura.forum.form;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import lombok.Data;

@Data
public class TopicoForm {
    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository) {
        return new Topico(this.getTitulo(), this.getMensagem(), cursoRepository.findByNome(this.getNomeCurso()));
    }
}
