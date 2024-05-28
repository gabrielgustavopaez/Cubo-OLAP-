package Estructura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import DataClases.Tabla;
import Metricas.Metrica;

public class Proyeccion1D{
    private Map<String, Double> resultados;
    private String metrica;

    public Proyeccion1D() {
        this.resultados = new HashMap<>();
    }
    public Proyeccion1D(Tabla tabla, String medida, List<String> jerarquia, Metrica metrica) {
        this();
        this.metrica = metrica.getNombre();
        Map<String, List<Map<String, String>>> grupos = tabla.groupBy(jerarquia);
        for (String key : grupos.keySet()) {
            List<String> valoresString = grupos.get(key).stream()
                .map(map -> map.get(medida))
                .filter(value -> value != null)
                .collect(Collectors.toList());
            Double resultado = metrica.operacion(valoresString);
            resultados.put(key, resultado);
        }

    }

    public void mostrar() {
        System.out.println("-------------------------------------------");
        System.out.println(String.format("%s | %s ", "Categoria", metrica));
        for (String key : resultados.keySet()) {
        System.out.println(String.format("%s:\t | \t %s ", key, resultados.get(key)));   
        }       
        System.out.println("-------------------------------------------");

    }
}

//Proyeccion proy = new Proyeccion1D();
