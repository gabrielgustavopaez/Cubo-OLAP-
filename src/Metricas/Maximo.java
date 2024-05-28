package Metricas;

import java.util.List;

public class Maximo extends Metrica{
    public Maximo(String nombre) {
        super(nombre);
    }
    @Override
    public Double operacion(List<String> lista){
        Double minimo = lista.stream()
        .map(Double::parseDouble)
        .min(Double::compare)
        .orElse(0.0);  // Devolver 0.0 si la lista está vacía  // Encontrar el valor mínimo
        return minimo;
    }
}
