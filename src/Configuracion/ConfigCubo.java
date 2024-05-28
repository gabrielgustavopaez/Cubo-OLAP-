package Configuracion; 

import java.util.List;

/**
 * Clase de configuración para un cubo.
 */
public class ConfigCubo {
    private String nombreCubo; // Nombre del cubo
    private List<ConfigDimension> dimensiones; // Lista de dimensiones asociadas al cubo
    private ConfigHechos hechos; // Lista de hechos asociados al cubo

    /**
     * Constructor para inicializar la configuración de un cubo.
     *
     * @param nombreCubo Nombre del cubo.
     * @param dimensiones Lista de dimensiones del cubo.
     * @param hechos Lista de hechos asociados al cubo.
     */
    public ConfigCubo(String nombreCubo, List<ConfigDimension> dimensiones, ConfigHechos hechos) {
        this.nombreCubo = nombreCubo; // Inicializa el nombre del cubo
        this.dimensiones = dimensiones; // Inicializa la lista de dimensiones del cubo
        this.hechos = hechos; // Inicializa la lista de hechos del cubo
    }

    /**
     * Obtiene el nombre del cubo.
     *
     * @return Nombre del cubo.
     */
    public String getNombreCubo() {
        return nombreCubo;
    }

    /**
     * Establece el nombre del cubo.
     *
     * @param nombreCubo Nombre del cubo.
     */
    public void setNombreCubo(String nombreCubo) {
        this.nombreCubo = nombreCubo;
    }

    /**
     * Obtiene la lista de dimensiones del cubo.
     *
     * @return Lista de dimensiones.
     */
    public List<ConfigDimension> getDimensiones() {
        return dimensiones;
    }

    /**
     * Establece la lista de dimensiones del cubo.
     *
     * @param dimensiones Lista de dimensiones.
     */
    public void setDimensiones(List<ConfigDimension> dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     * Obtiene la lista de hechos del cubo.
     *
     * @return Lista de hechos.
     */
    public ConfigHechos getHechos() {
        return hechos;
    }

    /**
     * Establece la lista de hechos del cubo.
     *
     * @param hechos Lista de hechos.
     */
    public void setHechos(ConfigHechos hechos) {
        this.hechos = hechos;
    }

    /**
     * Representación en cadena de la configuración del cubo.
     * @return Cadena con la información del cubo.
     */
    @Override
    public String toString() {
        return String.format("ConfigCubo(\n\tnombre: %s, \n\tconfigDimensiones: %s, \n\tconfigHechos: %s", nombreCubo, dimensiones.toString(), hechos.toString());
    }

}