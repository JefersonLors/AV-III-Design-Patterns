package model.resources;

import model.concreteStrategy.Conversor2Bin;
import model.concreteStrategy.Conversor2Hex;
import model.strategy.Conversor;

public enum TipoArquivo {
    BINARIO(1),
    HEXADECIMAL(2);
    private int codigoTipoArquivo;


   TipoArquivo(int codigoTipoArquivo){
       this.codigoTipoArquivo = codigoTipoArquivo;
   }
   public Conversor getConversor(int codigoTipoArquivo){
       switch (codigoTipoArquivo) {
           case 1:
               return new Conversor2Bin();
           case 2:
               return new Conversor2Hex();
           default:
               return null;
       }
   }
   public int getCodigo(){
       return this.codigoTipoArquivo;
   }
}
