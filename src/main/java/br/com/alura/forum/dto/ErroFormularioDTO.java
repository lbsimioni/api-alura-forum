package br.com.alura.forum.dto;

import lombok.Data;

@Data
public class ErroFormularioDTO {
    private String campo;
    private String erro;

    public ErroFormularioDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
