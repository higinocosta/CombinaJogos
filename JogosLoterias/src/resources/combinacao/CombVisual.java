package resources.combinacao;

import java.util.Arrays;

import br.com.barcomponent.controle.TaskControle;
import br.com.barcomponent.interfaces.Task;

public class CombVisual implements Task {

	public static String[][] temparray;
	private static int totn, lin, n;
	private static double totg;
	//String[] v1 = new ArrayList<>();
	public static String[] linhas;
	GravaCSV gravar = new GravaCSV();
	public static BarProgressExample barraex;// = new BarProgressExample();
	
	//public static BarradeProgresso barra = new BarradeProgresso();
	

	public void Comb2(int n, int m, int k, String s, String[] v)  {

		if (m > n - k + 1) { // se o número de elementos para combinação for maior que a quantidade de
			return; // elementos é encerrado a macro
		}

		if (m == 0) { // quando m for igual a 0 inicia a montagem das combinações

			//*  Antigo
			String[] v1 = s.split(" "); //Transporta numeros TEXTO para array

			Arrays.sort(v1); // ordena o array com combinação
			//temparray[lin] = v1; // amarzena a combinação no array definitivo
			lin++;  //Proxima linha

			System.out.printf("lin -> %d  totg -> %.0f    Executado -> %.2f %% %n",lin,totg,(float) (lin * 100 / totg));
			gravar.GravaCSV(v1); // Grava arquivo

			return;

		}

		Comb2(n, m - 1, k + 1, s + v[k-1] + " ", v); // incrementa as variáveis m utilizada para dar start nas combinações e
		Comb2(n, m, k + 1, s, v); // quando elimina cada bloco de combinação reinicia a Macro Comb2 até que m seja
									// maior que n
	}


	public static void preparaJogos() {
		
		TaskControle t = new TaskControle(new CombVisual());
		totg = Fatorial.Fatorial(n, totn);
		temparray = new String[(int) totg][totn];
		//barra.ativaBarra();
		barraex.ativaBarra();

		// Cabeçalho do tabela de numeros gerados
		linhas = new String[totn];
		for (int i = 0; i < totn; i++) {
			linhas[i] = "N-" + (i + 1);
		}
		
	}

	public static int getTotn() {
		return totn;
	}

	public static void setTotn(int totn) {
		CombVisual.totn = totn;
	}

	public static double getTotg() {
		return totg;
	}

	public static void setTotg(double totg) {
		CombVisual.totg = totg;
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		CombVisual.n = n;
	}
	
	
	@Override
	public void run() {
		//Comb2(getN(),getTotn(),1,"",veto);
		Comb2();
	}
	
	private void Comb2() {
		
	}

	@Override
	public int getProcessado() {
		return (int) ((int) lin * 100 / totg);
	}
	
}
