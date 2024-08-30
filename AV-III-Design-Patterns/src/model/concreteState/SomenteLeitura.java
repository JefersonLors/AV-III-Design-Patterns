package model.concreteState;

import model.state.AbstractArquivoState;
import model.state.ArquivoState;

import javax.naming.OperationNotSupportedException;

public class SomenteLeitura extends AbstractArquivoState implements ArquivoState {
    @Override
    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return Long.valueOf(conteudo.length());
    }

    @Override
    public String ler(String conteudo) throws IllegalAccessException {
        return conteudo;
    }

    @Override
    public AbstractArquivoState bloquear() throws OperationNotSupportedException {
        return new Bloqueado();
    }


    @Override
    public AbstractArquivoState liberaOuRestaura() throws OperationNotSupportedException {
        return new Normal();
    }

}
