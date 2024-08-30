package model.concreteState;

import model.state.AbstractArquivoState;

import javax.naming.OperationNotSupportedException;

public class Bloqueado extends AbstractArquivoState {
    @Override
    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return Long.valueOf(conteudo.length());
    }

    @Override
    public AbstractArquivoState liberaOuRestaura() throws OperationNotSupportedException {
        return new Normal();
    }

}
