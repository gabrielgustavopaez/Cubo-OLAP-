
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import DataClases.Tabla;
import Readers.Reader;


public class App {
    public static void main(String[] args) throws Exception {
        //funcion merge Tablas
        //clase Configuracion
        Tabla hechos = Reader.ReadFileCSV("./files/ventas.csv");
        Tabla tabla = Reader.ReadFileCSV("./files/fechas.csv");
        //tabla.info();
        //hechos.mostrarTabla();
        //hechos.info();
        //tabla.mostrarTabla();
        //tabla.agregarColumna("Prueba");
        //tabla.mostrarTabla();

        //Tabla unionHechosFechas = Tabla.joinTablas(hechos, tabla, "id_fecha", "id_fecha");
        //unionHechosFechas.mostrarTabla();

        //unionHechosFechas.editarFila("anio", 0, "2017");
        //unionHechosFechas.mostrarTabla();
        //hechos.info();
        tabla.info();
        
        Map<String, Tabla> subtablas = tabla.groupBySubtablas(Arrays.asList("anio", "quarter"));
        int filas = 0;
        for (String key : subtablas.keySet()) {
            System.out.println("Clave: " + key);
            subtablas.get(key).info();
            subtablas.get(key).mostrarTabla();
            filas += subtablas.get(key).getFilas();
        }
        System.out.println("Cantidad de filas: " + filas);
        /* 
        Map<String, List<Map<String, String>>> agrupadaPorCiudadYEdad = tabla.groupBy(Arrays.asList("anio", "quarter"));
        for (String key : agrupadaPorCiudadYEdad.keySet()) {
            System.out.println("Clave: " + key);
            for (Map<String, String> fila : agrupadaPorCiudadYEdad.get(key)) {
                System.out.println(fila);
            }
        }
        */
        /*
        Tabla tablaventas = ReaderCSV.ReadFileCSV("./files/ventas.csv");
        tablaventas.info();
        tablaventas.mostrar();
        Configuracion config = new Configuracion("./files/fechas.csv", "dim fechas");
        Cubo cuboOlap = new Cubo(config);
        cuboOlap.verDimensiones();
*/
    }
}
