package com.alura.forohub.controller;

import com.alura.forohub.model.Topico;
import com.alura.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // Crear un tópico
    @PostMapping
    public Topico crearTopico(@RequestBody Topico topico){
        return repository.save(topico);
    }

    // Mostrar todos los tópicos
    @GetMapping
    public List<Topico> listarTopicos(){
        return repository.findAll();
    }

    // Mostrar un tópico específico
    @GetMapping("/{id}")
    public Topico obtenerTopico(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    // Actualizar un tópico
    @PutMapping("/{id}")
    public Topico actualizarTopico(@PathVariable Long id, @RequestBody Topico datos){

        Topico topico = repository.findById(id).orElse(null);

        if(topico != null){
            topico.setTitulo(datos.getTitulo());
            topico.setMensaje(datos.getMensaje());
            topico.setAutor(datos.getAutor());
            topico.setCurso(datos.getCurso());

            return repository.save(topico);
        }

        return null;
    }

    // Eliminar un tópico
    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id){
        repository.deleteById(id);
    }

}