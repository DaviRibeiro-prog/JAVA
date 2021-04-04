
	/*
	 * JOGO DA VELHA
	 * POO JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 19/06/2019
	 */



package JogoDaVelha;

import java.util.Random;
import java.util.Scanner;

public class JDV implements Encapsulamento {
	
	

	
	//---------------------ATRIBUTOS--------------------
	
	Random aleatorio = new Random();
	Scanner teclado = new Scanner(System.in);
	
	private static final String JOGADORES = "XO";                             // CONSTANTE DOS JOGADORES (X, O)
	
	private char blocos[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};    // S�O AS CASAS DO JOGO
	private char jogador = JOGADORES.charAt(aleatorio.nextInt(2));            // VARI�VEL DO JOGADOR ATUAL, ESCOLHE ALEATORIAMENTE ENTRE X, O (jogadores) E RECEBE TAL VALOR A V�RIAVEL JOGADOR 
	private int contagemEmpate = 0;     									  // CONTAGEM DOS EMPATES, SE CHEGAR A 9 � EMPATE
	

	
	
	//---------------------GETTERS E SETTERS--------------

	
		
	public char getJogador() {
		return jogador;
	}

	public void setJogador(char jogador) {
		this.jogador = jogador;
	}
	

	public int getContagemEmpate() {
		return contagemEmpate;
	}

	public void setContagemEmpate(int contagemEmpate) {
		this.contagemEmpate = contagemEmpate;
	}



	
	//--------------------M�TODOS------------------------
	
		@Override
		public void mostrarTabuleiro() {                

			System.out.printf("  | %s | %s | %s |\n", blocos[0], blocos[1], blocos[2]);
			System.out.println("  -------------");
			System.out.printf("  | %s | %s | %s |\n", blocos[3], blocos[4], blocos[5]);   // MOSTRA O TABULEIRO COM AS DIVIS�ES E N�MEROS
			System.out.println("  -------------");                                         
			System.out.printf("  | %s | %s | %s |\n", blocos[6], blocos[7], blocos[8]);
		}
		
		@Override
		public void selecionarBloco() {
			
			while (true) {       													// ENQUANTO A JOGADA N�O FOR V�LIDA ELE CONTINUAR� EM REPETI��O, PEDINDO UM NOVO VALOR

				System.out.printf("\nQual casa voc� ir� marcar (" + getJogador() +"): ");    // USU�RIO DIGITA A CASA DESEJADA
				int blocoSelecionado = teclado.nextInt();
				System.out.println("-------------------------------------");
				
				if (blocos[blocoSelecionado] == 'X' || blocos[blocoSelecionado] == 'O') {    // COLOCOU UMA CASA INV�LIDA

					System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=");
					System.out.println("!!CASA J� SELECIONADO!!");
					System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=");		
					
					mostrarTabuleiro();										//MOSTRA O TABULEIRO NOVAMENTE PARA O JOGADOR N�O SE PERDER NA POSI��O //****
					
				} else {													// COLOCOU UMA CASA V�LIDA
					blocos[blocoSelecionado] = getJogador();	
					contagemEmpate ++;                                      //FOI FEITA UMA JOGADA, ENT�O A CONTAGEM AUMENTA EM 1
					break;
				
				}
			}
		}
			
		
		@Override
		public boolean condicaoVitoriaEmpate() {           //M�TODO QUE ANALIZA AS CONDI��ES DE VIT�RIA E O EMPATE 

			//---------------------------------HORIZONTAIS--------------------------
			
 
			if (blocos[0] == getJogador() & blocos[1] == getJogador() & blocos[2] == getJogador()) {
				return true;
			}

			if (blocos[3] == getJogador() & blocos[4] == getJogador() & blocos[5] == getJogador()) {
				return true;
			}

			if (blocos[6] == getJogador() & blocos[7] == getJogador() & blocos[8] == getJogador()) {
				return true;
			}
			
			//---------------------------------VERTICAIS-------------------------------------
			

			if (blocos[0] == getJogador() & blocos[3] == getJogador() & blocos[6] == getJogador()) {
				return true;
			}

			if (blocos[1] == getJogador() & blocos[4] == getJogador() & blocos[7] == getJogador()) {
				return true;
			}

			if (blocos[2] == getJogador() & blocos[5] == getJogador() & blocos[8] == getJogador()) {
				return true;
			}
			
			//---------------------------------DIAGOINAIS----------------------------------
			

			if (blocos[0] == getJogador() & blocos[4] == getJogador() & blocos[8] == getJogador()) {
				return true;
			}

			if (blocos[6] == getJogador() & blocos[4] == getJogador() & blocos[2] == getJogador()) {
				return true;
			}
			

			
			//---------------------------------EMPATE------------------------------------        
			
			if (contagemEmpate == 9) {
				mostrarTabuleiro();                      // MOSTRA O TABULEIRO NOVAMENTE MAS ATUALIZADO PARA VER O RESULTADO FINAL
				System.out.printf(" \nJOGO EMPATOU!");
				System.exit(0);
				
			}
			
			return false;                                 // SE EMPATE OU AS CONDI��ES DE VIT�RIA FOREM FALSAS, ENT�O RETORNA FALSO
		}
		
		@Override
		public void passarVez() {                         //PASSA A VEZ PARA O PR�XIMO JOGADOR (X, O)

			if (getJogador() == ('X')) {
				setJogador('O');
				
			} else {
				setJogador('X');
			}	
		}
}
