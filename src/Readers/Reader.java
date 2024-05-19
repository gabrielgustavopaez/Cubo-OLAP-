package Readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DataClases.Tabla;

public class Reader{
    static public Tabla ReadFileCSV(String file){
        //variables para leer el archivo
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        //variable para manejar los datos
        String linea = null;
        List<List<String>> tabla = new ArrayList<>();
        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File(file);
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
 
            String[] datos = null;
 
            //Leemos hasta que se termine el archivo
            while ((linea = br.readLine()) != null) {
 
                //Utilizamos el separador para los datos
                datos = linea.split(";");
                tabla.add(Arrays.asList(datos));
                //Presentamos los datos
                //System.out.println(Arrays.toString(datos));
            }
            fr.close();
            br.close();
            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Tabla tablaFinal = new Tabla(tabla);
        return tablaFinal;
    }
}
