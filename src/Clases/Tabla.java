package Clases; 
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas redimensionables
import java.util.HashMap; // Importa la clase HashMap para manejar mapas clave-valor
import java.util.HashSet; // Importa la clase HashSet para manejar conjuntos sin duplicados
import java.util.List; // Importa la interfaz List para manejar listas
import java.util.Map; // Importa la interfaz Map para manejar mapas clave-valor
import java.util.Set; // Importa la interfaz Set para manejar conjuntos sin duplicados 

public class Tabla {
    private Map<String, Integer> posicionesColumnas; // Mapa para almacenar la posición de cada columna
    private List<String> columnas_nombres; // Lista de nombres de columnas (encabezados)
    private List<List<String>> tabla; // Lista de listas que almacena los datos de la tabla
    private int columnas; // Número de columnas en la tabla
    private int filas; // Número de filas en la tabla

    // Constructor vacío para evitar errores en ciertas situaciones
    public Tabla(){}

     // Constructor que toma una lista de listas de Strings (datos de la tabla)
    public Tabla(List<List<String>> tabla) throws IllegalArgumentException {

         // Valida que la tabla no sea nula, vacía o que no tenga encabezados
        if (tabla == null || tabla.isEmpty() || tabla.get(0).isEmpty()) {
            throw new IllegalArgumentException("Tabla cannot be null, empty, or have empty first row (headers)");
        }
        // Copia defensiva de los datos, omitiendo la primera fila (encabezados)
        this.tabla = new ArrayList<>(tabla.subList(1, tabla.size())); 
        // Copia defensiva de los encabezados 
        this.columnas_nombres = new ArrayList<>(tabla.get(0)); 
        // Establece el número de filas 
        this.filas = this.tabla.size();
         // Establece el número de columnas si hay filas, de lo contrario 0
        this.columnas = this.filas > 0 ? tabla.get(0).size() : 0;
        posicionesColumnas = new HashMap<>();

        // Llena el mapa de posiciones de columnas con los nombres de las columnas y sus índices
        for (int i = 0; i < columnas_nombres.size(); i++) {
            posicionesColumnas.put(columnas_nombres.get(i), i);
        }
    }

    // Método para unir dos tablas basadas en dos columnas específicas
    public Tabla joinTables(Tabla a, Tabla b, String columna){
        Tabla union = new Tabla();

        return union;
    }


    public Tabla joinTables(Tabla a, Tabla b, String columnaA, String columnaB) {
        // Valida que las columnas no sean nulas y que existan en ambas tablas
        if (columnaA == null || columnaB == null || !a.columnas_nombres.contains(columnaA) || !b.columnas_nombres.contains(columnaB)) {
            throw new IllegalArgumentException("Invalid join columns");
        }
        
        // Identifica las filas coincidentes basadas en las columnas de unión
        Set<List<String>> matchingRows = new HashSet<>();
        // Obtiene la posición de la columna en la primera tabla
        int posColA = a.getColumnPosition(columnaA);
        // Obtiene la posición de la columna en la segunda tabla
        int posColB = b.getColumnPosition(columnaB);
        
        for (List<String> rowA : a.tabla) {
            for (List<String> rowB : b.tabla) {
                // Compara los valores de las columnas de unión
                if (rowA.get(posColA).equals(rowB.get(posColB))) {
                    matchingRows.add(rowA); // Añade la fila de la primera tabla
                    matchingRows.add(rowB); // Añade la fila de la segunda tabla
                    break; // Evita duplicados si múltiples filas en B coinciden con una fila en A
                }
            }
        }

        // Crea la estructura de la nueva tabla unida
        List<String> joinedColumns = new ArrayList<>();

         // Añade todas las columnas de la primera tabla
        // Añade las columnas de la segunda tabla que no están en la primera
        joinedColumns.addAll(a.columnas_nombres); 
        for (String colName : b.columnas_nombres) {
            if (!joinedColumns.contains(colName)) {
                joinedColumns.add(colName);
            }
        }

        // Crea una nueva instancia de Tabla
        Tabla joinedTable = new Tabla();
        // Establece los nombres de las columnas de la tabla unida
        joinedTable.columnas_nombres = joinedColumns;

        // Llena la tabla unida con los datos coincidentes
        for (List<String> row : matchingRows) {
            joinedTable.tabla.add(new ArrayList<>(row));
        }
        // Establece el número de filas de la tabla unida
        joinedTable.filas = joinedTable.tabla.size();
        // Establece el número de columnas de la tabla unida
        joinedTable.columnas = joinedTable.columnas_nombres.size();
        // Llena el mapa de posiciones de columnas
        joinedTable.posicionesColumnas = new HashMap<>();
        for (int i = 0; i < joinedTable.columnas_nombres.size(); i++) {
            joinedTable.posicionesColumnas.put(joinedTable.columnas_nombres.get(i), i);
        }

        // Devuelve la tabla unida
        return joinedTable;
    }

    // Método privado para obtener la posición de una columna basada en su nombre
    private int getColumnPosition(String columna) {
        if (!posicionesColumnas.containsKey(columna)) {
            throw new IllegalArgumentException("Columna '" + columna + "' not found in this table");
        }
        return posicionesColumnas.get(columna);
    }
    
    // Método para obtener los valores de una columna específica
    public List<String> getColumnValues(String columna){
        List<String> columna_valores = new ArrayList<>();
        if(columnas_nombres.contains(columna)){
           int pos = getColumnPosition(columna);
           
           for (List<String> fila: tabla) {
                columna_valores.add(fila.get(pos));
           }
        }
        return columna_valores;
    }

    // Método para imprimir información sobre la tabla
    public void info(){
        System.out.println("Tabla con " + this.filas + " filas y "+this.columnas+" columnas.");
        System.out.println("Cuyas columnas son: " + this.columnas_nombres.toString());
    }

    // Método para mostrar los primeros 10 registros de la tabla
    public void mostrar(){
        int count = 0;
        // Imprime los nombres de las columnas
        System.out.println(columnas_nombres);
        for (List<String> list : tabla) {
            System.out.println(list); // Imprime cada fila de datos
            if (count > 10) {
                break; // Detiene la impresión después de 10 filas
            }
            count++;
        }
    }

}
