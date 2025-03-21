package br.com.fiap.ambiental.controller;

import br.com.fiap.ambiental.dto.LeiturasCadastroDto;
import br.com.fiap.ambiental.dto.LeiturasExibicaoDto;
import br.com.fiap.ambiental.dto.LocalizacoesCadastroDto;
import br.com.fiap.ambiental.dto.LocalizacoesExibicaoDto;
import br.com.fiap.ambiental.model.Leituras;
import br.com.fiap.ambiental.model.Localizacoes;
import br.com.fiap.ambiental.repository.LeiturasRepository;
import br.com.fiap.ambiental.service.LeiturasService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LeiturasController {

    @Autowired
    private LeiturasService service;

    @PostMapping("/leitura")
    @ResponseStatus(HttpStatus.CREATED)
    public LeiturasExibicaoDto gravar(@RequestBody @Valid LeiturasCadastroDto leiturasCadastroDto) {
        return service.gravar(leiturasCadastroDto);
    }

    @GetMapping(value = "/leitura", params = {"dataInicio", "dataFinal"})
    @ResponseStatus(HttpStatus.OK)
    public List<LeiturasExibicaoDto> listrLeituras(
            @RequestParam LocalDateTime dataInicio,
            @RequestParam LocalDateTime dataFinal
    ) {
        return service.listarLeituras(dataInicio, dataFinal);

    }
}