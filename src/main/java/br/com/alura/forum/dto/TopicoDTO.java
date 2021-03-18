package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topico;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Data
public class TopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDTO(Topico topico) {
        this.setId(topico.getId());
        this.setTitulo(topico.getTitulo());
        this.setMensagem(topico.getMensagem());
        this.setDataCriacao(topico.getDataCriacao());
    }

    public static Page<TopicoDTO> converter(Page<Topico> topicos) {
        return topicos.map(TopicoDTO::new);
    }
}
