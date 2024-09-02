package model.state;

import javax.naming.OperationNotSupportedException;

//ABSTRACT STATE NO STATE
public abstract class AbstractArquivoState implements ArquivoState {
    public Long getTamanho(String conteudo) throws IllegalAccessException{
        throw new IllegalAccessException();
    }
    public String ler(String conteudo) throws IllegalAccessException{
        throw new IllegalAccessException();
    }
    public String escrever(String escrever) throws IllegalAccessException{
        throw new IllegalAccessException();
    }
    public AbstractArquivoState bloquear() throws OperationNotSupportedException{
        return this;
    }
    public AbstractArquivoState somenteLeitura() throws OperationNotSupportedException{
        return this;
    }
    public AbstractArquivoState excluir() throws OperationNotSupportedException{
        return this;
    }
    public AbstractArquivoState liberaOuRestaura() throws OperationNotSupportedException{
        return this;
    }

}
