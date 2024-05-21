package Clases;

// Definición de la clase Configuracion
public class Configuracion {
    // Atributos privados
    private String url;  // URL del archivo
    private String name; // Nombre de la dimensión

    // Constructor de la clase
    // Toma dos parámetros: URL del archivo y nombre de la dimensión
    public Configuracion(String url_archivo, String nombre_dimension) {
        // Inicializa los atributos url y name con los valores proporcionados
        this.name = nombre_dimension;
        this.url = url_archivo;
    }

    // Método para obtener el nombre de la dimensión
    public String getName() {
        return name;
    }
    
    // Método para obtener la URL del archivo
    public String getUrl() {
        return url;
    }
}
