package com.cuaderno1.cuaderno1.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuaderno1.cuaderno1.models.AlumnoModel;
import com.cuaderno1.cuaderno1.repositories.AlumnoRepository;


@Service
public class AlumnoService {

    @Autowired
     AlumnoRepository alumnoRepository;

     @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public  ArrayList<AlumnoModel> getAllAlumnos(){
        return (ArrayList<AlumnoModel>)alumnoRepository.findAll();
    }


    public  AlumnoModel createAlumno(AlumnoModel alumno){
        return alumnoRepository.save(alumno);
    }

    public AlumnoModel getById(long id){
        if(alumnoRepository.findById(id).isPresent())
            return alumnoRepository.findById(id).get();
        else
            return null;
    }

}

