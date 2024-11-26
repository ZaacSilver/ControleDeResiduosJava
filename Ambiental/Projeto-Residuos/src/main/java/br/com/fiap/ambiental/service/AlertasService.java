package br.com.fiap.ambiental.service;

import br.com.fiap.ambiental.dto.AlertasCadastroDto;
import br.com.fiap.ambiental.dto.AlertasExibicaoDto;
import br.com.fiap.ambiental.model.Alertas;
import br.com.fiap.ambiental.repository.AlertasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertasService {

    @Autowired
    AlertasRepository alertasRepository;

    //POST PARA GRAVAR DADOS SENSORES
    public AlertasExibicaoDto gravar(AlertasCadastroDto alertasCadastroDto) {
        Alertas alertas = new Alertas();
        BeanUtils.copyProperties(alertasCadastroDto, alertas);
        return new AlertasExibicaoDto(alertasRepository.save(alertas));
    }

}
