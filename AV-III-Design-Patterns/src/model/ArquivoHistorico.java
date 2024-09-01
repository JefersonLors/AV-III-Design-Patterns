package model;

import model.originator.Originador;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;

import java.time.LocalDate;

public class ArquivoHistorico extends Arquivo implements EntradaOperavelComEstado, Originador<ArquivoHistorico.Snapshot> {
	public ArquivoHistorico(TipoArquivo tipoArquivo, String nome, LocalDate dataCriacao, String conteudo, EstadoArquivo estadoInicial) {
		super(tipoArquivo, nome, dataCriacao, conteudo, estadoInicial);
	}

	@Override
	public Snapshot checkpoint() throws IllegalAccessException{
		return new Snapshot(this.dump());
	}

	@Override
	public void restore(Snapshot snapshot) {
		setConteudo(snapshot.getContent());
	}
	public class Snapshot {
		private String content;

		public Snapshot(String content){
			this.content = content;
		}

		private String getContent(){
			return this.content;
		}
	}
}
