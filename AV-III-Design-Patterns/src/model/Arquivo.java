package model;

import java.time.LocalDate;
import java.util.List;

import model.composite.AbstractEntrada;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;
import model.state.ArquivoState;
import model.strategy.Conversor;

import javax.naming.OperationNotSupportedException;

//LEAF NO COMPOSITE
//CONTEXT NO STRATEGY
//CONTEXT NO STATE
//REAL SUBEJECT NO PROXY
public class Arquivo extends AbstractEntrada implements EntradaOperavelComEstado {
	private Conversor conversor;
	private String conteudo;
	private ArquivoState estadoAtual;
	public Arquivo(TipoArquivo tipoArquivo, String nome, LocalDate dataCriacao, String conteudo, EstadoArquivo estadoInicial){
		super(nome, dataCriacao);
		this.estadoAtual = estadoInicial.getArquivoState(estadoInicial.getCodigoEstado());
		this.conversor = tipoArquivo.getConversor(tipoArquivo.getCodigo());
		this.conteudo =  this.conversor.converte(conteudo);
	}

	@Override
	public void bloquear() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.bloquear();
	}

	@Override
	public void somenteLeitura() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.somenteLeitura();
	}

	@Override
	public void excluir() throws OperationNotSupportedException {
		this.estadoAtual = this.estadoAtual.excluir();
	}

	@Override
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
		var resultado = this.conversor.toASCII(this.conteudo);
		return this.estadoAtual.ler(resultado);
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		this.conteudo = this.estadoAtual.escrever(this.conversor.converte(conteudo));
	}

	@Override
	public String dump() throws IllegalAccessException{
		return this.conteudo;
	};

	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	protected String getConteudo(){
		return this.conteudo;
	}
}
