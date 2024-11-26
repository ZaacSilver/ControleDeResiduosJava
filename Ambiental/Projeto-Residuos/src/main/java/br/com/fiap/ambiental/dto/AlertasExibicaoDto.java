package br.com.fiap.ambiental.dto;

import br.com.fiap.ambiental.model.Alertas;
import br.com.fiap.ambiental.model.Sensores;

import java.time.LocalDateTime;

public record AlertasExibicaoDto(

        Long idAlertas,
        Long idSensor,
        String tipoAlerta,
        LocalDateTime dataHora,
        String mensagemAlerta


) {
    public AlertasExibicaoDto(Alertas alertas){
        this(
                alertas.getIdAlerta(),
                alertas.getIdSensor(),
                alertas.getTipoAlerta(),
                alertas.getDataHora(),
                alertas.getMensagemAlerta()
        );
    }
}
