package br.com.fiap.ambiental.dto;

import br.com.fiap.ambiental.model.Usuario;
import br.com.fiap.ambiental.model.UsuarioRole;

public record UsuarioExibicaoDto( //USUARIO DTO DEFINIMOS O QUE O USUARIO VE NA TELA OU NO POSTMAN
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role

) {
    public UsuarioExibicaoDto (Usuario usuario){
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()

        );
    }

}


