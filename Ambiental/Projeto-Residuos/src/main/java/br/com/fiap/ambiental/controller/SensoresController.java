package br.com.fiap.ambiental.controller;

import br.com.fiap.ambiental.dto.SensoresCadastroDto;
import br.com.fiap.ambiental.dto.AlertasExibicaoDto;
import br.com.fiap.ambiental.dto.SensoresExibicaoDto;
import br.com.fiap.ambiental.model.Sensores;
import br.com.fiap.ambiental.service.SensoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SensoresController {

    @Autowired
    private SensoresService sensoresService;

    @PostMapping("/sensor")
    @ResponseStatus(HttpStatus.CREATED)
    public SensoresExibicaoDto gravar (@RequestBody @Valid SensoresCadastroDto sensoresCadastroDto){
        return sensoresService.gravar(sensoresCadastroDto);
    }

    @GetMapping("/sensor/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Sensores buscarPorNome(@PathVariable String nome){
        return sensoresService.buscarPorNome(nome);
    }

    @PutMapping("/sensor")
    @ResponseStatus(HttpStatus.OK)
    public Sensores atualizar(@RequestBody Sensores sensores){
        return sensoresService.atualizar(sensores);
    }

    @DeleteMapping("/sensor/{idSensor}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long idSensor){
        sensoresService.excluir(idSensor);
    }
}
