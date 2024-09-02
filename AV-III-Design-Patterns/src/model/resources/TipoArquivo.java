package model.resources;

import model.concreteStrategy.Conversor2Bin;
import model.concreteStrategy.Conversor2Txt;
import model.strategy.Conversor;

public enum TipoArquivo {
    TEXTO(0),
    BINARIO(1);
    private int codigoTipoArquivo;

   TipoArquivo(int codigoTipoArquivo){
       this.codigoTipoArquivo = codigoTipoArquivo;
   }
   public Conversor getConversor(int codigoTipoArquivo){
       Conversor conversor = null;
       switch (codigoTipoArquivo) {
           case 0:
               conversor = new Conversor2Txt();
               break;
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
