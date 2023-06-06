package com.cuaderno1.cuaderno1.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.thymeleaf.DialectConfiguration;

public class Utils {

  public static void writeOnDisk(String fileName, String info)
    throws IOException {
    FileWriter fw = null;
    try {
      fw = new FileWriter(fileName, true);
      fw.write(info);
    } finally {
      if (fw != null) fw.close();
    }
  }

  public static String readFromDisk(String fileName)
    throws FileNotFoundException, IOException {
    // Método que lee el contenido de un archivo y lo
    // devuelve en formato HTML como una lista desordenada

    // Inicializar objetos para leer el archivo
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;

    try {
      // Abrir el archivo "datos.txt"
      fileReader = new FileReader("datos.txt");
      bufferedReader = new BufferedReader(fileReader);
      /*
       * FileReader se utiliza para leer caracteres del archivo 
       * BufferedReader se utiliza para leer líneas de texto de manera eficiente.
       */

      String line;
      String content = "<ul>"; // Inicio de la lista desordenada en HTML

      // Leer cada línea del archivo y agregarla a la lista desordenada en HTML
      while ((line = bufferedReader.readLine()) != null) {
        content += "<li>" + line + "</li>";
      }

      content += "</ul>"; // Cierre de la lista desordenada en HTML
      return content; // Devolver el contenido en formato HTML
    } finally {
      if (fileReader != null) fileReader.close();
      if (bufferedReader != null) bufferedReader.close();
    }
  }

  public static float maxNum(float ...numbers){
    if (numbers == null || numbers.length==0) throw new NumberFormatException();

    float max=numbers[0];
    for (int i=1; i<numbers.length;i++){
        if(numbers[i] > max) max = numbers[i];
    }
    return max;

  }

  public static String capitalize(String cadena){
    String [] words = cadena.split(" ");
    String capitalizedText="";

    for (String word : words ){
      char FirstLetter = Character.toUpperCase(word.charAt(0));
      String rest = word.substring(1).toLowerCase();
      capitalizedText+=FirstLetter+rest+" ";
    }
    return capitalizedText;
  
  }

  public static int getRandomValue(int max){
    return (int) Math.floor( Math.random() * max );
}

public static String randomPicks(String cadena , int cuantos){
  String[] opt = cadena.split(" ");
  

  ArrayList <String> opciones = new ArrayList<String>(Arrays.asList(opt));
  String elegidos = "";

  for (int i=0; i < cuantos; i++){
    int random = Utils.getRandomValue(opciones.size());
    elegidos += opciones.remove(random)+ " ";
  }
  
  return elegidos;
}

public static boolean isPalindrome(String word){
  String inverseWord = new StringBuilder(word)
      .reverse()
      .toString();
  return inverseWord.equalsIgnoreCase(word);
}

public static String deleteFile(String fileName){
  File file = new File(fileName);
  boolean borrado = file.delete();

  if (borrado == true)
    return "borrado exitoso";
  else
    return "Borrado fallido";

}

public static String dniletter(int dni){
  String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
  // int modulo = dni % 23;
  return  String.valueOf(juegoCaracteres.charAt(dni % 23));
  
}


public static List<Character> checkNames(String nombre1, String nombre2) {
  String nombre1Lower = nombre1.toLowerCase();
  String nombre2Lower = nombre2.toLowerCase();

  List<Character> coincidencias = new ArrayList<>();

  for (char c : nombre1Lower.toCharArray()) {
      if (nombre2Lower.contains(String.valueOf(c))) {
          coincidencias.add(c);
      }
  }

  return coincidencias;
}

}
