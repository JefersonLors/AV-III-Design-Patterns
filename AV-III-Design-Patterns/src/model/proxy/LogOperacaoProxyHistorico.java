package model.proxy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import model.ArquivoHistorico;
import model.ArquivoHistorico.Snapshot;
import model.Credencial;
import model.Entrada;
import model.EntradaOperavelComEstado;
import model.originator.Originador;
//PROXY NO PROXY
public class LogOperacaoProxyHistorico implements EntradaOperavelComEstado, Originador<ArquivoHistorico.Snapshot> {

    private ArquivoHistorico arquivo;
	private Map<Credencial, Integer> log;

    public LogOperacaoProxyHistorico(ArquivoHistorico arquivo) {
		this.arquivo = arquivo;
		this.log = new HashMap<Credencial, Integer>();
	}

    @Override
	public String getNome() {
		return this.arquivo.getNome();
	}

	@Override
	public LocalDate getDataCriacao() {
		return this.arquivo.getDataCriacao();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		return this.arquivo.getTamanho();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException {
		return this.arquivo.getFilhos();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException {
		this.arquivo.addFilho(entrada);
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException {
		this.arquivo.removeFilho(entrada);
	}

	@Override
	public String ler(Credencial credencial) throws IllegalAccessException {
		String conteudo = this.arquivo.ler(credencial); 
		Integer acessado = (this.log.get(credencial) == null) ? 0 : this.log.get(credencial);
		acessado++;
		this.log.put(credencial, acessado);
		return conteudo;
	}
	
	
	public String doLog() {
		StringBuffer str = new StringBuffer("LOG DE ACESSO ARQUIVO " + this.arquivo.getNome() + "\n");
		for(Credencial c : this.log.keySet())
			str.append(c.getId() + ": " + this.log.get(c).longValue() + " acessos\n");
		return str.toString();
	}

	@Override
	public void escrever(Credencial credencial, String escrever) throws IllegalAccessException {
		this.arquivo.escrever(credencial, escrever);
		Integer acessado = (this.log.get(credencial) == null) ? 0 : this.log.get(credencial);
		acessado++;
		this.log.put(credencial, acessado);
	}

	@Override
	public void somenteLeitura() throws OperationNotSupportedException {
		this.arquivo.somenteLeitura();
	}

	@Override
	public void excluir() throws OperationNotSupportedException {
		this.arquivo.excluir();
	}

	@Override
	public void liberaOuRestaura() throws OperationNotSupportedException {
		this.arquivo.liberaOuRestaura();
	}

	@Override
	public void bloquear() throws OperationNotSupportedException {
		this.arquivo.bloquear();
	}

	@Override
	public String dump() throws IllegalAccessException{
		return this.arquivo.dump();
	}

    @Override
    public ArquivoHistorico.Snapshot checkpoint() {
        return this.arquivo.checkpoint();
    }

    @Override
    public void restore(Snapshot snapshot) {
        this.arquivo.restore(snapshot);
    }
    
}
