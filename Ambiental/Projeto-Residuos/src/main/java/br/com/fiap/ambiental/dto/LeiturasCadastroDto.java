package br.com.fiap.ambiental.dto;

import br.com.fiap.ambiental.model.Leituras;
import br.com.fiap.ambiental.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LeiturasCadastroDto(

        Long idLeituras,

        Long idSensor,

        @NotNull(message = "Deve ser inserido o valor limite ")
        Double valor,

        @NotNull(message = "Erro, Data não expecificada")
        LocalDateTime dataHora
) {

}
