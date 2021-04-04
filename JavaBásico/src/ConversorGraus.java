 /*
  * Conversor De Graus Celsius
  * JAVA
  * 
  * NOME: DAVI RIBEIRO FERNANDES ALEIXO
  * IDADE: 14
  * DATA: 19/02/19
  * 
  * 
 */

import java.util.Scanner;
public class ConversorGraus {
	
	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Qual o valor dos graus?: ");                   //(1*)
		double graus = teclado.nextInt();

		System.out.println("Para oq vc quer converter? (K, Re, Ra, F)");
		System.out.print("----->>>");	                                 //(2*)
		String resposta = teclado.next();

		teclado.close();

		System.out.println("RESULTADO: " + conversorGrausCelsius(graus, resposta));


	}
	public static double conversorGrausCelsius(double graus, String resposta){

		if (resposta.equals("K")) {                  //Função para converter os graus digitado (1*) para oq a pessoa deseja (2*).
			return (graus + 273.15) * 15;	
		} else if (resposta.equals("Re")) {
			return graus * 0.8;
		} else if (resposta.equals("Ra")) {
			return graus * 1.8 + 32 + 459.67;
		} else if (resposta.equals("F")) {
			return graus * 1.8 + 32;
		}
		return graus;

	}
}