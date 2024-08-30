package model.resources;

import model.concreteState.Bloqueado;
import model.concreteState.Excluido;
import model.concreteState.Normal;
import model.concreteState.SomenteLeitura;
import model.state.AbstractArquivoState;

public enum EstadoArquivo {
    NORMAL(1),
    SOMENTE_LEITURA(2),
    BLOQUEADO(3),
    EXCLUIDO(4);

    private int codigoEstado;

    EstadoArquivo(int codigoEstado){
        this.codigoEstado = codigoEstado;
    }
    public int getCodigoEstado(){
        return this.codigoEstado;
    }

    public AbstractArquivoState getArquivoState(int codigoEstado){
        AbstractArquivoState estado = null;
        switch (codigoEstado){
            case 1:
                estado = new Normal();
                break;
            case 2:
                estado = new SomenteLeitura();
                break;
            case 3:
                estado = new Bloqueado();
                break;
            case 4:
                estado = new Excluido();
                break;
        }
        return estado;
    }
}
