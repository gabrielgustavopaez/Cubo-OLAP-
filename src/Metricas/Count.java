package Metricas;

import java.util.List;

public class Count extends Metrica {
   public Count(String nombre) {
      super(nombre);
   }
   @Override
   public Double operacion(List<String> lista){
      Double cantidad = ((double)lista.size());
      return cantidad;
   }
}
