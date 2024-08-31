import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import model.*;
import model.caretaker.HistoricoCaretaker;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;

public class App {
	public void runQ1() throws Exception  {
		Credencial user01 = new Credencial("user01");

		ArquivoHistorico a1 = new ArquivoHistorico(TipoArquivo.BINARIO, "A1", LocalDate.now(), "Oi", EstadoArquivo.NORMAL);
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		a1.escrever(user01,"Novo conteúdo.");
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		a1.somenteLeitura();
		//a1.escrever(user01,"Era uma vez");
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		a1.liberaOuRestaura();
		a1.escrever(user01,"Era uma vez");
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());


		HistoricoCaretaker<ArquivoHistorico.Snapshot> historicoCaretaker = new HistoricoCaretaker<>(a1);
		System.out.println("\nGera snapshot");
		historicoCaretaker.geraSnapshot();

		System.out.println("\nModifica valor");
		a1.escrever(user01,"Testando 1, 2, 3");
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nRecupera a snapshot");
		historicoCaretaker.desfazer();
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

//		EntradaOperavelComEstado b1 = new Arquivo(TipoArquivo.BINARIO,"B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", EstadoArquivo.NORMAL);
//		EntradaOperavelComEstado c1 = new Arquivo(TipoArquivo.BINARIO,"C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", EstadoArquivo.NORMAL);
//
//		Entrada a = new Pasta("A", LocalDate.now());
//		Entrada b = new Pasta("B", LocalDate.now());
//		Entrada c = new Pasta("C", LocalDate.now());
//		Entrada raiz = new Pasta("/", LocalDate.now());
//
//		raiz.addFilho(a);
//		raiz.addFilho(b);
//
//		a.addFilho(a1);
//
//		b.addFilho(c);
//		b.addFilho(b1);
//
//		c.addFilho(c1);
//
//		try {
//			b1.escrever(user01, "CINCO");
//		}catch(IllegalAccessException ex) {
//			System.out.println("NÃO FOI POSSIVEL ESCREVER EM B1");
//		}
//
//		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
//
//		try {
//			b1.escrever(user01, "CINCO+2");
//		}catch(IllegalAccessException ex) {
//			System.out.println("NÃO FOI POSSIVEL ESCREVER EM B1");
//		}
//
//		try {
//			System.out.println("B1: " + b1.ler(user01));
//		} catch (IllegalAccessException e) {
//			System.out.println("NÃO FOI POSSIVEL LER DE B1");
//		}
//
//		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	}

