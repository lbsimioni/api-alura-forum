package br.com.alura.forum.dto;

import br.com.alura.forum.model.StatusTopico;
import br.com.alura.forum.model.Topico;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DetalhesTopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostaDTO> respostas;

    public DetalhesTopicoDTO(Topico topico) {
        this.setId(topico.getId());
        this.setTitulo(topico.getTitulo());
        this.setMensagem(topico.getMensagem());
        this.setDataCriacao(topico.getDataCriacao());
        this.setNomeAutor(topico.getAutor().getNome());
        this.setStatus(topico.getStatus());

        this.setRespostas(new ArrayList<>());
        this.respostas.addAll(
                topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList())
        );
    }
}
