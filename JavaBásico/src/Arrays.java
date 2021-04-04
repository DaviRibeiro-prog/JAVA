	/*
	 * ARRAYS
	 * JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 12/05/2018
	 */



import java.util.Scanner;


public class Arrays {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String resposta = "s";	
		
		System.out.print("Quantas casas ter� o array?: ");
		int NumeroCasa = teclado.nextInt();
		
		int array[] = new int[NumeroCasa];					// Criac�o do array, e escolha de quantas casas ele ter�

		
		while (resposta.equals("s")) {
			System.out.print("Qual n�mero voce deseja: ");					// Escolha do numero  *1
			int numero = teclado.nextInt();
			
			System.out.println("-------------------------");
			
			System.out.print("Em qual casa?: ");							// Em qual casa o numero escolhido ficara  *1
			int casa = teclado.nextInt();
			
			array[casa] = numero;
			
			System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			
			for (int valor : array) {
				System.out.print(valor + " ");								// Mostrando o array e o n�mero na casa escolhida
			}	
			
			System.out.println("");
			System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			
			System.out.print("Quer continuar? (s or n): ");						// Pergunta se o usuario ira continuar 
			resposta = teclado.next();
			
			if (!resposta.equals("s") && !resposta.equals("n")) {				// Sistema de erro (valor inv�lido)
				System.out.println("VALOR DIGITADO INV�LIDO");
				System.exit(0);
			}
			
		}
		
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.println("OBRIGADO");
		teclado.close();
		
	}
}