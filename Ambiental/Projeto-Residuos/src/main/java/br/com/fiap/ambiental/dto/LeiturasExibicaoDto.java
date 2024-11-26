package br.com.fiap.ambiental.dto;

import br.com.fiap.ambiental.model.Leituras;

import java.time.LocalDateTime;

public record LeiturasExibicaoDto(
        Long idLeitura,
        Long idSensor,
        Double valor,
        LocalDateTime dataHora
) {

    public LeiturasExibicaoDto(Leituras leituras){
        this(
                leituras.getIdLeitura(),
                leituras.getIdSensor(),
                leituras.getValor(),
                leituras.getDataHora()
        );
    }



}

