package Configuracion;

import java.util.List;

public class ConfigProyeccion {
    private String nombre; // Nombre de la proyección
    private String medida; // Medida a proyectar
    private List<String> dimensiones; // Lista de dimensiones a incluir en la proyección
    // Podrían agregarse más atributos, como filtros u opciones de configuración adicionales

    // Constructor de la clase
    public ConfigProyeccion(String nombre, String medida, List<String> dimensiones) {
        this.nombre = nombre;
        this.medida = medida;
        this.dimensiones = dimensiones;
    }

    // Método para obtener el nombre de la proyección
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la medida de la proyección
    public String getMedida() {
        return medida;
    }

    // Método para obtener la lista de dimensiones de la proyección
    public List<String> getDimensiones() {
        return dimensiones;
    }

    // Método para establecer el nombre de la proyección
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para establecer la medida de la proyección
    public void setMedida(String medida) {
        this.medida = medida;
    }

    // Método para establecer la lista de dimensiones de la proyección
    public void setDimensiones(List<String> dimensiones) {
        this.dimensiones = dimensiones;
    }

    // Sobrecarga del método toString para representar la configuración de la proyección
    @Override
    public String toString() {
        return "ConfigProyeccion{" +
                "nombre='" + nombre + '\'' +
                ", medida='" + medida + '\'' +
                ", dimensiones=" + dimensiones +
                '}';
    }
}

