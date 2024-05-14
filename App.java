import Clases.Configuracion;
import Clases.Cubo;
import Clases.ReaderCSV;
import Clases.Tabla;

public class App {
    public static void main(String[] args) throws Exception {
        //funcion merge Tablas
        //clase Configuracion

        Tabla tablaventas = ReaderCSV.ReadFileCSV("./files/ventas.csv");
        tablaventas.mostrar();
        Configuracion config = new Configuracion("./files/fechas.csv", "dim fechas");
        Cubo cuboOlap = new Cubo(config);
        cuboOlap.verDimensiones();
    }
}
