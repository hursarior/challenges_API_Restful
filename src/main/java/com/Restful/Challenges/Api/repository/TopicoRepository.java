package com.Restful.Challenges.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Restful.Challenges.Api.Modelos.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {   
}
