package br.com.fiap.ambiental.dto;

import jakarta.validation.constraints.NotBlank;

public record SensoresCadastroDto(

        Long idSensores,

        @NotBlank(message = "É Obrigatório inserir um Nome!")
        String nome,
        @NotBlank(message = "É Obrigatório inserir um tipo!")
        String tipo

) {
}
