package Clases;

// Importaciones necesarias para utilizar las clases de listas de Java
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Cubo representa un cubo OLAP con múltiples dimensiones.
 */
public class Cubo {
    // Lista de dimensiones del cubo
    private List<Dimension> dimensiones;
    
    /**
     * Constructor de la clase Cubo.
     * 
     * @param config La configuración utilizada para crear el cubo. Esta configuración 
     *               incluye la URL del archivo CSV y el nombre de la dimensión.
     */
    public Cubo(Configuracion config) {
        // Inicializa la lista de dimensiones como una nueva instancia de ArrayList
        this.dimensiones = new ArrayList<>();

        // Lee el archivo CSV usando el método ReadFileCSV de la clase ReaderCSV
        // y guarda los datos en una tabla llamada tablaFechas
        Tabla tablaFechas = ReaderCSV.ReadFileCSV(config.getUrl());

        // Crea una nueva dimensión utilizando la tabla de datos y el nombre de la dimensión
        Dimension dim = new Dimension(tablaFechas, config.getName());

        // Agrega la nueva dimensión a la lista de dimensiones del cubo
        dimensiones.add(dim);
    }

    /**
     * Método para visualizar las dimensiones del cubo.
     * Actualmente, solo muestra la primera dimensión de la lista.
     */
    public void verDimensiones() {
        // Obtiene la primera dimensión de la lista de dimensiones (índice 0)
        // y llama al método verDimension() de esa dimensión para mostrar su contenido
        dimensiones.get(0).verDimension();
    }
}
