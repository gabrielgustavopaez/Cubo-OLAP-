package Estructura;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import DataClases.Tabla;

public class Proyeccion2D {

private String nombre;
private String dimensionX;
private String dimensionY;
private String jerarquiaX;
private String jerarquiaY;
private Tabla datosProyectados;


public Proyeccion2D(String nombre, String dimensionX, String jerarquiaX, String dimensionY, String jerarquiaY) {
    this.nombre = nombre;
    this.dimensionX = dimensionX;
    this.jerarquiaX = jerarquiaX;
    this.dimensionY = dimensionY;
    this.jerarquiaY = jerarquiaY;
    this.datosProyectados = new Tabla(); // Asumiendo que Tabla es una clase adecuada para almacenar datos
}

/**
 * Recibe una tabla ya joinada con las dimensiones apropiadas
 * @param cubo
 */
public void proyectarEnDosDimensiones(Tabla cubo) {
    // Implementar la lógica para proyectar datos del cubo en dos dimensiones
    List<String> columnas = Arrays.asList(jerarquiaX, jerarquiaY);
    Map<String, List<Map<String, String>>> datosAgrupados = cubo.groupBy(columnas);
    
    // Convertir los datos agrupados en una Tabla de datos proyectados
    for (String key : datosAgrupados.keySet()) {
        List<Map<String, String>> filas = datosAgrupados.get(key);
        for (Map<String, String> fila : filas) {
            //recibe una lista de Strings
            //this.datosProyectados.agregarFila(fila); // Supongamos que Tabla tiene un método agregarFila
        }
    }
}

public String getNombre() {
    return nombre;
}

public String getDimensionX() {
    return dimensionX;
}

public String getDimensionY() {
    return dimensionY;
}

public String getJerarquiaX() {
    return jerarquiaX;
}

public String getJerarquiaY() {
    return jerarquiaY;
}

public Tabla getDatosProyectados() {
    return datosProyectados;
}
}