package Clases;
import java.util.ArrayList;
import java.util.List;

public class Tabla {
    private List<List<String>> tabla;
    private int columnas;
    private int filas;
    private List<String> columnas_nombres;

    public Tabla(List<List<String>> tabla) {
        //System.out.println(tabla);
        //CONTROLAR LOS VALORES DEL ANTES DE ASIGNAR (EXCEPTIONS)
        this.tabla =  tabla.subList(1, tabla.size());//no controlado
        this.filas = this.tabla.size()>1? this.tabla.size(): 0;
        this.columnas = this.filas >= 1? tabla.get(0).size(): 0;
        this.columnas_nombres = filas > 0?  tabla.get(0): null;
    }
    private int posColumn(String columna){
        //regresa la posicion de la columna en this.columnas_nombres
        int pos = 0;
        for (int i = 0; i < columnas_nombres.size(); i++) {
            if(columna.equals(columnas_nombres.get(i))){
                pos = i;
            }
        }
        return pos;
    }
    public List<String> getColumnValues(String columna){

        List<String> columna_valores = new ArrayList<>();
        if(columnas_nombres.contains(columna)){
           int pos = posColumn(columna);
           
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
