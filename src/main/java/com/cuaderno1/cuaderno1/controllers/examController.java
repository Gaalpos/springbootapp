package com.cuaderno1.cuaderno1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cuaderno1.cuaderno1.utils.Utils;

@RestController
public class examController {
    
@GetMapping("/letradni")
public String letradni( @RequestParam int dni){
    if (dni < 9 ||  dni > 99999999){
        return "numero invalido";
    }else{
        return Utils.dniletter(dni);

    }

}

@GetMapping("/names")
public ModelAndView mostrarFormulario() {
    return new ModelAndView("formulario");
}

@PostMapping("/names")
public ModelAndView obtenerCoincidencias(@RequestParam String nombre1, @RequestParam String nombre2) {
    List<Character> coincidencias = Utils.checkNames(nombre1, nombre2);

    ModelAndView modelAndView = new ModelAndView("resultado");
    modelAndView.addObject("Total Coincidencias", coincidencias.size());
    modelAndView.addObject("letras Coincidentes", coincidencias);

    return modelAndView;
}

}
