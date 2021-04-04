	/*
	 * CALCULAR MÉDIA
	 * JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 03/01/2020
	 */


import java.util.Scanner;
public class CalcularMédia {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		float TotalNotas = 0;
				
		System.out.println("=====================");
		System.out.println("-----MÉDIA--------");
		System.out.println("====================");
		
		System.out.print("Qual o nome do aluno?: ");						// Cadastro do aluno
		String aluno = teclado.nextLine();
		
		System.out.print("Quantas notas são?: ");							// Pergunta de Quantas notas são no total *1
		int NumeroDeNotas = teclado.nextInt();
		
		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+===+=+=");
		
		for (int i = 1; i <= NumeroDeNotas; i++) {
			System.out.printf("Qual é a %d%s", i, " nota?: ");				// Pergunta de qual é a nota da prova 1, 2, 3 (valor i *1)
			float nota = teclado.nextFloat();
			TotalNotas += nota;
			System.out.println("-----------------------------------");
		}
		
		teclado.close();
		
		
		System.out.printf("A média do aluno %S%s%2.2f\n", aluno, " é: ", calcularMedia(NumeroDeNotas, TotalNotas));	  // Mostrando quanto foi a media do aluno, chamando assim a funcao *2
		System.out.println("+-+--++--++--++--++--++--++--++--++");							
		
		
		if (calcularMedia(NumeroDeNotas, TotalNotas) >= 6) {				// Se o aluno tiver a média maior q 6, então aprovado, se não, reprovado
			System.out.println("Aluno APROVADO!");	
		} else {
			System.out.println("Aluno REPROVADO!");
		}
		
		
	}
	private static float calcularMedia(int NumeroDeNotas, float TotalNotas) {			// Função que calcula a media    *2
		return TotalNotas / NumeroDeNotas;
	}
}
