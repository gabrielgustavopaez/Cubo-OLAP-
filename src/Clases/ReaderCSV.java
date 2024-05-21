package Clases; 

import java.io.BufferedReader; // Importa la clase BufferedReader para leer texto de una entrada de caracteres de manera eficiente
import java.io.File; // Importa la clase File para trabajar con archivos
import java.io.FileReader; // Importa la clase FileReader para leer archivos de texto
import java.util.ArrayList; // Importa la clase ArrayList para usar listas redimensionables
import java.util.Arrays; // Importa la clase Arrays para usar utilidades relacionadas con arrays
import java.util.List; // Importa la interfaz List para trabajar con listas

public class ReaderCSV {

    // Método estático y público que lee un archivo CSV y devuelve una instancia de la clase Tabla
    static public Tabla ReadFileCSV(String file){
        //variables para leer el archivo
        File archivo = null; // Objeto File que representa el archivo
        FileReader fr = null; // Objeto FileReader para leer el archivo
        BufferedReader br = null; // Objeto BufferedReader para leer el archivo de manera eficiente
        //variable para manejar los datos
        String linea = null; // Variable para almacenar cada línea leída del archivo
        List<List<String>> tabla = new ArrayList<>(); // Lista para almacenar los datos del archivo CSV

        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File(file);
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
 
            String[] datos = null; // Array para almacenar los datos de cada línea
 
            //Leemos hasta que se termine el archivo
            while ((linea = br.readLine()) != null) {
                // Separamos los datos de la línea usando el separador ";" y los convertimos en una lista
                // Utilizamos el separador para los datos
                datos = linea.split(";");
                tabla.add(Arrays.asList(datos));
                // Presentamos los datos
                // System.out.println(Arrays.toString(datos));
            }
            // Cerramos el FileReader y el BufferedReader
            fr.close();
            br.close();

            // Capturamos las posibles excepciones
        } catch (Exception e) {
            // En caso de una excepción, imprimimos el stack trace para ayudar con la depuración
            e.printStackTrace();
        }
        
        // Creamos una instancia de la clase Tabla con los datos leídos
        Tabla tablaFinal = new Tabla(tabla);
        
        // Devolvemos la instancia de la clase Tabla
        return tablaFinal;
    }
}
