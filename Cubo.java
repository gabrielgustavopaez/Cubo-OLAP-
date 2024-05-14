package Clases;

import java.util.ArrayList;
import java.util.List;

public class Cubo {
    private List<Dimension> dimensiones;
    public Cubo(Configuracion config) {
        this.dimensiones = new ArrayList<>();
        Tabla tablaFechas = ReaderCSV.ReadFileCSV(config.getUrl());
        Dimension dim = new Dimension(tablaFechas, config.getName());
        dimensiones.add(dim);
    }
    public void verDimensiones() {
        dimensiones.get(0).verDimension();
    }
}
