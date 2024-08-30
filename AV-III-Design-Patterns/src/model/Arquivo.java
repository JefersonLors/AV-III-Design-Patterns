package model;

import java.time.LocalDate;
import java.util.List;

import model.composite.AbstractEntrada;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;
import model.state.AbstractArquivoState;
import model.strategy.Conversor;

import javax.naming.OperationNotSupportedException;

public class Arquivo extends AbstractEntrada implements EntradaOperavel{
	private Conversor conversor;
	private String conteudo;
	private AbstractArquivoState estadoAtual;
	public Arquivo(TipoArquivo tipoArquivo, String nome, LocalDate dataCriacao, String conteudo, EstadoArquivo estadoInicial){
		super(nome, dataCriacao);
		this.estadoAtual = estadoInicial.getArquivoState(estadoInicial.getCodigoEstado());
		this.conversor = tipoArquivo.getConversor(tipoArquivo.getCodigo());
		this.conteudo =  this.conversor.converte(conteudo);
	}

	public void bloquear() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.bloquear();
	}
	public void somenteLeitura() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.somenteLeitura();
	}
	public void excluir() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.excluir();
	}
	public void liberaOuRestaura() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.liberaOuRestaura();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		return this.estadoAtual.getTamanho(this.conteudo);
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException{
		return this.estadoAtual.ler(this.conversor.toASCII(this.conteudo));
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		this.conteudo = this.estadoAtual.escrever(this.conversor.converte(this.conteudo));
	}

	@Override
	public String dump(){
		return this.conteudo;
	};

	protected void setConteudo(String conteudo) {
		this.conteudo = this.conversor.converte(conteudo);
	}
}
