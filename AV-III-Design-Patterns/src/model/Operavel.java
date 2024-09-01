package model;

import javax.naming.OperationNotSupportedException;

public interface Operavel {
	public String dump() throws IllegalAccessException;
	public String ler(Credencial credencial) throws IllegalAccessException;
	public void escrever(Credencial credencial, String escrever) throws IllegalAccessException;
}
