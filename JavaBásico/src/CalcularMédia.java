	/*
	 * CALCULAR M�DIA
	 * JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 03/01/2020
	 */


import java.util.Scanner;
public class CalcularM�dia {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		float TotalNotas = 0;
				
		System.out.println("=====================");
		System.out.println("-----M�DIA--------");
		System.out.println("====================");
		
		System.out.print("Qual o nome do aluno?: ");						// Cadastro do aluno
		String aluno = teclado.nextLine();
		
		System.out.print("Quantas notas s�o?: ");							// Pergunta de Quantas notas s�o no total *1
		int NumeroDeNotas = teclado.nextInt();
		
		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+===+=+=");
		
		for (int i = 1; i <= NumeroDeNotas; i++) {
			System.out.printf("Qual � a %d%s", i, " nota?: ");				// Pergunta de qual � a nota da prova 1, 2, 3 (valor i *1)
			float nota = teclado.nextFloat();
			TotalNotas += nota;
			System.out.println("-----------------------------------");
		}
		
		teclado.close();
		
		
		System.out.printf("A m�dia do aluno %S%s%2.2f\n", aluno, " �: ", calcularMedia(NumeroDeNotas, TotalNotas));	  // Mostrando quanto foi a media do aluno, chamando assim a funcao *2
		System.out.println("+-+--++--++--++--++--++--++--++--++");							
		
		
		if (calcularMedia(NumeroDeNotas, TotalNotas) >= 6) {				// Se o aluno tiver a m�dia maior q 6, ent�o aprovado, se n�o, reprovado
			System.out.println("Aluno APROVADO!");	
		} else {
			System.out.println("Aluno REPROVADO!");
		}
		
		
	}
	private static float calcularMedia(int NumeroDeNotas, float TotalNotas) {			// Fun��o que calcula a media    *2
		return TotalNotas / NumeroDeNotas;
	}
}
