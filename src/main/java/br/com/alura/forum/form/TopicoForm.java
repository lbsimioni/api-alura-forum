package br.com.alura.forum.form;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TopicoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String mensagem;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository) {
        return new Topico(this.getTitulo(), this.getMensagem(), cursoRepository.findByNome(this.getNomeCurso()));
    }
}
