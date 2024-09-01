package model.concreteState;

import model.state.AbstractArquivoState;
import model.state.ArquivoState;

import javax.naming.OperationNotSupportedException;

public class Normal extends AbstractArquivoState implements ArquivoState {
    @Override
    public Long getTamanho(String conteudo) throws IllegalAccessException {
        return Long.valueOf(conteudo.length());
    }

    @Override
    public String ler(String conteudo) throws IllegalAccessException {
        return conteudo;
    }

    @Override
    public String escrever(String escrever) throws IllegalAccessException {
        return escrever;
    }

    @Override
    public AbstractArquivoState bloquear() throws OperationNotSupportedException {
        return new Bloqueado();
    }

    @Override
    public AbstractArquivoState somenteLeitura() throws OperationNotSupportedException {
        return new SomenteLeitura();
    }

    @Override
    public AbstractArquivoState excluir() throws OperationNotSupportedException {
        return new Excluido();
    }
}