	public class Testes{
		public void runTesteMaquinaEstado()  {

			//RETORNA 1 EM CASO DE SUCESSO E 0 EM CASO DE ERRO, 
			//COMO DE SE ESPERAR ALGUMAS OPERAÇÕES RETORNARÃO 0 DEPENDENDO DO ESTADO DO ARQUIVO
			Credencial kid = new Credencial("bengala");
			System.out.println("----------TESTE DA MÁQUINA DE ESTADO----------");
			System.out.println("--------------------Arquivo comum--------------------");
			Arquivo a1 = new Arquivo(
				TipoArquivo.BINARIO, 
				"Arquivo 1", 
				LocalDate.now(), 
				"teste no arquivo 1", 
				EstadoArquivo.NORMAL); 
			System.out.println("---------- ESTADO NORMAL ---------");
			
			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 1 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			excluir(a1);

			System.out.println("--------- ESTADO EXCLUIDO ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 2 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			restaurar(a1);

			System.out.println("---------- ESTADO NORMAL ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 3 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			bloquear(a1);

			System.out.println("---------- ESTADO BLOQUEADO ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 4 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			// bloquear(a1);

			liberar(a1);

			System.out.println("---------- ESTADO NORMAL ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 5 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			somenteLeitura(a1);

			System.out.println("---------- ESTADO SOMENTE LEITURA ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 6 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			liberar(a1);

			System.out.println("---------- ESTADO NORMAL ---------");
			
			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 7 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			ler(a1, kid);

			somenteLeitura(a1);

			System.out.println("---------- ESTADO SOMENTE LEITURA ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 8 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			bloquear(a1);

			System.out.println("---------- ESTADO BLOQUEADO ---------");

			ler(a1, kid);

			//dump(a1);

			tamanho(a1);

			escrever(a1, kid, "teste 9 de escrita no arquivo 1");

			//dump(a1);

			tamanho(a1);

			System.out.println("--------------------Arquivo Histórico--------------------");

			Arquivo a2 = new ArquivoHistorico(
				TipoArquivo.BINARIO, 
				"Arquivo 2", 
				LocalDate.now(), 
				"teste no arquivo 2", 
				EstadoArquivo.NORMAL); 

			
				ler(a2, kid);

				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 1 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				excluir(a2);
	
				System.out.println("--------- ESTADO EXCLUIDO ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 2 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				restaurar(a2);
	
				System.out.println("---------- ESTADO NORMAL ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 3 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				bloquear(a2);
	
				System.out.println("---------- ESTADO BLOQUEADO ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 4 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				// bloquear(a2);
	
				liberar(a2);
	
				System.out.println("---------- ESTADO NORMAL ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 5 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				somenteLeitura(a2);
	
				System.out.println("---------- ESTADO SOMENTE LEITURA ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 6 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				liberar(a2);
	
				System.out.println("---------- ESTADO NORMAL ---------");
				
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 7 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				ler(a2, kid);
	
				somenteLeitura(a2);
	
				System.out.println("---------- ESTADO SOMENTE LEITURA ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 8 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);
	
				bloquear(a2);
	
				System.out.println("---------- ESTADO BLOQUEADO ---------");
	
				ler(a2, kid);
	
				//dump(a2);
	
				tamanho(a2);
	
				escrever(a2, kid, "teste 9 de escrita no arquivo 2");
	
				//dump(a2);
	
				tamanho(a2);



		}
		
        public void runTesteMemento(){
			System.out.println("----------------------- TESTE DE MEMENTO -----------------------");
			Credencial Elisa = new Credencial("Sanches");
			ArquivoHistorico a3 = new ArquivoHistorico(
				TipoArquivo.BINARIO, 
				"Arquivo 3", 
				LocalDate.now(), 
				"teste no arquivo 3", 
				EstadoArquivo.NORMAL); 

			HistoricoCaretaker caretaker =  new HistoricoCaretaker<ArquivoHistorico.Snapshot>(a3);

			ler(a3, Elisa);

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "teste de memento, mudança de conteúdo");

			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);

            escrever(a3, Elisa, "mudança ---- 1 ----");

			ler(a3, Elisa);

			escrever(a3, Elisa, "mudança ---- 2 ----");

			ler(a3, Elisa);

			escrever(a3, Elisa, "mudança ---- 3 ----");

			ler(a3, Elisa);

			escrever(a3, Elisa, "---- 4 ----");

			ler(a3, Elisa);

			desfazer(caretaker);
 
			ler(a3, Elisa); 
			// RETORNA "mudança ---- 4 ----"" 
			//POIS A PILHA DE SNAPSHOTS ESTA VAZIA 
			//NESSE CASO O MÉTODO DESFAZER DO CARETAKER NÃO FAZ NADA

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "mudança ---- 5 ----");

			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);

			escrever(a3, Elisa, "mudança ---- 6 ----");

			ler(a3, Elisa);

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "mudança ---- 7 ----");

			ler(a3, Elisa);

			escrever(a3, Elisa, "mudança ---- 8 ----");
			
			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);

			System.out.println("----------------- TESTANDO PILHA DE SNAPSHOTS -----------------");

			escrever(a3, Elisa, "mudança ---- 9 ----");
			
			ler(a3, Elisa);

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "mudança ---- 10 ----");
			
			ler(a3, Elisa);

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "mudança ---- 11 ----");
			
			ler(a3, Elisa);

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "mudança ---- 12 ----");
			
			ler(a3, Elisa);

			geraSnapshot(caretaker);

			escrever(a3, Elisa, "mudança ---- 13 ----");
			
			ler(a3, Elisa);

			geraSnapshot(caretaker);

			System.out.println("--------- COMEÇANDO A DESFAZER --------");

			desfazer(caretaker);

			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);

			desfazer(caretaker);

			ler(a3, Elisa);
			
		}

		private void ler(Arquivo a1, Credencial kid){
			try {
				String conteudo = a1.ler(kid);
				System.out.println("1 -- LENDO: " + conteudo);
			} catch (IllegalAccessException e) {
				System.out.println("0 -- LENDO");
			}
		}

		private void dump(Arquivo a1){
			try {
				String dump = a1.dump();
				System.out.println("1 -- DUMP: " + dump);
			} catch (IllegalAccessException e) {
				System.out.println("0 -- DUMP");
			}
		}

		private void escrever(Arquivo a1, Credencial kid, String conteudo){
			try {
				a1.escrever(kid, conteudo);
				System.out.println("1 -- ESCREVENDO");
			} catch (IllegalAccessException e) {
				System.out.println("0 -- ESCREVENDO");
			};
		}

		private void tamanho(Arquivo a1){
			try {
				Long tam = a1.getTamanho();
				System.out.println("1 -- TAMANHO: " + tam); //observar o numero de carateres
			} catch (IllegalAccessException e) {
				System.out.println("0 -- TAMANHO");
			}
		}

		private void excluir(Arquivo a1){
			try {
				a1.excluir();
				System.out.println("1 -- EXCUINDO ARQUIVO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- EXCLUINDO ARQUIVO");
			}
		}

		private void restaurar(Arquivo a1){
			try {
				a1.liberaOuRestaura();
				System.out.println("1 --ARQUIVO RESTAURADO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- FALHA AO RESTAURAR ARQUIVO");
			}
		}

		private void liberar(Arquivo a1){
			try {
				a1.liberaOuRestaura();
				System.out.println("1 --ARQUIVO LIBERADO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- FALHA AO LIBERAR ARQUIVO");
			}
		}

		private void bloquear(Arquivo a1){
			try {
				a1.bloquear();
				System.out.println("1 -- ARQUIVO BLOQUEADO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- ERRO AO BLOQUEAR ARQUIVO");
			}
		}

		private void somenteLeitura(Arquivo a1){
			try {
				a1.somenteLeitura();
				System.out.println("1 -- SOMENTE LEITURA");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- FALHA AO SETTAR ARQUIVO COMO SOMENTE LEITURA");
			}
		}

		private void geraSnapshot(HistoricoCaretaker caretaker){
			try {
				caretaker.geraSnapshot();
				System.out.println("1 -- SNAPSHOT GERADO COM SUCESSO");
			} catch (IllegalAccessException e) {
				System.out.println("0 -- ERRO A GERAR SNAPSHOT");
			}
		}
        
		private void desfazer(HistoricoCaretaker caretaker){
			caretaker.desfazer();
			System.out.println("1 -- REVERSÃO FEITA COM SUCESSO");
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		App app = new App();
		// app.runQ1();
		Testes testes = app.new Testes();
		testes.runTesteMaquinaEstado(); 
		testes.runTesteMemento();
	}

}
