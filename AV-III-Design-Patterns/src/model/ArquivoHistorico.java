package model;

import model.originator.Originador;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;

import java.time.LocalDate;

//ORIGINATOR NO MEMENTO
// //LEAF NO COMPOSITE
// //CONTEXT NO STRATEGY
// //CONTEXT NO STATE
// //REAL SUBEJECT NO PROXY

public class ArquivoHistorico extends Arquivo implements EntradaOperavelComEstado, Originador<ArquivoHistorico.Snapshot> {
	public ArquivoHistorico(TipoArquivo tipoArquivo, String nome, LocalDate dataCriacao, String conteudo, EstadoArquivo estadoInicial) {
		super(tipoArquivo, nome, dataCriacao, conteudo, estadoInicial);
	}

	@Override
	public Snapshot checkpoint(){
		return new Snapshot(this.getConteudo());
	}

	@Override
	public void restore(Snapshot snapshot) {
		setConteudo(snapshot.getContent());
	}

	//MEMENTO NO MEMENTO
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
