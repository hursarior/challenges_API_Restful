package com.Restful.Challenges.Api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.Restful.Challenges.Api.Modelos.DtoTopico;
import com.Restful.Challenges.Api.Modelos.Topico;
import com.Restful.Challenges.Api.repository.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class TopicoServices {
    @Autowired
    private TopicoRepository topicRepository;

    public Topico saludo(Long id) {
        Topico topi = topicRepository.findById(id).get();
        return topi;
    }

    @Transactional
    public List<Topico> ListarTopicos(@PageableDefault(size = 10) Pageable pageable) {
        return topicRepository.findAll(pageable).toList();
    }

    public boolean AddTopico(@Valid DtoTopico dto) {
        if (!topicRepository.existsByTitulo(dto.titulo())) {

            topicRepository.save(new Topico(dto));
            return true;

        } else {
            return false;
        }
    }

    public boolean Update(Long id, DtoTopico dto) throws NotFoundException {
        if (topicRepository.existsById(id)) {

            return false;
            
        } else {

            Topico topico = topicRepository.findById(id).get();
            topico.setAutor(dto.autor());
            topico.setCurso(dto.curso());
            topico.setEstatus_topico(dto.estatus_tpc());
            topico.setMensaje(dto.mensaje());
            topico.setTitulo(dto.titulo());
            topicRepository.save(topico);
            return true;

        }

    }

    public boolean delete(Long id) {

        Topico topico = topicRepository.findById(id).get();
        topicRepository.delete(topico);
        return true;

    }

}
