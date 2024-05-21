package Configuracion;

import java.util.List;

/**
 * Clase de configuración para una dimensión.
 */
public class ConfigDimension {
    private String nombreDimension; // Nombre de la dimensión
    private List<String> columnas;  // Lista de nombres de las columnas que pertenecen a la dimensión
    private List<String> jerarquia; // Lista que define la jerarquía de las columnas en la dimensión

    /**
     * Constructor para inicializar la configuración de una dimensión.
     *
     * @param nombreDimension Nombre de la dimensión.
     * @param columnas Lista de nombres de las columnas que pertenecen a la dimensión.
     * @param jerarquia Lista que define la jerarquía de las columnas en la dimensión.
     */
    public ConfigDimension(String nombreDimension, List<String> columnas, List<String> jerarquia) {
        this.nombreDimension = nombreDimension; // Inicializa el nombre de la dimensión
        this.columnas = columnas; // Inicializa las columnas de la dimensión
        this.jerarquia = jerarquia; // Inicializa la jerarquía de la dimensión
    }

    /**
     * Obtiene el nombre de la dimensión.
     *
     * @return Nombre de la dimensión.
     */
    public String getNombreDimension() {
        return nombreDimension;
    }

    /**
     * Establece el nombre de la dimensión.
     *
     * @param nombreDimension Nombre de la dimensión.
     */
    public void setNombreDimension(String nombreDimension) {
        this.nombreDimension = nombreDimension;
    }

    /**
     * Obtiene la lista de columnas de la dimensión.
     *
     * @return Lista de columnas.
     */
    public List<String> getColumnas() {
        return columnas;
    }

    /**
     * Establece la lista de columnas de la dimensión.
     *
     * @param columnas Lista de columnas.
     */
    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }

    /**
     * Obtiene la jerarquía de la dimensión.
     *
     * @return Jerarquía de la dimensión.
     */
    public List<String> getJerarquia() {
        return jerarquia;
    }

    /**
     * Establece la jerarquía de la dimensión.
     *
     * @param jerarquia Jerarquía de la dimensión.
     */
    public void setJerarquia(List<String> jerarquia) {
        this.jerarquia = jerarquia;
    }

    /**
     * Representación en cadena de la configuración de la dimensión.
     *
     * @return Cadena con la información de la dimensión.
     */
    @Override
    public String toString() {
        return "ConfigDimension{" +
                "nombreDimension='" + nombreDimension + '\'' +
                ", columnas=" + columnas +
                ", jerarquia=" + jerarquia +
                '}';
    }
}