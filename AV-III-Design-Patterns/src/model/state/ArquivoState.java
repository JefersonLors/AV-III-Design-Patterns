package model.state;

import javax.naming.OperationNotSupportedException;

public interface ArquivoState {
    public Long getTamanho(String conteudo) throws IllegalAccessException;

    public String ler(String conteudo) throws IllegalAccessException;

    public String escrever(String escrever) throws IllegalAccessException;

    public AbstractArquivoState bloquear() throws OperationNotSupportedException;

    public AbstractArquivoState somenteLeitura() throws OperationNotSupportedException;

    public AbstractArquivoState excluir() throws OperationNotSupportedException;

    public AbstractArquivoState liberaOuRestaura() throws OperationNotSupportedException;
}
