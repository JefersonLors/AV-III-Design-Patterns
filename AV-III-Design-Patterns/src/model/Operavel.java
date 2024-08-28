package model;

public interface Operavel {
	
	public String dump();
	public String ler(Credencial credencial) throws IllegalAccessException;
	public void escrever(Credencial credencial, String escrever) throws IllegalAccessException;

}
