 /*
  * Média dos Salários
  * JAVA
  * 
  * NOME: DAVI RIBEIRO FERNANDES ALEIXO
  * IDADE: 14
  * DATA (última atualização): 16/02/19
  * 
  * 
 */

import java.util.Scanner;
public class MediaSalários {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		float TotSalarios = 0;
		
		System.out.print("Quantos funcionários são: ");       //(1*)
		int funcionarios = teclado.nextInt();
		System.out.println("=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=");

		for (int i = 1; i <= funcionarios; i++) {                  //Perguntará o salária igual ao número de funcinários digitado (1*)
			System.out.print("Qual o salário do " + i + " funcionário: ");
			float salario = teclado.nextInt();   
			System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
			TotSalarios += salario;                              //Recebendo todos os valores de todos os salários e adiconando a 1 variável
		}
		
		teclado.close();
		System.out.println("A MÉDIA DOS SALÁRIOS É: " + calcularMedia(TotSalarios, funcionarios));
	}
	
	public static float calcularMedia (float TotSalarios, int funcionarios) {
			return TotSalarios / funcionarios;                                   //Função para retornar a média (todos os salários divido pelo numeros de funcinários)
	}
}