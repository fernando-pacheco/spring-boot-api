package org.example.controllers;

import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value="listatodos")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listaUsuario() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
    }

    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {

        Usuario user = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);

    }
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {

        if (usuario.getId() == null) {
            return new ResponseEntity<String>("ID não foi informado", HttpStatus.OK);
        }

        Usuario user = usuarioRepository.saveAndFlush(usuario);
        return new ResponseEntity<Usuario>(user, HttpStatus.OK);

    }

    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Usuario> buscaruserid(@RequestParam(name = "iduser") Long iduser) {

        Usuario usuario = usuarioRepository.findById(iduser).get();
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }

    @GetMapping(value = "filtrarPorNome")
    @ResponseBody
    public ResponseEntity<List<Usuario>> filtrarPorNome(@RequestParam(name = "nome") String nome) {

        List<Usuario> usuario = usuarioRepository.filtrarPorNome(nome.trim());
        return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);

    }






}
