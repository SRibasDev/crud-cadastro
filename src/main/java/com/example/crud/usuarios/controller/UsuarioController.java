package com.example.crud.usuarios.controller;

import com.example.crud.usuarios.model.UsuarioModel;
import com.example.crud.usuarios.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Rota: POST http://localhost:8080/usuarios
    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel novoUsuario = usuarioRepository.save(usuario);
        // Retorna o novo usuário com o status HTTP 201 (Created)
        return ResponseEntity.status(201).body(novoUsuario);
    }

    // Rota: GET http://localhost:8080/usuarios
    @GetMapping
    public List<UsuarioModel> listarTodos() {
        return usuarioRepository.findAll(); // Busca todos os registros
    }

    // Rota: GET http://localhost:8080/usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get()); // Retorna 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }

    // Rota: PUT http://localhost:8080/usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel detalhesUsuario) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNome(detalhesUsuario.getNome());
                    usuarioExistente.setEmail(detalhesUsuario.getEmail());
                    UsuarioModel atualizado = usuarioRepository.save(usuarioExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Rota: DELETE http://localhost:8080/usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }
}