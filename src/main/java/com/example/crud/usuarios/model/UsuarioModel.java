package com.example.crud.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;
    private int telefone;


    // Construtor vazio (obrigatório para o JPA)
    public UsuarioModel(){}

    public int getIdade() { return idade; }

    public void setIdade(int idade) { this.idade = idade; }


    public Long getId() { return id; }

    public String getNome() { return nome; }

    public int getTelefone() { return telefone; }

    public void setTelefone(int telefone) { this.telefone = telefone; }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
