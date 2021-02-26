package br.com.alura.forum.dto;

import br.com.alura.forum.model.Resposta;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RespostaDTO {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDTO(Resposta resposta) {
        this.setId(resposta.getId());
        this.setMensagem(resposta.getMensagem());
        this.setDataCriacao(resposta.getDataCriacao());
        this.setNomeAutor(resposta.getAutor().getNome());
    }
}
