package resources.combinacao;

public class Fatorial {

	public static double Fatorial(int n, int p) {
		double fatorialp = 1;
		double fatorialn = 1;

		while (p > 0) {
			fatorialp *= p--;
			fatorialn *= n--;
		}
		
		double resultado = (double) (fatorialn / fatorialp);
		return resultado;
	}

}
