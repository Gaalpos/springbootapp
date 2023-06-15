package com.cuaderno1.cuaderno1.controllers;




import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cuaderno1.cuaderno1.models.ApiModel;
import com.cuaderno1.cuaderno1.models.TranslateModel;
import com.cuaderno1.cuaderno1.services.TranslateService;
import com.cuaderno1.cuaderno1.utils.Utils;
import com.cuaderno1.cuaderno1.utils.Utils.TranslationUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public ApiModel getFirstResult(@RequestParam("text") String text) {

    RestTemplate restTemplate = new RestTemplate();

    String url = "https://api.mymemory.translated.net/get?q=" + text +"&langpair=es|en";

    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    String jsonResponse = response.getBody();
    /*
     * Se crea una instancia de RestTemplate, que es una clase proporcionada por
     * Spring para hacer solicitudes HTTP más fácilmente.
   */
    ObjectMapper objectMapper = new ObjectMapper();

    try {
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        JsonNode responseDataNode = jsonNode.get("responseData");
    
        if (responseDataNode != null) {
            String translatedText = responseDataNode.get("translatedText").asText();
    
            ApiModel p = new ApiModel();
            p.setTr(translatedText);
            return p;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}

}
