package br.com.fiap.ambiental.service;

import br.com.fiap.ambiental.dto.LocalizacoesCadastroDto;
import br.com.fiap.ambiental.dto.LocalizacoesExibicaoDto;
import br.com.fiap.ambiental.model.Localizacoes;
import br.com.fiap.ambiental.repository.LocalizacoesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalizacoesService {

    @Autowired
    private LocalizacoesRepository localizacoesRepository;

    //POST PARA GRAVAR DADOS
    public LocalizacoesExibicaoDto gravar(LocalizacoesCadastroDto localizacoesCadastroDto){
        Localizacoes localizacoes = new Localizacoes();
        BeanUtils.copyProperties(localizacoesCadastroDto, localizacoes);
        return new LocalizacoesExibicaoDto(localizacoesRepository.save(localizacoes));
    }
    //GET PARA BUSCAR DADOS
    public Localizacoes buscarLocalizacao(String nomeLocalizacao){
        Optional<Localizacoes> localizacoesOptional = localizacoesRepository.findByNomeLocalizacao(nomeLocalizacao);
        if (localizacoesOptional.isPresent()){
            return localizacoesOptional.get();

        }else {

            throw new RuntimeException("Localizacao Não Encontrada!");
        }

        //PUT PARA ATUALIZAR

    }
    public  Localizacoes atualizar (Localizacoes localizacoes){
        Optional<Localizacoes> localizacoesOptional = localizacoesRepository.findById(localizacoes.getIdLocalizacao());

        if (localizacoesOptional.isPresent()){
            return   localizacoesRepository.save(localizacoes);
        } else {

            throw new RuntimeException("Não Encontrado.");
        }

    }

    //DELETE PARA DELETAR UM DADO
    public void excluir (Long idLocalizacao){
        Optional<Localizacoes> localizacoesOptional = localizacoesRepository.findById(idLocalizacao);

        if (localizacoesOptional.isPresent()){
            localizacoesRepository.delete(localizacoesOptional.get());
        }else {
            throw new RuntimeException("Não encontrado");
        }
    }

    }


