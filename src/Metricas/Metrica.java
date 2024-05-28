package Metricas;

import java.util.List;

public abstract class Metrica {
    private String nombre;
    public Metrica(String Nombre) {
        this.nombre = Nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public abstract Double operacion(List<String> lista);
    @Override
    public String toString() {
        return nombre;
    }
}
