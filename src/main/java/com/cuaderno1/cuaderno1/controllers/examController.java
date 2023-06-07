package com.cuaderno1.cuaderno1.controllers;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cuaderno1.cuaderno1.models.TranslateModel;
import com.cuaderno1.cuaderno1.services.TranslateService;
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
public String obtenerCoincidencias(@RequestParam String nombre1, @RequestParam String nombre2) {
    return "<html><body>" + Utils.contarCoincidencias(nombre1, nombre2) + "</body></html>";
}



@GetMapping("/letras/{frase}")
public String letras(@PathVariable String frase){
    return Utils.cuentaLetras(frase);
}

@GetMapping("/contar")
public String contar(@RequestParam String frase){
    return Utils.cuentaLetras(frase);
}

@GetMapping("/traduce")
public String traduce (@RequestParam String frase){
    TranslateModel TranslateModel = TranslateService.translate(frase);
    String traducido = TranslateModel.responseData.translatedText;
    return "Frase traducida:  "+ traducido;


}

}
