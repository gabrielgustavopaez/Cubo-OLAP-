package Metricas;

import java.util.List;

public class Promedio extends Metrica{
    public Promedio(String nombre) {
        super(nombre);
    }
    @Override
    public Double operacion(List<String> lista){
        Double suma = lista.stream()
            .map(Double::parseDouble) // Convertir cada cadena a Double
            .reduce(0.0, Double::sum); // Sumar todos los valores
        Double promedio = suma / lista.size();
        return promedio;
    }
}
