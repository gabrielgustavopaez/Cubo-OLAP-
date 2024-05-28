package Estructura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Configuracion.ConfigCubo;
import Configuracion.ConfigDimension;
import Configuracion.ConfigHechos;
import DataClases.Tabla;
import Metricas.Count;
import Metricas.Maximo;
import Metricas.Metrica;
import Metricas.Minimo;
import Metricas.Promedio;
import Metricas.Suma;
import Readers.Reader;


public class Cubo {
    private String nombre;
    private Map<String, Dimension> dimensiones;
    //private Map<String, String> dimension_columna_tabla_hechos;
    private Hechos hechos;
    private String medida;
    private Metrica metrica;

    public void setMetricaCount() {
        this.metrica = new Count("Count");
    }
    public void setMetricaSuma() {
        this.metrica = new Suma("Suma");
    }
    public void setMetricaPromedio() {
        this.metrica = new Promedio("Promedio");
    }
    public void setMetricaMinimo() {
        this.metrica = new Minimo("Minimo");
    }
    public void setMetricaMaximo() {
        this.metrica = new Maximo("Maximo");
    }    
    
    public Cubo() {
        this.dimensiones = new HashMap<>();
        //System.out.println("Constructor Inicial");
    }

    /**
     * constructor para crear el cubo: toma la configuracion y crea sus parametros
     * @param configuracion recibe un ConfigCubo y crea las estructuras necesarias.
     */
    public Cubo(ConfigCubo configuracion) {
        this();
        if (configuracion == null) {
            throw new IllegalArgumentException("La configuracion no puede ser nula");
        }
        this.nombre = configuracion.getNombreCubo();
        //Configurando de la clase hechos del cubo
        ConfigHechos configHechos = configuracion.getHechos();
        //hechos las medidas son todas numericas tipo double
        hechos = new Hechos(configHechos.getNombreHechos(), Reader.ReadFileCSV(configHechos.getUrlArchivo()), configHechos.getColumnasMedidas(), configHechos.getJoinDimensionesColumnasMap());
        this.metrica = new Count("Count");//seteo la metrica count por defecto.
        this.medida = configHechos.getMedidaDefecto();//seteo la medida por defecto
        for (ConfigDimension configDim : configuracion.getDimensiones()) {
            //Modificar dimension ya que no es necesario tipos de datos.
            dimensiones.put(configDim.getNombreDimension(), new Dimension(Reader.ReadFileCSV(configDim.getUrlArchivo()), configDim.getNombreDimension(), configDim.getColumnaJoin(), configDim.getJerarquia()));
            //dimension_columna_tabla_hechos.put(configDim.getNombreDimension(), configDim.getColumnaJoin());
        }

    }

    public Proyeccion1D crearProyeccion_1D(String dimension, String medida, List<String> jerarquia) {
        //obtener las 2 tablas
        Tabla tabla_hechos = this.hechos.getHechos();
        Tabla tabla_dimension = dimensiones.get(dimension).getTabla();
        //Hcaemos el Join de las tablas
        Tabla joinTablas = Tabla.joinTablas(tabla_hechos, tabla_dimension, hechos.columnaDimensionJoin.get(dimensiones.get(dimension).getNombre()), dimensiones.get(dimension).getColumnaJoin());
        //ahora le pasamos todo lo necesario a Proyeccion para trabajar
        return new Proyeccion1D(joinTablas, medida, jerarquia, metrica);
    }


    /*Getters de los atributos */
    public Map<String, Dimension> getDimensiones() {    return dimensiones;    }
    public Hechos getHechos() {    return hechos;   }
    public String getNombre() {    return nombre;   }

    /**
     * Obtener informacion del cubo
     */
    public void informacionCubo() {
        System.out.println("Informacion del cubo...");
        System.out.println("\tNombre: " + nombre);
        System.out.println("\tHechos: " + hechos);
        System.out.println("\tDimensiones:");
        for (String dimNombre : dimensiones.keySet()) {
            System.out.println("\t  " + dimensiones.get(dimNombre));
        }
        System.out.println("\tMetrica: " + metrica);
        System.out.println("\tMedida: " + medida);
    }
}

/*    public enum Metrica {
        SUMA, COUNT, PROMEDIO, MIN, MAX
    }
    private Metrica metrica;
 
    public Metrica getMetricaSuma() {
        return Metrica.SUMA;
    }
    public Metrica getMetricaCount(){
        return Metrica.COUNT;
    }
    public Metrica getMetricaPromedio(){
        return Metrica.PROMEDIO;
    }
    public Metrica getMetricaMin(){
        return Metrica.MIN;
    }
    public Metrica getMetricaMax(){
        return Metrica.MAX;
    }
 */