package Clases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tabla {
    private Map<String, Integer> posicionesColumnas;
    private List<String> columnas_nombres;//encabezados
    private List<List<String>> tabla;//datos
    private int columnas;
    private int filas;

    public Tabla(){}//para que no me tire error.
    public Tabla(List<List<String>> tabla) throws IllegalArgumentException {
        // Validate input
        if (tabla == null || tabla.isEmpty() || tabla.get(0).isEmpty()) {
            throw new IllegalArgumentException("Tabla cannot be null, empty, or have empty first row (headers)");
        }
        this.tabla = new ArrayList<>(tabla.subList(1, tabla.size()));  // Defensive copy
        this.columnas_nombres = new ArrayList<>(tabla.get(0));  // Defensive copy
        this.filas = this.tabla.size();
        this.columnas = this.filas > 0 ? tabla.get(0).size() : 0;
        posicionesColumnas = new HashMap<>();

        for (int i = 0; i < columnas_nombres.size(); i++) {
            posicionesColumnas.put(columnas_nombres.get(i), i);
        }
    }

    public Tabla joinTables(Tabla a, Tabla b, String columna){
        Tabla union = new Tabla();

        return union;
    }


    public Tabla joinTables(Tabla a, Tabla b, String columnaA, String columnaB) {
        // Validate input
        if (columnaA == null || columnaB == null || !a.columnas_nombres.contains(columnaA) || !b.columnas_nombres.contains(columnaB)) {
            throw new IllegalArgumentException("Invalid join columns");
        }

        // Identify matching rows based on the join columns
        Set<List<String>> matchingRows = new HashSet<>();
        int posColA = a.getColumnPosition(columnaA);
        int posColB = b.getColumnPosition(columnaB);
        for (List<String> rowA : a.tabla) {
            for (List<String> rowB : b.tabla) {
                if (rowA.get(posColA).equals(rowB.get(posColB))) {
                    matchingRows.add(rowA);
                    matchingRows.add(rowB);
                    break; // Avoid duplicates if multiple rows in B match a row in A
                }
            }
        }

        // Create new table structure for the joined data
        List<String> joinedColumns = new ArrayList<>();
        joinedColumns.addAll(a.columnas_nombres);
        for (String colName : b.columnas_nombres) {
            if (!joinedColumns.contains(colName)) {
                joinedColumns.add(colName);
            }
        }
        Tabla joinedTable = new Tabla();
        joinedTable.columnas_nombres = joinedColumns;

        // Populate the joined table with data
        for (List<String> row : matchingRows) {
            joinedTable.tabla.add(new ArrayList<>(row));
        }
        joinedTable.filas = joinedTable.tabla.size();
        joinedTable.columnas = joinedTable.columnas_nombres.size();
        joinedTable.posicionesColumnas = new HashMap<>();
        for (int i = 0; i < joinedTable.columnas_nombres.size(); i++) {
            joinedTable.posicionesColumnas.put(joinedTable.columnas_nombres.get(i), i);
        }

        return joinedTable;
    }

    private int getColumnPosition(String columna) {
        if (!posicionesColumnas.containsKey(columna)) {
            throw new IllegalArgumentException("Columna '" + columna + "' not found in this table");
        }
        return posicionesColumnas.get(columna);
    }
    
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
    public void info(){
        System.out.println("Tabla con " + this.filas + " filas y "+this.columnas+" columnas.");
        System.out.println("Cuyas columnas son: " + this.columnas_nombres.toString());
    }
    public void mostrar(){
        int count = 0;
        System.out.println(columnas_nombres);
        for (List<String> list : tabla) {
            System.out.println(list);
            if (count > 10) {
                break;
            }
            count++;
        }
    }

}
