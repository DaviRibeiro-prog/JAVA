	
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
		
		while (true) {                                 // ENQUANTO A REPETI��O N�O FOR QUEBRADA PELO BREAK DA CONDICAO DE VITORIA E EMPATE O JOGO CONTINUAR� *1
			
			jdv.mostrarTabuleiro();		               // MOSTRA O TABULEIRO
			jdv.selecionarBloco();			           // JOGADOR SELECIONA O BLOCO 
			
			if (jdv.condicaoVitoriaEmpate()) {                                        // M�TODO QUE ANALIZA AS CONDICOES DE EMPATE E VIT�RIA
				jdv.mostrarTabuleiro();	                                              // MOSTRA O TABULEIRO NOVAMENTE MAS ATUALIZADO PARA VER O RESULTADO FINAL
				System.out.printf("\nJOGADOR (%S) GANHOU!!", jdv.getJogador());       //MOSTRA QUEM GANHOU, SE EMPATOU, ENT�O IR� APARECER OUTRO PRINT QUE ESTA DENTRO DO M�TODO DE CONDI��O 
				break;    // *1
			}
			
			jdv.passarVez();                           //M�TODO QUE PASSA A VEZ PARA O PR�XIMO JOGADOR (X, O)
		}
		
      
	}

}
