import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import model.*;
import model.caretaker.HistoricoCaretaker;
import model.proxy.LogOperacaoProxy;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;

public class App {
	public void runQ1() throws Exception  {
		Credencial user01 = new Credencial("user01");

		ArquivoHistorico a1 = new ArquivoHistorico(TipoArquivo.TEXTO, "A1", LocalDate.now(), "Oi", EstadoArquivo.NORMAL);
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

		System.out.println("\nModifica valor1");
		a1.escrever(user01,"Testando 1, 2, 3");
		System.out.println("\nGera snapshot");
		historicoCaretaker.geraSnapshot();
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nModifica valor2");
		a1.escrever(user01,"Testando 1, 2, 3, 4");
		System.out.println("\nGera snapshot");
		historicoCaretaker.geraSnapshot();
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nModifica valor3");
		a1.escrever(user01,"Testando 1, 2, 3, 4, 5");
		System.out.println("\nGera snapshot");
		historicoCaretaker.geraSnapshot();
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nModifica valor3");
		a1.escrever(user01,"Testando 1, 2, 3, 4, 5, 6");
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nRecupera a snapshot 1");
		historicoCaretaker.desfazer();
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nRecupera a snapshot 2");
		historicoCaretaker.desfazer();
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());

		System.out.println("\nRecupera a snapshot 3");
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

        public void runTesteAll(){
			Credencial tigresa = new Credencial("vip");
			System.out.println("---------------------- TESTE DE ALL ----------------------");
			ArquivoHistorico a4 = new ArquivoHistorico(
				TipoArquivo.BINARIO, 
				"Arquivo 4", LocalDate.now(), 
				"Seja bem vindo arquivo 4", 
				EstadoArquivo.NORMAL);

			LogOperacaoProxy arquivoProtegido = new LogOperacaoProxy(a4);

			ler(arquivoProtegido, tigresa);

			HistoricoCaretaker<ArquivoHistorico.Snapshot> caretaker =  new HistoricoCaretaker<ArquivoHistorico.Snapshot>(a4);

			geraSnapshot(caretaker);

			log(arquivoProtegido);

			escrever(arquivoProtegido, tigresa, "atualização de conteúdo");

			ler(arquivoProtegido, tigresa);
			
			desfazer(caretaker);
			
			ler(arquivoProtegido, tigresa);

			log(arquivoProtegido);

			System.out.println("-------- ADICIONANDO ARQUIVO 4 A PASTA 1 --------");
			Pasta p1 =  new Pasta("Pasta 1", LocalDate.now());
			p1.addFilho(a4);

			System.out.println("-------- TENTANDO ADICIONAR UM ARQUIVO NO OUTRO");
			Arquivo a5 = new Arquivo(
				TipoArquivo.BINARIO, 
				"Arquivo 4", LocalDate.now(), 
				"Seja bem vindo arquivo 4", 
				EstadoArquivo.NORMAL);
			try{
			a4.addFilho(a5);
			}catch(UnsupportedOperationException e){
				System.err.println("0 -- NÃO É POSSÍVEL ADICIONAR UM ARQUIVO A OUTRO");
			}

			bloquear(arquivoProtegido);

			ler(arquivoProtegido, tigresa);

			escrever(arquivoProtegido, tigresa, "teste 1 de escrita");

			tamanho(arquivoProtegido);

			liberar(arquivoProtegido);

			ler(arquivoProtegido, tigresa);

			escrever(arquivoProtegido, tigresa, "teste 2 de escrita");

			geraSnapshot(caretaker);

			tamanho(arquivoProtegido);

			somenteLeitura(arquivoProtegido);

			ler(arquivoProtegido, tigresa);

			escrever(arquivoProtegido, tigresa, "teste 3 de escrita");

			tamanho(arquivoProtegido);

			bloquear(arquivoProtegido);

			liberar(arquivoProtegido);

			escrever(arquivoProtegido, tigresa, "testee de escrita 4");

			excluir(arquivoProtegido);

			ler(arquivoProtegido, tigresa);

			escrever(arquivoProtegido, tigresa, "teste 5 de escrita");

			tamanho(arquivoProtegido);

			restaurar(arquivoProtegido);

			desfazer(caretaker);

			dump(arquivoProtegido);
			
			log(arquivoProtegido);




			
		}

		private void log(LogOperacaoProxy arquivoProtegido){
			String log = arquivoProtegido.doLog();
			System.out.println("1 -- " + log);
		}

		private void ler(EntradaOperavelComEstado a1, Credencial kid){
			try {
				String conteudo = a1.ler(kid);
				System.out.println("1 -- LENDO: " + conteudo);
			} catch (IllegalAccessException e) {
				System.out.println("0 -- LENDO");
			}
		}

		private void dump(EntradaOperavelComEstado a1){
			try {
				String dump = a1.dump();
				System.out.println("1 -- DUMP: " + dump);
			} catch (IllegalAccessException e) {
				System.out.println("0 -- DUMP");
			}
		}

		private void escrever(EntradaOperavelComEstado a1, Credencial kid, String conteudo){
			try {
				a1.escrever(kid, conteudo);
				System.out.println("1 -- ESCREVENDO");
			} catch (IllegalAccessException e) {
				System.out.println("0 -- ESCREVENDO");
			};
		}

		private void tamanho(EntradaOperavelComEstado a1){
			try {
				Long tam = a1.getTamanho();
				System.out.println("1 -- TAMANHO: " + tam); //observar o numero de carateres
			} catch (IllegalAccessException e) {
				System.out.println("0 -- TAMANHO");
			}
		}

		private void excluir(EntradaOperavelComEstado a1){
			try {
				a1.excluir();
				System.out.println("1 -- EXCUINDO EntradaOperavelComEstado");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- EXCLUINDO EntradaOperavelComEstado");
			}
		}

		private void restaurar(EntradaOperavelComEstado a1){
			try {
				a1.liberaOuRestaura();
				System.out.println("1 --EntradaOperavelComEstado RESTAURADO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- FALHA AO RESTAURAR EntradaOperavelComEstado");
			}
		}

		private void liberar(EntradaOperavelComEstado a1){
			try {
				a1.liberaOuRestaura();
				System.out.println("1 --EntradaOperavelComEstado LIBERADO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- FALHA AO LIBERAR EntradaOperavelComEstado");
			}
		}

		private void bloquear(EntradaOperavelComEstado a1){
			try {
				a1.bloquear();
				System.out.println("1 -- EntradaOperavelComEstado BLOQUEADO");
			} catch (OperationNotSupportedException e) {
				System.out.println("0 -- ERRO AO BLOQUEAR EntradaOperavelComEstado");
			}
		}

		private void somenteLeitura(EntradaOperavelComEstado a1){
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
		 app.runQ1();
		// Testes testes = app.new Testes();
		// testes.runTesteMaquinaEstado(); 
		// testes.runTesteMemento();
		// testes.runTesteAll();
	}

}
