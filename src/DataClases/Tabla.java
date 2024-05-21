package DataClases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Mapa que representa la tabla de datos: cada clave es el nombre de una columna y 
   el valor asociado es una lista de valores de esa columna 
   */
public class Tabla {
    private Map<String, List<String>> tabla;
    // Lista que contiene los nombres de todas las columnas de la tabla
    private List<String> columnas;
    // Número de filas en la tabla
    private int filas; 
        
    // Constructor vacío
    public Tabla() {
        /*Inicializa la tabla como un nuevo HashMap, 
          la lista de columnas como un nuevo ArrayList y el contador de filas como 0        
        */         
        this.tabla = new HashMap<>();
        this.columnas = new ArrayList<>();
        this.filas = 0;
    }

    // Método para editar una fila de una columna específica
    public void editarFila(String nombreColumna, int numeroFila, String nuevoValor) {
        // Verifica si la columna existe
        if (!tabla.containsKey(nombreColumna)) {
            throw new IllegalArgumentException("La columna no existe");
        }
        // Verifica si el número de fila es válido
        if (numeroFila < 0 || numeroFila >= filas) {
            throw new IllegalArgumentException("El número de fila es inválido");
        }
        // Actualiza el valor en la fila y columna especificadas
        tabla.get(nombreColumna).set(numeroFila, nuevoValor);
    }

    // Constructor que construye la tabla a partir de una lista de datos
    public Tabla(List<List<String>> datos) {
        if (datos == null || datos.isEmpty() || datos.get(0).isEmpty()) {
            throw new IllegalArgumentException("Tabla cannot be null, empty, or have empty first row (headers)");
        }
        // Inicializa la tabla como un nuevo HashMap
        this.tabla = new HashMap<>();

        // Obtiene los encabezados de la lista de datos
        List<String> encabezados = datos.get(0);
        // Asigna los encabezados a la lista de columnas
        this.columnas = new ArrayList<>(encabezados);
        // Obtiene los datos excluyendo la primera fila (encabezados)
        List<List<String>> data = new ArrayList<>(datos.subList(1, datos.size()));
       // Obtiene los datos excluyendo la primera fila (encabezados)
        this.filas = data.size();
        for (int i = 0; i < encabezados.size(); i++) {
            String Columna = encabezados.get(i);
            // Crea una lista de valores para la columna actual
            List<String> valoresColumnaN = new ArrayList<>();   
             // Agrega los valores correspondientes a la lista
            for (List<String> listaInterna : data) {
                if (listaInterna.size() > i) {
                    valoresColumnaN.add(listaInterna.get(i));
                }
            }
            // seteando los datos
            // Asigna los valores a la tabla usando el nombre de la columna como clave
            this.tabla.put(Columna, valoresColumnaN);
        }
    }
    private List<String> crearColumnaVacia(){
        List<String> columna = new ArrayList<>();
        // Llena la columna con valores vacíos
        for (int i = 0; i < this.filas; i++) {
            columna.add("");
        }
        return columna;
    }

    // Método para crear una columna vacía
    public void agregarColumna(String columna){
        // Verifica si la columna ya existe
        if(!columnas.contains(columna) && !tabla.containsKey(columna)){
            // Agrega la columna a la lista de columnas
            this.columnas.add(columna);
             // Crea una nueva columna vacía y la agrega a la tabla
            this.tabla.put(columna, crearColumnaVacia());
            //System.out.println("Se agrego la columna: " + columna);
        }
        
    }

    // Método para agregar varias columnas a la tabla
    public void agregarColumnas(List<String> nuevasColumnas){
        // Itera sobre cada columna nueva y la agrega a la tabla
        for (String col : nuevasColumnas) {
            this.agregarColumna(col);
        }
    }
    // Método para verificar si la tabla contiene una columna específica
    private Boolean contieneColumna(String columna){
        return columnas.contains(columna);
    }

    // Método para obtener los valores de una columna específica
    private List<String> getColumna(String columna){
        return tabla.get(columna);
    }
    
