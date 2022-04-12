package com.example.publisher.service;


import com.example.publisher.model.UsuarioModel;
import com.example.publisher.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    ModelMapper mapper;

    public UsuarioService(ModelMapper mapper) {
        this.mapper = mapper;
    }
    public Mono<UsuarioModel> saveUsuario(UsuarioModel clienteModel) {
        return this.usuarioRepository.save(clienteModel);
    }
    public Flux<UsuarioModel> listarTodos() {
        return this.usuarioRepository.findAll();
    }
}
