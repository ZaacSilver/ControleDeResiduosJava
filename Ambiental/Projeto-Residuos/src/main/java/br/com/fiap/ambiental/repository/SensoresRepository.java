package br.com.fiap.ambiental.repository;

import br.com.fiap.ambiental.model.Sensores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensoresRepository extends JpaRepository<Sensores, Long> {

    Optional<Sensores>findByNome(String nome);

    Optional<Sensores>findByTipo(String tipo);



}
