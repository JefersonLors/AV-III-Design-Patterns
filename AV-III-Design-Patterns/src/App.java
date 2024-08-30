import java.time.LocalDate;

import model.Arquivo;
import model.Credencial;
import model.EntradaOperavel;
import model.resources.EstadoArquivo;
import model.resources.TipoArquivo;
import model.state.AbstractArquivoState;

public class App {
	public void runQ1() throws Exception  {
		Credencial user01 = new Credencial("user01");
		
		Arquivo a1 = new Arquivo(TipoArquivo.BINARIO, "A1", LocalDate.now(), "Oi", EstadoArquivo.NORMAL);
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());


		a1.escrever(user01,"Novo conteúdo.");
		System.out.println("lendo: " + a1.ler(user01));
		System.out.println("dump: " + a1.dump());
		System.out.println("tamanho:" + a1.getTamanho());
//		EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE");
//		EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE");
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
	
	
	public static void main(String[] args) throws Exception {
		App app = new App();
		app.runQ1();
	}

}
