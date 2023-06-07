package com.cuaderno1.cuaderno1.controllers;


import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuaderno1.cuaderno1.models.AlumnoModel;

import com.cuaderno1.cuaderno1.services.AlumnoService;



@RestController
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public String music(){
        String tmp = "";
        for(AlumnoModel alu: alumnoService.getAllAlumnos()){
            tmp +="  Nombre:" + alu.getName();
            tmp += "  Fecha fichaje:" +alu.getFecha();
            tmp += "  ID:" + alu.getId();
            tmp += "<br/>";
           
        }
        return tmp;
    }


    @PostMapping("/alumno")
    public String addAlumno(@RequestParam Map <String, String> body){
        String name = body.get("name");
        String fecha = body.get("date");
      
        AlumnoModel alumno = new AlumnoModel();
        alumno.setName(name);
        alumno.setFecha(fecha);

        alumnoService.createAlumno(alumno);
        return "alumno fichado";

    }

}