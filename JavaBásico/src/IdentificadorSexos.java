 /*
  * Identificador de Sexo
  * JAVA
  * 
  * NOME: DAVI RIBEIRO FERNANDES ALEIXO
  * IDADE: 14
  * DATA (�ltima atualiza��o): 17/02/19
  * 
  * 
 */

import java.util.Scanner;
public class IdentificadorSexos {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		float MenorAltura = 100, MaiorAltura = 0, TotalAlturaHomens = 0;
		int NumeroMulheres = 0, NumeroHomens = 0;
		
		System.out.print("Quantas pessoas s�o?: ");
		int NumPessoas = teclado.nextInt();
		System.out.println("-=-=-=-==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=");
		
		for (int i = 1; i <= NumPessoas; i++) {
			System.out.print("Qual a sua altura?: ");
			float altura = teclado.nextFloat();
			
			if (altura > MaiorAltura) {               //Se a altura digitada for maior que a maior altura digitada anteriormente, ent�o MaiorAltura = altura.
				MaiorAltura = altura;
			}			
			if (altura < MenorAltura) {                //Se a altura digitada for menor que a menor altura digitada anteriormente, ent�o MenorAltura = altura
				MenorAltura = altura;
			}
			
			System.out.print("Qual o seu sexo(m, f)?: ");
			String sexo = teclado.next();
			
			if (sexo.equals("m")) {    
				TotalAlturaHomens += altura;             //Se for um homem, a altura digitada no bloco anterior � adicionada a TotAlturaHomens
				NumeroHomens ++;                               //Adiciona +1 ao contador homens (para fazer a m�dia)
				System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
				
			} else if (sexo.equals("f")) {
				NumeroMulheres ++;                       //Se for uma mulher � adicionado +1 ao contador de mulheres
				System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
				
			} else {
				System.out.println("SEXO INV�LIDO");        //Se o sexo digitado foi diferente de "m" ou "f" ele dara erro
				System.exit(0);
			}
		}

		teclado.close();   
		
			
		
		System.out.println("==========================================");
		System.out.printf("Maior altura: %2.2f\t", MaiorAltura);
		System.out.printf("Menor altura: %2.2f\n", MenorAltura);
		
		if (NumeroHomens == 0) {                                           //Se n�o houver homens, como consequ�ncia n�o ter� m�dia
			System.out.println("M�dia da altua dos homens: Sem M�dia");
		}else {
		System.out.println("M�dia da altura dos homens: " + calcularMediaAlturaHomens(TotalAlturaHomens, NumeroHomens));
		}
		
		System.out.println("N�mero de mulheres: " + NumeroMulheres);
		System.out.println("==========================================");
	}
	public static float calcularMediaAlturaHomens (float TotalAlturaHomens, int NumeroHomens) {
		return TotalAlturaHomens / NumeroHomens;
	}
}
