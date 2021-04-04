
	/*
	 * JOGO DA VELHA
	 * POO JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 19/06/2019
	 */


package JogoDaVelha;

public interface Encapsulamento {
	public abstract void mostrarTabuleiro();
	public abstract void selecionarBloco();
	public abstract boolean condicaoVitoriaEmpate();
	public abstract void passarVez();
}
