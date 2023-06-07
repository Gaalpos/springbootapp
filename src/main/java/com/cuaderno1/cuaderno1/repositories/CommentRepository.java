package com.cuaderno1.cuaderno1.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuaderno1.cuaderno1.models.AlumnoModel;

@Repository
public interface CommentRepository extends JpaRepository<AlumnoModel, Long> {
    // listar todos los comentario de un videojuego en particular, ordenador por createdAt
    //ArrayList<AlumnoModel> findByID(Long alumnoId);
}