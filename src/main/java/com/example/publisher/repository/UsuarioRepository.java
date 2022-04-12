package com.example.publisher.repository;


import com.example.publisher.model.UsuarioModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveMongoRepository<UsuarioModel, String> {
}
