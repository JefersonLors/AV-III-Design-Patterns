package model;

import model.resources.TipoArquivo;

import java.time.LocalDate;

public class ArquivoHistorico extends Arquivo implements EntradaOperavel{


	public ArquivoHistorico(TipoArquivo tipoArquivo, String nome, LocalDate dataCriacao, String conteudo) {
		super(tipoArquivo, nome, dataCriacao, conteudo);
	}


}
