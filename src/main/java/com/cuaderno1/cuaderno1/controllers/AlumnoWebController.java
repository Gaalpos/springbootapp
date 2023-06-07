// package com.cuaderno1.cuaderno1.controllers;

// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.cuaderno1.cuaderno1.models.AlumnoModel;
// import com.cuaderno1.cuaderno1.services.AlumnoService;

// import ch.qos.logback.core.model.Model;

// @Controller
// public class AlumnoWebController {

//     @Autowired
//     AlumnoService alumnoService;
    

//   //   @RequestMapping("/alumno")
//   // public String gameTemplate(Model modelo,String id){
//   //   AlumnoModel game = alumnoService.getById(Long.parseLong(id));
//   //   AlumnoModel comments = alumnoService.getById(Long.parseLong(id));
   

//   //   return "alumno";

//   @RequestMapping("/alumno/{id}")
//   public String gameTemplate(Model modelo, @PathVariable String id){
//     AlumnoModel alumnoModel = alumnoService.getById(Long.parseLong(id));
//     ArrayList<AlumnoModel> comments = alumnoService.getById(Long.parseLong(id));
//     modelo.addAttribute("game", game);
//     modelo.addAttribute("comments", comments);

//     return "game";
//   }

//   }

// }
