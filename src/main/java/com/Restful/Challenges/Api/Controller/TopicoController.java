package com.Restful.Challenges.Api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Restful.Challenges.Api.Modelos.DtoTopico;
import com.Restful.Challenges.Api.Modelos.Topico;
import com.Restful.Challenges.Api.repository.TopicoRepository;

import jakarta.validation.Valid;

@RestController
public class TopicoController {

    @Autowired
    private TopicoRepository topicRepository;

    @GetMapping()
    public String saludo() {
        return "Hola";
    }

    @GetMapping("/listar")
    public List<Topico> ListarTopicos() {
        return topicRepository.findAll();
    }

    @PostMapping("/registar")
    public ResponseEntity<Void> AddTopico(@RequestBody @Valid DtoTopico dto) {
        topicRepository.save(new Topico(dto));
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> Update(@PathVariable Long id, @RequestBody DtoTopico dto) {

        Topico topico = topicRepository.findById(id).get();
      

            topico.setAutor(dto.autor());
            topico.setCurso(dto.curso());
            topico.setEstatus_topico(dto.estatus_tpc());
            topico.setMensaje(dto.mensaje());
            topico.setTitulo(dto.titulo());
            return ResponseEntity.ok().build();


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Topico topico = topicRepository.findById(id).get();
        topicRepository.delete(topico);
        return ResponseEntity.noContent().build();

    }
}
