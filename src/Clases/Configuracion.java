package Clases;

public class Configuracion {
    private String url;
    private String name;
    public Configuracion(String url_archivo, String nombre_dimension) {
        this.name = nombre_dimension;
        this.url = url_archivo;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
}
