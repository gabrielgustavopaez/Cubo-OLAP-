package Metricas;

import java.util.List;

public class Suma extends Metrica{
    public Suma(String nombre) {
        super(nombre);
    }
    @Override
    public Double operacion(List<String> lista){
        Double suma = lista.stream()
            .map(Double::parseDouble) // Convertir cada cadena a Double
            .reduce(0.0, Double::sum); // Sumar todos los valores
        return suma;
    }
}
