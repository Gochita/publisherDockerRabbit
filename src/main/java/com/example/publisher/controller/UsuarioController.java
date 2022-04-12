package com.example.publisher.controller;


import com.example.publisher.model.DTO.UsuarioDTO;
import com.example.publisher.model.UsuarioModel;
import com.example.publisher.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    ModelMapper mapper;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public Flux<UsuarioDTO> findAll() {
        return this.usuarioService.listarTodos().flatMap(c ->
                Mono.just(mapper.map(c, UsuarioDTO.class)));

    }


    @PostMapping("/crearUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UsuarioModel> saveClient(@RequestBody UsuarioDTO usuarioDTO) {
        var usuario = mapper.map(usuarioDTO, UsuarioModel.class);

        return this.usuarioService.saveUsuario(usuario);

    }

}
