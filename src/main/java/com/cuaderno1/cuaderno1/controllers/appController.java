package com.cuaderno1.cuaderno1.controllers;

import com.cuaderno1.cuaderno1.utils.Utils;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {

  // @RequestMapping("/")
  // public String connected() {
  //   return "Server connected";
  // }

  /*
     Ejercicio 1
     Se pide que crees un endpoint en tu servidor que,
     pasandole un número cualquiera te devuelva ese número elevado al cuadrado
     */

  @RequestMapping("/square/{num}")
  public int square(@PathVariable int num) {
    return num * num;
  }

  @PostMapping("saveOnDisk")
  public String saveOndDisk(@RequestParam Map<String, String> body) {
    String name = body.get("name");
    String price = body.get("price");

    String info = name + " " + price + "\n";

    try {
      Utils.writeOnDisk("datos.txt", info);
    } catch (IOException e) {
      return " Error al intentar escribir en el fichero";
    }
    return "Datos guardados";
  }

  /*
      * Ejercicio 2
      Se pide que crees un endpoint que al llamarlo: vacie (no borre) el fichero datos.txt
      Prueba el funcionamiento de este endpoint con la extensión ThunderClient de vs
      */

  @GetMapping("/emptyfile")
  public static String emptyFile() {
    String filePath = "datos.txt";

    try {
      FileWriter writer = new FileWriter(filePath);
      writer.write(""); // Escribe una cadena vacía para vaciar el archivo
      writer.flush();
      writer.close();
      System.out.println("El archivo se ha vaciado correctamente.");
      return "vaciado correctamente";
    } catch (IOException e) {
        System.out.println("Ocurrió un error al vaciar el archivo: " + e.getMessage());
        return "Error de vaciado";
      
    }
  }


  /*
   * Ejercicio 3
   * Crea un endpoint que te devuelva toda la información guardada en el fichero datos.txt
   */
  @GetMapping("/products")
  public static String getProducts(){
    try{
        return Utils.readFromDisk("datos.txt");
    } catch (FileNotFoundException e){
      return " Fichero no encontrado";
    }catch(Exception e){
      return "Fallo al acceder al fichero " + e.getMessage();
    }
  }

  /*
   * Ejercicio 4
   * Crea un endpoint al que le pases 3 números y devuelva el mayor de ellos.
   * Si alguno de los elementos pasados no es un número devolver la frase "ERROR"
   * 
   * GET http://localhost:8080/max?n1=4&n2=3&n3=8
   */

  @GetMapping ("/max")
  public static String getMax(@RequestParam String n1, @RequestParam String n2, @RequestParam String n3){
    float f1 = Float.parseFloat(n1);
    float f2 = Float.parseFloat(n2);
    float f3 = Float.parseFloat(n3);
    return  Utils.maxNum(f1, f2, f3) + " ";
  }


  /*
   * Ejercicio 5
   * Crea un endpoint al que le pases un texto (frase).
   * ste devolverá el mismo texto, pero con la primera letra de 
   * cada palabra en mayúscula (el resto en minúscula)
   */
  @GetMapping("/capitalize")
  public static String Capitalize(@RequestParam String cadena){
    return Utils.capitalize(cadena);

  }

  /*
   * Ejercicio 6
   * Crea un endpoint que devuelva 3 colores random sin repetir
   * Parte de un array con los colores básicos
   * [negro, azul, marrón, gris, verde, naranja, rosa, púrpura, rojo, blanco y amarillo]
   */

   @GetMapping("/randomColors")
   public static String randomColors(){
    final int COLOR_COUNT =3;
    String [] COLORS = new String[]{"negro", "azul", " verde", "rojo", " amarillo", "morado"," rosa", "blanco"};

    if (COLOR_COUNT > COLORS.length ) throw new RuntimeException("Hay menos colores del los que quieres elegir");

    ArrayList <String> colores = new ArrayList<String>(Arrays.asList(COLORS));
    String finalColors = "";

    for (int i=0; i<COLOR_COUNT;i++){
      int random = Utils.getRandomValue(colores.size());
      finalColors += colores.remove(random) + " ";
    }
    return finalColors;
   }

    /*
   * Ejercicio 7
   * Modificar el ejercicio anterior para meter los elementos que el usuario quiera,
   * nombres por ejemplo, y que luego el usuario pueda elegir cuantos elementos se eligen.
   */
  @GetMapping ("/lottery")
  public static String lottery(@RequestParam String cadena, @RequestParam int num){
    return Utils.randomPicks(cadena, num);
  }


  @GetMapping ("/random/{max}")
  public int randomnumber (@PathVariable int max){
    int num = Utils.getRandomValue(max);
    return num;
  }

  @GetMapping ("/random1")
  public int randomnumberWeb (@RequestParam int max){
   return  Utils.getRandomValue(max);

  }

  @GetMapping("/isPalindrome")
  public boolean isPalindrome(@RequestParam String frase){
    return Utils.isPalindrome(frase);

  }

  /*
   * Tendrá un endpoint que al hacer una petición por GET a la ruta 
   * /add?num1=XXXX&num2=YYYY de tu servidor, este devolverá la suma 
   * de los valores XXXX e YYYY pasados por query
   */
  @GetMapping("/add")
  public int add(@RequestParam int n1, @RequestParam int n2){
    return n1+n2;
  }

  @GetMapping("/deleteFile")
  public String deleteFile(@RequestParam String fileName){
    if (fileName.equals("datos.txt")){
      return Utils.deleteFile(fileName);
    }else{
      return "Archivo incorrecto";
    }

  }

}
 