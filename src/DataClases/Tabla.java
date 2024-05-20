package DataClases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabla {
    private Map<String, List<String>> tabla;
    private List<String> columnas;
    private int filas; 

    public Tabla() {
        this.tabla = new HashMap<>();
        this.columnas = new ArrayList<>();
        this.filas = 0;
    }
        // Método para editar una fila de una columna específica
    public void editarFila(String nombreColumna, int numeroFila, String nuevoValor) {
        if (!tabla.containsKey(nombreColumna)) {
            throw new IllegalArgumentException("La columna no existe");
        }
        if (numeroFila < 0 || numeroFila >= filas) {
            throw new IllegalArgumentException("El número de fila es inválido");
        }
        tabla.get(nombreColumna).set(numeroFila, nuevoValor);
    }

    public Tabla(List<List<String>> datos) {
        if (datos == null || datos.isEmpty() || datos.get(0).isEmpty()) {
            throw new IllegalArgumentException("Tabla cannot be null, empty, or have empty first row (headers)");
        }
        this.tabla = new HashMap<>();

        List<String> encabezados = datos.get(0);
        this.columnas = new ArrayList<>(encabezados);
        List<List<String>> data = new ArrayList<>(datos.subList(1, datos.size()));
        this.filas = data.size();
        for (int i = 0; i < encabezados.size(); i++) {
            String Columna = encabezados.get(i);

            List<String> valoresColumnaN = new ArrayList<>();
            for (List<String> listaInterna : data) {
                if (listaInterna.size() > i) {
                    valoresColumnaN.add(listaInterna.get(i));
                }
            }
            //seteando los datos
            this.tabla.put(Columna, valoresColumnaN);
        }
    }
    private List<String> crearColumnaVacia(){
        List<String> columna = new ArrayList<>();
        for (int i = 0; i < this.filas; i++) {
            columna.add("");
        }
        return columna;
    }
    public void agregarColumna(String columna){
        if(!columnas.contains(columna) && !tabla.containsKey(columna)){
            this.columnas.add(columna);
            this.tabla.put(columna, crearColumnaVacia());
            //System.out.println("Se agrego la columna: " + columna);
        }
        
    }
    public void agregarColumnas(List<String> nuevasColumnas){
        for (String col : nuevasColumnas) {
            this.agregarColumna(col);
        }
    }
    private Boolean contieneColumna(String columna){
        return columnas.contains(columna);
    }
    private List<String> getColumna(String columna){
        return tabla.get(columna);
    }
    
    // Método para obtener un mapa con los valores de la fila que coincida en cierta columna con cierto valor
    public Map<String, String> obtenerFilaPorValor(String nombreColumna, String valor) {
        if (!tabla.containsKey(nombreColumna)) {
            throw new IllegalArgumentException("La columna no existe");
        }
        
        // Encontrar el índice de la fila que tiene el valor en la columna dada
        List<String> columnaDatos = tabla.get(nombreColumna);
        for (int i = 0; i < columnaDatos.size(); i++) {
            if (columnaDatos.get(i).equals(valor)) {
                // Crear un mapa con los valores de la fila encontrada
                Map<String, String> fila = new HashMap<>();
                for (String columna : columnas) {
                    fila.put(columna, tabla.get(columna).get(i));
                }
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
        if(!a.contieneColumna(col_a) || !b.contieneColumna(col_b)){
            throw new IllegalArgumentException("No contienen los indices adecuados para el Join");
        }
        Tabla union = new Tabla();
        union.columnas = a.columnas;
        union.filas = a.filas;
        union.tabla = a.tabla;
        //union ya tiene las columnas de b
        union.agregarColumnas(b.columnas);
        
        for (int i = 0; i < union.filas; i++) {
            String valorColumnaString = union.getColumna(col_a).get(i);
            //obtengo el diccionario
            Map<String, String> filaDeB = b.obtenerFilaPorValor(col_b, valorColumnaString);
            //System.out.println(filaDeB);
            
            for (String col : filaDeB.keySet()) {
                union.editarFila(col, i, filaDeB.get(col));
            }
            
        }
        return union;
    }

    // Método groupBy para agrupar filas por los valores de varias columnas
    public Map<String, List<Map<String, String>>> groupBy(List<String> nombreColumnas) {
        for (String nombreColumna : nombreColumnas) {
            if (!tabla.containsKey(nombreColumna)) {
                throw new IllegalArgumentException("La columna " + nombreColumna + " no existe");
            }
        }

        Map<String, List<Map<String, String>>> agrupaciones = new HashMap<>();

        for (int i = 0; i < filas; i++) {
            // Crear una clave compuesta basada en los valores de las columnas especificadas
            StringBuilder claveCompuesta = new StringBuilder();
            for (String nombreColumna : nombreColumnas) {
                claveCompuesta.append(tabla.get(nombreColumna).get(i)).append(",");
            }
            
            String clave = claveCompuesta.toString();
            clave = clave.substring(0, clave.length() - 1);

            if (!agrupaciones.containsKey(clave)) {
                agrupaciones.put(clave, new ArrayList<>());
            }

            // Crear un mapa con los valores de la fila actual
            Map<String, String> fila = new HashMap<>();
            for (String columna : columnas) {
                fila.put(columna, tabla.get(columna).get(i));
            }
            agrupaciones.get(clave).add(fila);
        }

        return agrupaciones;
    }
    // Método para agregar una fila
    public void agregarFila(List<String> valores) {
        if (valores.size() != columnas.size()) {
            throw new IllegalArgumentException("El número de valores no coincide con el número de columnas");
        }
        for (int i = 0; i < columnas.size(); i++) {
            tabla.get(columnas.get(i)).add(valores.get(i));
        }
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
        for (String nombreColumna : nombreColumnas) {
            if (!tabla.containsKey(nombreColumna)) {
                throw new IllegalArgumentException("La columna " + nombreColumna + " no existe");
            }
        }

        Map<String, Tabla> agrupaciones = new HashMap<>();

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
            List<String> valoresFila = new ArrayList<>();
            for (String columna : columnas) {
                valoresFila.add(tabla.get(columna).get(i));
            }
            agrupaciones.get(clave).agregarFila(valoresFila);
        }

        return agrupaciones;
    }
    /**
     * Imprime la tabla en la consola, mostrando columnas y por ahora solo 10 filas
     */
    public void mostrarTabla() {
        //et<String> claves = this.tabla.keySet();
        System.out.println(columnas);
        for (int i = 0; i < this.filas; i++) {
            if (i > 10) break;
            System.out.println(obtenerFila(i));
        }
        
    }
    public void info(){
        System.out.println("la tabla tiene " + this.filas + " filas.");
    }
    private List<String> obtenerFila(int pos){
        List<String> fila = new ArrayList<>();
        for (String columna : this.columnas) {
            fila.add(tabla.get(columna).get(pos));
        }
        return fila;
    }

    public int getFilas() {
        return filas;
    }

}
