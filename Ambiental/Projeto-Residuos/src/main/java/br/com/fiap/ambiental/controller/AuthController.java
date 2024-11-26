//AQUI AUTENTICAMOS O USUARIO COM SPRING SECURITY
// (TODAS AS REGRAS, AQUI PASSAMOS APENAS A OBRIGATORIEDADE DE ACESSAR POR LOGIN E SENHA)

package br.com.fiap.ambiental.controller;

import br.com.fiap.ambiental.config.security.TokenService;
import br.com.fiap.ambiental.dto.LoginDto;
import br.com.fiap.ambiental.dto.TokenDto;
import br.com.fiap.ambiental.dto.UsuarioCadastroDto;
import br.com.fiap.ambiental.dto.UsuarioExibicaoDto;
import br.com.fiap.ambiental.model.Usuario;
import br.com.fiap.ambiental.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePassword
                = new UsernamePasswordAuthenticationToken
                        (loginDto.email(),   //aqui recebemos os dados do usuario
                         loginDto.senha()
                        );

        Authentication auth = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

   return ResponseEntity.ok(new TokenDto(token));
    }

    //Criar um endpoint para ser responsavel por cadastrar um usuario novo, cadastrar a conta no nosso sistema

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto  registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        UsuarioExibicaoDto usuarioSalvo;
        usuarioSalvo = service.salvarUsuario(usuarioCadastroDto);
        return usuarioSalvo;
    }
}
