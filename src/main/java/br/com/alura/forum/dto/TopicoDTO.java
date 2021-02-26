package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topico;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<TopicoDTO> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
    }
}
