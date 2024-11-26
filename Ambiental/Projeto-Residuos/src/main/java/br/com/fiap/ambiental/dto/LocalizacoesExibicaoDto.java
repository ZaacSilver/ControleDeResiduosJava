package br.com.fiap.ambiental.dto;

import br.com.fiap.ambiental.model.Localizacoes;

public record LocalizacoesExibicaoDto(
        Long idLocalizacao,
        Double logitude,
        Double latitude,
        String nomeLocalizacao

) {
    public LocalizacoesExibicaoDto (Localizacoes localizacoes){
        this(
                localizacoes.getIdLocalizacao(),
                localizacoes.getLatitude(),
                localizacoes.getLongitude(),
                localizacoes.getNomeLocalizacao()
        );
    }
}