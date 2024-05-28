package Configuracion;

import java.util.List;
import java.util.Map;

/**
 * Clase de configuración para hechos.
 */
public class ConfigHechos {
    private String nombreHechos; // Nombre de la tabla de hechos
    private List<String> columnas; // Lista de columnas de la tabla de hechos
    private Map<String, String> joinDimensionesColumnasMap;
    private String urlArchivo; // URL del archivo CSV que contiene los datos
    private List<String> columnasMedidas; // Nombres de las columnas que son las medidas de los hechos
    private String medidaDefecto;//Medida por defecto de los hechos

    /**
     * Constructor para inicializar la configuración de hechos.
     *
     * @param nombreHechos Nombre de la tabla de hechos.
     * @param columnas Lista de columnas de la tabla de hechos.
     * //@param metricas Lista de métricas asociadas a los hechos.
     * @param urlArchivo URL del archivo CSV que contiene los datos.
     * @param nombreArchivo Nombre del archivo CSV.
     */
    public ConfigHechos(String nombreHechos, List<String> columnas /* , List<Metrica> metricas*/, String urlArchivo, List<String> medidas, String medidaPorDefecto, Map<String, String> join) {
        this.nombreHechos = nombreHechos; // Inicializa el nombre de la tabla de hechos
        this.columnas = columnas; // Inicializa las columnas de la tabla de hechos
        //this.metricas = metricas; // Inicializa las métricas asociadas a los hechos
        this.urlArchivo = urlArchivo; // Inicializa la URL del archivo CSV
        this.columnasMedidas = medidas;// Inicializa los valores de las columnas medidas.
        this.medidaDefecto = medidaPorDefecto;//Inicializa la medida por defecto.
        this.joinDimensionesColumnasMap = join;
    }
    /**
     * Obtengo el valor de la medida por defecto de los hechos
     * @return String medida
     */
    public String getMedidaDefecto() {
        return medidaDefecto;
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

    public Map<String, String> getJoinDimensionesColumnasMap() {
        return joinDimensionesColumnasMap;
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
     * Obtiene la lsita de medidas de los hechos.
     *
     * @return devuelve la lista de columnas de medidas
     */
    public List<String> getColumnasMedidas() {
        return columnasMedidas;
    }
    @Override
    public String toString() {
        return String.format("ConfigHechos(nombre: %s, columnas: %s, urlArchivo:%s )", getNombreHechos(),getColumnas(),getUrlArchivo());
    }
}