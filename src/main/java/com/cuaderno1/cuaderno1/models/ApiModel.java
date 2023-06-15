package com.cuaderno1.cuaderno1.models;

public class ApiModel {
    private String translatedText;
  
    public ApiModel (){
        
    }
    public ApiModel( String translatedText) {
      this.translatedText=translatedText;
    }
    
    public String getTr() {
        return translatedText;
    }
    public void setTr(String translatedText) {
        this.translatedText = translatedText;
    }

    
    
}