    // Método para obtener un mapa con los valores de la fila que coincida en cierta columna con cierto valor
    public Map<String, String> obtenerFilaPorValor(String nombreColumna, String valor) {
        // Verifica si la columna existe
        if (!tabla.containsKey(nombreColumna)) {
            throw new IllegalArgumentException("La columna no existe");
        }
        
        // Encontrar el índice de la fila que tiene el valor en la columna dada
        // Busca el valor en la columna y devuelve la fila correspondiente
        List<String> columnaDatos = tabla.get(nombreColumna);
        for (int i = 0; i < columnaDatos.size(); i++) {
            if (columnaDatos.get(i).equals(valor)) {
                // Crear un mapa con los valores de la fila encontrada
                Map<String, String> fila = new HashMap<>();
                for (String columna : columnas) {
                    fila.put(columna, tabla.get(columna).get(i));
                }
                // Elimina la columna de la que se obtuvo el valor de búsqueda
                fila.remove(nombreColumna);
                return fila;
            }
        }
        
        // Si no se encuentra la fila, retornar null o lanzar una excepción
        return null;
    }
    /**
     * Devuelve la union de dos tablas.
     */
    static public Tabla joinTablas(Tabla a, Tabla b, String col_a, String col_b){
        // Verifica si las tablas contienen las columnas para el join
        if(!a.contieneColumna(col_a) || !b.contieneColumna(col_b)){
            throw new IllegalArgumentException("No contienen los indices adecuados para el Join");
        }
        // Inicializa una nueva tabla para almacenar la unión
        Tabla union = new Tabla();
        // Copia las columnas de la primera tabla a la tabla de unión
        union.columnas = a.columnas;
        // Copia el número de filas de la primera tabla a la tabla de unión
        union.filas = a.filas;
         // Copia los datos de la primera tabla a la tabla de unión
        union.tabla = a.tabla;
        // union ya tiene las columnas de b
        union.agregarColumnas(b.columnas);
        
        // Itera sobre las filas de la primera tabla
        for (int i = 0; i < union.filas; i++) {
            // Obtiene el valor en la columna de la primera tabla que se va a unir
            String valorColumnaString = union.getColumna(col_a).get(i);
            // Obtiene la fila de la segunda tabla que tiene el mismo valor en la columna de unión
            Map<String, String> filaDeB = b.obtenerFilaPorValor(col_b, valorColumnaString);
            //System.out.println(filaDeB);
            // Itera sobre cada columna de la fila obtenida de la segunda tabla y actualiza la tabla de unión          
            
            for (String col : filaDeB.keySet()) {
                union.editarFila(col, i, filaDeB.get(col));
            }
            
        }
        // Retorna la tabla de unión
        return union;
    }

    // Método groupBy para agrupar filas por los valores de varias columnas
    public Map<String, List<Map<String, String>>> groupBy(List<String> nombreColumnas) {
        // Verifica si cada columna existe en la tabla
        for (String nombreColumna : nombreColumnas) {
            if (!tabla.containsKey(nombreColumna)) {
                throw new IllegalArgumentException("La columna " + nombreColumna + " no existe");
            }
        }

        // Mapa para almacenar las agrupaciones
        Map<String, List<Map<String, String>>> agrupaciones = new HashMap<>();

        // Itera sobre cada fila de la tabla
        for (int i = 0; i < filas; i++) {
            // Crear una clave compuesta basada en los valores de las columnas especificadas
            StringBuilder claveCompuesta = new StringBuilder();
            for (String nombreColumna : nombreColumnas) {
                claveCompuesta.append(tabla.get(nombreColumna).get(i)).append(",");
            }
            
            // Elimina el último carácter (coma) para formar la clave final
            String clave = claveCompuesta.toString();
            clave = clave.substring(0, clave.length() - 1);

            // Si no existe una agrupación para esta clave, crear una nueva lista
            if (!agrupaciones.containsKey(clave)) {
                agrupaciones.put(clave, new ArrayList<>());
            }

            // Crear un mapa con los valores de la fila actual
            Map<String, String> fila = new HashMap<>();
            for (String columna : columnas) {
                fila.put(columna, tabla.get(columna).get(i));
            }
            // Agregar la fila a la lista de la clave correspondiente
            agrupaciones.get(clave).add(fila);
        }

        return agrupaciones;
    }
    // Método para agregar una fila
    public void agregarFila(List<String> valores) {
        // Verifica si el número de valores coincide con el número de columnas
        if (valores.size() != columnas.size()) {
            throw new IllegalArgumentException("El número de valores no coincide con el número de columnas");
        }
        // Agrega cada valor a la columna correspondiente
        for (int i = 0; i < columnas.size(); i++) {
            tabla.get(columnas.get(i)).add(valores.get(i));
        }
        // Incrementa el contador de filas
        filas++;
    }
    
