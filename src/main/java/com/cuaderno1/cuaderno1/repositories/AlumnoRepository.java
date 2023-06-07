package com.cuaderno1.cuaderno1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuaderno1.cuaderno1.models.AlumnoModel;


@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Long> {
}

