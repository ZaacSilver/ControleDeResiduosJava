package br.com.fiap.ambiental.dto;

import br.com.fiap.ambiental.model.Sensores;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SensoresExibicaoDto(

        Long idSensor,
        String nome,
        String tipo


) {
    public SensoresExibicaoDto (Sensores sensores){
        this(
                sensores.getIdSensor(),
                sensores.getNome(),
                sensores.getTipo()

        );
    }
}
