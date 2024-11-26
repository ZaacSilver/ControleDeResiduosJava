package br.com.fiap.ambiental.repository;

import br.com.fiap.ambiental.model.Alertas;
import br.com.fiap.ambiental.model.Leituras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertasRepository extends JpaRepository<Alertas, Long> {

    Optional<Alertas>findByTipoAlerta(String tipoAlerta);
}
