package com.cuaderno1.cuaderno1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class webController {

    @RequestMapping("/")
  public String connected() {
    return "index";
  }
    
   @RequestMapping("/test")
   public String test(){
    return "test";
   }
    
   @GetMapping("/gafanadal")
   public RedirectView redirectToExternalPage() {
       String externalUrl = "https://gaalpos.github.io/gafa-nadal/"; // Replace with the actual external web page URL

       RedirectView redirectView = new RedirectView();
       redirectView.setUrl(externalUrl);

       return redirectView;
   }
}
