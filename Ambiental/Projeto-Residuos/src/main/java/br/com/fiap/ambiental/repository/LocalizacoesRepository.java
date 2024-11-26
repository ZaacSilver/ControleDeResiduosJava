package br.com.fiap.ambiental.repository;

import br.com.fiap.ambiental.model.Localizacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalizacoesRepository extends JpaRepository<Localizacoes, Long> {

        Optional<Localizacoes> findByLatitudeAndLongitude(Double latitude, Double longitude);

        boolean existsByNomeLocalizacao(String nomeLocalizacao);

        Optional<Localizacoes> findByNomeLocalizacao(String nomeLocalizacao);
}
