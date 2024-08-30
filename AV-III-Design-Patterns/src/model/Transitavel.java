package model;

import javax.naming.OperationNotSupportedException;

public interface Transitavel {
    void somenteLeitura() throws OperationNotSupportedException;
    void excluir() throws OperationNotSupportedException;
    void liberaOuRestaura() throws OperationNotSupportedException;
    void bloquear() throws OperationNotSupportedException;
}
