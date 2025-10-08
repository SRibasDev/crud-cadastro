package com.example.crud.usuarios.repository;

import com.example.crud.usuarios.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModel,Long> {
    // extends JpaRepository<[TIPO DA ENTIDADE], [TIPO DA CHAVE PRIMÁRIA]>
    // --> findAll(), save(), findById(), deleteById() etc.
}
