package Estructura;

import java.util.ArrayList;
import java.util.List;
import DataClases.Tabla;

public class Dimension {
    private String nombre; // Nombre de la dimensión
    private String columnaJoin;//columna de la tabla que permite join
    private Tabla tabla; // Tabla asociada a esta dimensión
    private List<String> jeraquias;//jerarquias de la dimension
    //private Map<String, String> tiposDatos; // Tipos de datos de las columnas de la tabla
    //se elimina ya que las dimensiones no albergan un tipo de dato para trabajar todos son string

    /**
     * Constructor vacío para la dimensión.
     */
    public Dimension() {
       this.jeraquias = new ArrayList<>();
    }

    /**
     * Constructor completo para crear una nueva dimensión con todos los detalles.
     * @param tabla La tabla asociada a la dimensión.
     * @param nombreDimension El nombre de la dimensión.
     * @param tipos Los tipos de datos de las columnas de la tabla.
     */
    public Dimension(Tabla tabla, String nombreDimension, String columnaJoin, List<String> jerarquias) {
        if (tabla == null || nombreDimension == null || nombreDimension.isEmpty() || columnaJoin == null || columnaJoin.isEmpty() || jerarquias == null || jerarquias.isEmpty()) {
            throw new IllegalArgumentException("Todos los parámetros deben ser no nulos y no vacíos");
        }
        this.tabla = tabla;
        this.nombre = nombreDimension;
        this.columnaJoin = columnaJoin;
        this.jeraquias = new ArrayList<>(jerarquias); // Aseguramos una copia para inmutabilidad
    }

    /**
     * Método para obtener el nombre de la dimensión.
     * @return El nombre de la dimensión.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la tabla asociada a esta dimensión.
     * @return La tabla asociada.
     */
    public Tabla getTabla() {
        return tabla;
    }

    /**
     * Método para obtener los tipos de datos de las columnas.
     * @return Un mapa con los tipos de datos de las columnas.
     
    public Map<String, String> getTiposDatos() {
        return new HashMap<>(tiposDatos); // Devolvemos una copia para proteger la inmutabilidad
    }
    */

    /**
     * Método para establecer el nombre de la dimensión.
     * @param nombre El nombre de la dimensión.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    /**
     * Método para establecer la tabla asociada a esta dimensión.
     * @param tabla La tabla asociada.
     */
    public void setTabla(Tabla tabla) {
        if (tabla == null) {
            throw new IllegalArgumentException("La tabla no puede ser nula");
        }
        this.tabla = tabla;
    }

    /**
     * Método para establecer los tipos de datos de las columnas.
     * @param tipos Un mapa con los tipos de datos de las columnas.
     
    public void setTiposDatos(Map<String, String> tipos) {
        if (tipos == null || tipos.isEmpty()) {
            throw new IllegalArgumentException("El mapa de tipos no puede ser nulo o vacío");
        }
        this.tiposDatos = new HashMap<>(tipos); // Aseguramos una copia para inmutabilidad
    }
    */

    public List<String> getJeraquias() {
        return jeraquias;
    }
    
    public String getColumnaJoin() {
        return columnaJoin;
    }

    /**
     * Método para agregar un nuevo tipo de dato a la dimensión.
     * @param columna La columna a la que se le va a asignar el tipo de dato.
     * @param tipo El tipo de dato de la columna.
     
    public void agregarTipoDato(String columna, String tipo) {
        if (columna == null || columna.isEmpty() || tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("La columna y el tipo no pueden ser nulos o vacíos");
        }
        tiposDatos.put(columna, tipo);
    }
    */
    /**
     * Método para imprimir información de la dimensión en la consola.
     */
    public void informacionDimension() {
        System.out.println("Información sobre esta dimensión:");
        System.out.println("\tNombre: " + nombre);
        System.out.println("\tTabla: " + tabla);
        System.out.println("\tcolumna join: " + columnaJoin);
        System.out.println("\tJerarquias: " + jeraquias);
        //System.out.println("\tTipos de datos: " + tiposDatos);
    }

    /**
     * Sobrecarga del método toString para representar la dimensión.
     * @return Representación en cadena de la dimensión.
     */
    @Override
    public String toString() {
        return String.format("Dimension(nombre: %s, tabla: %s, columna join: %s, jerarquias: %s)", nombre, tabla, columnaJoin, jeraquias);
    }
}
