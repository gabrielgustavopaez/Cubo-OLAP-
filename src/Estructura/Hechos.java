package Estructura;
import DataClases.Tabla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hechos {
    private String nombre;//nombre de la tabla
    private Tabla hechos;//tabla de datos 
    private List<String> medidas;//columnas de la tabla que representan las medidas de los hechos
    Map<String, String> columnaDimensionJoin;
    /**
     * Inicializando la clase Hechos
     * @param nombre nombre de la tabla/dimension hechos.
     * @param datos datos para los hechos de tipo Tabla.
     * @param listaMedidas lista de cadenas que representan las columnas.
     */
    public Hechos(String nombre, Tabla datos, List<String> listaMedidas, Map<String, String> columnaDimensionJoin) {
        this.nombre = nombre;
        this.hechos = datos;
        this.medidas = listaMedidas;
        this.columnaDimensionJoin = new HashMap<>(columnaDimensionJoin);//copia
    }
    /* Devuelve la tabla asociada a los hechos */
    public Tabla getHechos() {
        return hechos;
    }
    /* Devuelve la lista de columnas asociadas a las medidas. */
    public List<String> getMedidas() {
        return medidas;
    }
    /* Devuelve el nombre asociado a los hechos. */
    public String getNombre() {
        return nombre;
    }
    /* Sobrecarga del metodo toString para visualizar los hechos. */
    @Override
    public String toString() {
        return String.format("Hechos(nombre: %s, tabla: %s, medidas: %s)", nombre, hechos, medidas);
    }
}
