package Clases;

import java.util.List;

public class Dimension {
    private Tabla tabla;
    private String nombre;
    public Dimension(Tabla tabla, String nombre) {
        this.tabla = tabla;
        this.nombre = nombre;
    }

    public void verDimension(){
        System.out.println("Ver dimension: " + nombre);
         List<String> valores = tabla.getColumnValues("anio");
         
         List<String> listaUnica = valores.stream()
                .distinct()
                .toList();
        for (String unico : listaUnica) {
            int count = 0;
            for (String valor : valores) {
                if (valor.equals(unico)) {
                    count++;
                }
            }
            System.out.println(String.format("%s: %d", unico, count));
        }
    }
}
