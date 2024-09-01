package model.resources;

import model.concreteStrategy.Conversor2Bin;
import model.strategy.Conversor;

public enum TipoArquivo {
    BINARIO(1),
    HEXADECIMAL(2);
    private int codigoTipoArquivo;

   TipoArquivo(int codigoTipoArquivo){
       this.codigoTipoArquivo = codigoTipoArquivo;
   }
   public Conversor getConversor(int codigoTipoArquivo){
       Conversor conversor = null;
       switch (codigoTipoArquivo) {
           case 1:
               conversor = new Conversor2Bin();
               break;
       }
       return conversor;
   }
   public int getCodigo(){
       return this.codigoTipoArquivo;
   }
}
