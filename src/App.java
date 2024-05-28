import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import Estructura.Cubo;
import Estructura.Proyeccion1D;
import Configuracion.ConfigCubo;
import Configuracion.ConfigDimension;
import Configuracion.ConfigHechos;

 
public class App {
    //Metodo de configuracion para la app
    public static ConfigCubo configurarApp(){
        ConfigCubo configuracion = new ConfigCubo(
            "Cubo OLAP",
            new ArrayList<>(Arrays.asList(
                new ConfigDimension(
                    "fechas",
                    "id_fecha",
                    "./files/fechas.csv",
                    new ArrayList<>(Arrays.asList("id_fecha","fecha","dia","mes","quarter","anio")), 
                    new ArrayList<>(Arrays.asList("dia","mes","quarter","anio"))
                ),
                new ConfigDimension(
                    "productos",
                    "id_producto",
                    "./files/productos.csv",
                    new ArrayList<>(Arrays.asList("id_producto","producto","subcategoria","categoria")), 
                    new ArrayList<>(Arrays.asList("producto","subcategoria","categoria"))
                ),
                new ConfigDimension(
                    "ubicaciones",
                    "id_punto_venta",
                    "./files/puntos_venta.csv",
                    new ArrayList<>(Arrays.asList("id_punto_venta","punto_venta","ciudad","provincia","pais","region")), 
                    new ArrayList<>(Arrays.asList("ciudad","provincia","pais","region"))
                )
            )
            ),
            new ConfigHechos(
                "hechos", 
                new ArrayList<>(Arrays.asList("id_producto","id_punto_venta","id_fecha","cantidad","valor_unitario","valor_total","costo")),  
                "./files/ventas.csv",
                new ArrayList<>(Arrays.asList("cantidad","valor_unitario","valor_total","costo")),
                "cantidad",
                Map.of("fechas","id_fecha", "productos","id_producto","ubicaciones","id_punto_venta")
                )
            );
        return configuracion;
    }

    public static void main(String[] args) throws Exception {
        ConfigCubo configuracion = App.configurarApp();
        //System.out.println(configuracion);
        Cubo cubo = new Cubo(configuracion);
        //cubo.informacionCubo();

        Proyeccion1D proyFechas = cubo.crearProyeccion_1D("fechas", "cantidad", Arrays.asList("anio"));
        proyFechas.mostrar();

        cubo.setMetricaSuma();

        proyFechas = cubo.crearProyeccion_1D("fechas", "cantidad", Arrays.asList("anio"));
        proyFechas.mostrar();

        
    }
}  

/*
        //funcion merge Tablas
        //clase Configuracion
        Tabla hechos = Reader.ReadFileCSV("./files/ventas.csv");
        Tabla tabla = Reader.ReadFileCSV("./files/fechas.csv");
        //tabla.info();
        //hechos.mostrarTabla();
        //hechos.info();
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


        Map<String, List<Map<String, String>>> agrupadaPorCiudadYEdad = tabla.groupBy(Arrays.asList("anio", "quarter"));
        for (String key : agrupadaPorCiudadYEdad.keySet()) {
            System.out.println("Clave: " + key);
            for (Map<String, String> fila : agrupadaPorCiudadYEdad.get(key)) {
                System.out.println(fila);
            }
        }


        Tabla tablaventas = ReaderCSV.ReadFileCSV("./files/ventas.csv");
        tablaventas.info();
        tablaventas.mostrar();
        Configuracion config = new Configuracion("./files/fechas.csv", "dim fechas");
        Cubo cuboOlap = new Cubo(config);
        cuboOlap.verDimensiones();
 */