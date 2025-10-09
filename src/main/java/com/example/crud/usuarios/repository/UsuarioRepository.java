package com.example.crud.usuarios.repository;

import com.example.crud.usuarios.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/* cria uma interface que herda métodos e comportamentos da extensão JPA;
- <> dita parametros sobre o que o jpa vai gerenciar. Nesse caso, um UsuarioModel o Id do tipo Long;
- Com isso, o JpaRepository sabe que quando eu chamar save(usuario), ele deve salvar um UsuarioModel
 na tabela tb_usuarios do BD e que o ID para buscar ou deletar é um Long.*/


public interface UsuarioRepository  extends JpaRepository<UsuarioModel,Long> {
    // extends JpaRepository<[TIPO DA ENTIDADE], [TIPO DA CHAVE PRIMÁRIA]>
    // --> findAll(), save(), findById(), deleteById() etc.
}
