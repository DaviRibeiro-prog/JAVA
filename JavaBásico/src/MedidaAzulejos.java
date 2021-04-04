 /*
  * Quantos Azulejos (cobrir a parede)
  * JAVA
  * 
  * NOME: DAVI RIBEIRO FERNANDES ALEIXO
  * IDADE: 14
  * DATA (�ltima atualiza��o): 02/01/19
  * 
  * 
 */

import java.util.Scanner;
public class MedidaAzulejos {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String resposta = "y";
		
		while (resposta.equals("y")) {                          //Enquanto a reposta for "y" (yes), ele continuar� o programa (1*)
			
			System.out.print("Qual a altura da parede?: ");
			float ap = teclado.nextFloat();
			
			System.out.print("Qual a largura da parede?: ");
			float lp = teclado.nextFloat();
			
			System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
			
			System.out.print("Qual a altura do azulejo?: ");
			float aa = teclado.nextFloat();
			
			System.out.print("Qual a largura do azulejo?: ");
			float la = teclado.nextFloat();
			
			System.out.println("=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-");
			System.out.printf("S�o necess�rios: %10.2f%s\n", calcularAzulejos(ap, lp, aa, la), " azulejo(s) para cobrir a parede!");
			
			System.out.print("Quer continuar (y/n)?: ");                 //(1*)
			resposta = teclado.next();
			
			
			if (!"y".equals(resposta) && !"n".equals(resposta)) {         //Se a resposta for diferente de "y" ou "n" ele da um erro (resposta inv�lida)
				System.out.println("REPOSTA INV�LIDA!");
				System.exit(0);

			}
			System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

		}
		System.out.println("PROGRAMA ENCERRADO!");
		teclado.close();
	}

	public static float calcularAzulejos(float ap, float lp, float aa, float la) {          //Fun��o para calcular quantos azulejos ir� precisar para preencher a parede
		return (ap * lp) / (aa * la);
	}
}
