package com.Restful.Challenges.Api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Restful.Challenges.Api.Modelos.DtoTopico;
import com.Restful.Challenges.Api.Modelos.Topico;
import com.Restful.Challenges.Api.Service.TopicoServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topico")
public class TopicoController {


    @Autowired
    private TopicoServices topicoServices;

    @GetMapping("/{id}")
    public ResponseEntity<Topico> saludo(@PathVariable Long id) {
        return ResponseEntity.ok(topicoServices.saludo(id));

    }

    @GetMapping
    @Transactional
    public List<Topico> ListarTopicos(Pageable pageable) {
        return topicoServices.ListarTopicos(pageable);
    }

    @PostMapping
    public ResponseEntity<Void> AddTopico(@RequestBody @Valid DtoTopico dto) {

        if(topicoServices.AddTopico(dto)) {
        return ResponseEntity.created(null).build();
        }else{
        return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> Update(@PathVariable Long id, @RequestBody DtoTopico dto) throws NotFoundException{
        if (topicoServices.Update(id, dto)) {
            return ResponseEntity.notFound().build();
        }else{
        return ResponseEntity.ok().build();
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        topicoServices.delete(id);
        return ResponseEntity.noContent().build();

    }

}
