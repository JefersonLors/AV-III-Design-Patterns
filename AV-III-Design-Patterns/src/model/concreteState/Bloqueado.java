package model.concreteState;

import model.state.AbstractArquivoState;
import model.state.ArquivoState;

import javax.naming.OperationNotSupportedException;

//CONCRETE STATE NO STATE
public class Bloqueado extends AbstractArquivoState  implements ArquivoState{
    @Override
    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return Long.valueOf(conteudo.length());
    }

    @Override
    public AbstractArquivoState liberaOuRestaura() throws OperationNotSupportedException {
        return new Normal();
    }

}
