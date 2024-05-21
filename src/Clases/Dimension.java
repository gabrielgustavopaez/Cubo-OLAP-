package Clases;

import java.util.List;

public class Dimension {
    // Atributos privados de la clase
    private Tabla tabla; // Objeto de tipo 'Tabla' que contiene datos de la dimensión.
    private String nombre; // Nombre de la dimensión.

    // Constructor de la clase 'Dimension'
    public Dimension(Tabla tabla, String nombre) {
        this.tabla = tabla; // Asigna el objeto 'tabla' pasado como parámetro al atributo 'tabla' de la instancia.
        this.nombre = nombre; // Asigna el 'nombre' pasado como parámetro al atributo 'nombre' de la instancia.
    }

    // Método para ver los detalles de la dimensión
    public void verDimension(){
        System.out.println("Ver dimension: " + nombre); // Imprime el nombre de la dimensión.
        
        // Obtiene los valores de la columna "anio" de la tabla.
        List<String> valores = tabla.getColumnValues("anio");
        List<String> listaUnica = valores.stream()
                .distinct() // Elimina duplicados.
                .toList(); // Convierte el stream a una lista
        
        // Itera sobre los valores únicos y cuenta cuántas veces aparece cada uno en la lista original.
        for (String unico : listaUnica) {
            int count = 0;
            for (String valor : valores) {
                if (valor.equals(unico)) {
                    count++; // Incrementa el contador si el valor es igual al valor único actual.
                }
            }

            // Imprime el valor único y su conteo.
            System.out.println(String.format("%s: %d", unico, count));
        }
    }
}
