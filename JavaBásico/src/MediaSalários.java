 /*
  * M�dia dos Sal�rios
  * JAVA
  * 
  * NOME: DAVI RIBEIRO FERNANDES ALEIXO
  * IDADE: 14
  * DATA (�ltima atualiza��o): 16/02/19
  * 
  * 
 */

import java.util.Scanner;
public class MediaSal�rios {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		float TotSalarios = 0;
		
		System.out.print("Quantos funcion�rios s�o: ");       //(1*)
		int funcionarios = teclado.nextInt();
		System.out.println("=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=");

		for (int i = 1; i <= funcionarios; i++) {                  //Perguntar� o sal�ria igual ao n�mero de funcin�rios digitado (1*)
			System.out.print("Qual o sal�rio do " + i + " funcion�rio: ");
			float salario = teclado.nextInt();   
			System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
			TotSalarios += salario;                              //Recebendo todos os valores de todos os sal�rios e adiconando a 1 vari�vel
		}
		
		teclado.close();
		System.out.println("A M�DIA DOS SAL�RIOS �: " + calcularMedia(TotSalarios, funcionarios));
	}
	
	public static float calcularMedia (float TotSalarios, int funcionarios) {
			return TotSalarios / funcionarios;                                   //Fun��o para retornar a m�dia (todos os sal�rios divido pelo numeros de funcin�rios)
	}
}