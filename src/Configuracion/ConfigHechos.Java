package Configuracion;

import java.util.List;

/**
 * Clase de configuración para hechos.
 */
public class ConfigHechos {
    private String nombreHechos; // Nombre de la tabla de hechos
    private List<String> columnas; // Lista de columnas de la tabla de hechos
    private List<Metrica> metricas; // Lista de métricas asociadas a los hechos
    private String urlArchivo; // URL del archivo CSV que contiene los datos
    private String nombreArchivo; // Nombre del archivo CSV

    /**
     * Enumeración para definir las métricas disponibles.
     */
    public enum Metrica {
        SUMA, COUNT, PROMEDIO, MIN, MAX
    }

    /**
     * Constructor para inicializar la configuración de hechos.
     *
     * @param nombreHechos Nombre de la tabla de hechos.
     * @param columnas Lista de columnas de la tabla de hechos.
     * @param metricas Lista de métricas asociadas a los hechos.
     * @param urlArchivo URL del archivo CSV que contiene los datos.
     * @param nombreArchivo Nombre del archivo CSV.
     */
    public ConfigHechos(String nombreHechos, List<String> columnas, List<Metrica> metricas, String urlArchivo, String nombreArchivo) {
        this.nombreHechos = nombreHechos; // Inicializa el nombre de la tabla de hechos
        this.columnas = columnas; // Inicializa las columnas de la tabla de hechos
        this.metricas = metricas; // Inicializa las métricas asociadas a los hechos
        this.urlArchivo = urlArchivo; // Inicializa la URL del archivo CSV
        this.nombreArchivo = nombreArchivo; // Inicializa el nombre del archivo CSV
    }

    /**
     * Obtiene el nombre de la tabla de hechos.
     *
     * @return Nombre de la tabla de hechos.
     */
    public String getNombreHechos() {
        return nombreHechos;
    }

    /**
     * Establece el nombre de la tabla de hechos.
     *
     * @param nombreHechos Nombre de la tabla de hechos.
     */
    public void setNombreHechos(String nombreHechos) {
        this.nombreHechos = nombreHechos;
    }

    /**
     * Obtiene la lista de columnas de la tabla de hechos.
     *
     * @return Lista de columnas.
     */
    public List<String> getColumnas() {
        return columnas;
    }

    /**
     * Establece la lista de columnas de la tabla de hechos.
     *
     * @param columnas Lista de columnas.
     */
    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }

    /**
     * Obtiene la lista de métricas asociadas a los hechos.
     *
     * @return Lista de métricas.
     */
    public List<Metrica> getMetricas() {
        return metricas;
    }

    /**
     * Establece la lista de métricas asociadas a los hechos.
     *
     * @param metricas Lista de métricas.
     */
    public void setMetricas(List<Metrica> metricas) {
        this.metricas = metricas;
    }

    /**
     * Obtiene la URL del archivo CSV.
     *
     * @return URL del archivo CSV.
     */
    public String getUrlArchivo() {
        return urlArchivo;
    }

    /**
     * Establece la URL del archivo CSV.
     *
     * @param urlArchivo URL del archivo CSV.
     */
    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    /**
     * Obtiene el nombre del archivo CSV.
     *
     * @return Nombre del archivo CSV.
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }
}