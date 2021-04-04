	
/*
	 * JOGO DA VELHA
	 * POO JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 19/06/2019
	 */

package JogoDaVelha;
public class Principal {
	

	public static void main(String[] args) {
		JDV jdv = new JDV();
		
		while (true) {                                 // ENQUANTO A REPETIÇÃO NÃO FOR QUEBRADA PELO BREAK DA CONDICAO DE VITORIA E EMPATE O JOGO CONTINUARÁ *1
			
			jdv.mostrarTabuleiro();		               // MOSTRA O TABULEIRO
			jdv.selecionarBloco();			           // JOGADOR SELECIONA O BLOCO 
			
			if (jdv.condicaoVitoriaEmpate()) {                                        // MÉTODO QUE ANALIZA AS CONDICOES DE EMPATE E VITÓRIA
				jdv.mostrarTabuleiro();	                                              // MOSTRA O TABULEIRO NOVAMENTE MAS ATUALIZADO PARA VER O RESULTADO FINAL
				System.out.printf("\nJOGADOR (%S) GANHOU!!", jdv.getJogador());       //MOSTRA QUEM GANHOU, SE EMPATOU, ENTÃO IRÁ APARECER OUTRO PRINT QUE ESTA DENTRO DO MÉTODO DE CONDIÇÃO 
				break;    // *1
			}
			
			jdv.passarVez();                           //MÉTODO QUE PASSA A VEZ PARA O PRÓXIMO JOGADOR (X, O)
		}
		
      
	}

}
