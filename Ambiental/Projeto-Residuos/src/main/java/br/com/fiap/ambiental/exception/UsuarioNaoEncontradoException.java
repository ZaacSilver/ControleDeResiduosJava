package br.com.fiap.ambiental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException (String mensagem){
        super(mensagem);
    } //aqui criamos um construtor para quem crie esse objeto passe pra gente  uma mensagem
}
