package model.concreteState;

import model.state.AbstractArquivoState;

import javax.naming.OperationNotSupportedException;

public class Excluido extends AbstractArquivoState {
    @Override
    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return 0L;
    }

    @Override
    public AbstractArquivoState liberaOuRestaura() throws OperationNotSupportedException {
        return new Normal();
    }


}