    /**
     * // Método groupBy para agrupar filas por los valores de varias columnas y devolver subtablas
     * Agrupa las filas por los valores de varias columnas y devuelve subtablas.
     * 
     * @param nombreColumnas una lista de nombres de las columnas para agrupar.
     * @return un mapa donde las claves son combinaciones de valores de las
     *         columnas y los valores son subtablas.
     * @throws IllegalArgumentException si alguna de las columnas no existe.
     */
    public Map<String, Tabla> groupBySubtablas(List<String> nombreColumnas) {
        // Verifica si cada columna existe en la tabla
        for (String nombreColumna : nombreColumnas) {
            if (!tabla.containsKey(nombreColumna)) {
                throw new IllegalArgumentException("La columna " + nombreColumna + " no existe");
            }
        }

        // Mapa para almacenar las agrupaciones
        Map<String, Tabla> agrupaciones = new HashMap<>();

        // Itera sobre cada fila de la tabla
        for (int i = 0; i < filas; i++) {
            // Crear una clave compuesta basada en los valores de las columnas especificadas
            StringBuilder claveCompuesta = new StringBuilder();
            for (String nombreColumna : nombreColumnas) {
                claveCompuesta.append(tabla.get(nombreColumna).get(i)).append("|");
            }
            String clave = claveCompuesta.toString();
            clave = clave.substring(0, clave.length() - 1);

            // Si no existe una subtabla para esta clave, crear una nueva
            if (!agrupaciones.containsKey(clave)) {
                Tabla subtabla = new Tabla();
                for (String columna : columnas) {
                    subtabla.agregarColumna(columna);
                }
                agrupaciones.put(clave, subtabla);
            }

            // Agregar la fila actual a la subtabla correspondiente
            // Crear una lista con los valores de la fila actual
            List<String> valoresFila = new ArrayList<>();
            for (String columna : columnas) {
                valoresFila.add(tabla.get(columna).get(i));
            }
            agrupaciones.get(clave).agregarFila(valoresFila);
        }

        // Retorna el mapa con las subtablas
        return agrupaciones;
    }
    /**
     * Imprime la tabla en la consola, mostrando columnas y por ahora solo 10 filas
     */
    public void mostrarTabla() {
        // Imprime los nombres de las columnas
        //et<String> claves = this.tabla.keySet();
        System.out.println(columnas);
        // Itera sobre las filas e imprime cada una, hasta un máximo de 10 filas
        for (int i = 0; i < this.filas; i++) {
            if (i > 10) break;
            System.out.println(obtenerFila(i));
        }
        
    }

    // Método para imprimir información básica sobre la tabla
    public void info(){
        // Imprime el número de filas en la tabla
        System.out.println("la tabla tiene " + this.filas + " filas.");
    }

    // Método para obtener los valores de una fila específica
    private List<String> obtenerFila(int pos){
        List<String> fila = new ArrayList<>();
        // Itera sobre las columnas y agrega los valores de la fila a la lista
        for (String columna : this.columnas) {
            fila.add(tabla.get(columna).get(pos));
        }
        return fila;
    }

    // Método para obtener el número de filas en la tabla
    public int getFilas() {
        return filas;
    }
}
