
	/*
	 * CRUD SQL E JAVA
	 * POO JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 03/01/2020
	 */


package br.com.agenda.aplicacao;

import java.util.Scanner;
import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Contato contato = new Contato();
		ContatoDAO contatoDao = new ContatoDAO();
		

		

		while (true) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("| 1- DELETE	2- SELECT	3- INSERT	4- UPDATE	5- DELETE ALL |");
			System.out.println("-------------------------------------------------------------------------------");
			
			System.out.print("--> ");
			int resposta = teclado.nextInt();
			
			if (resposta > 5 || resposta < 1) {
				System.out.println("THE NUMBER ENTERED WAS WRONG");
			}
			
			if (resposta == 1) {
				System.out.println("What is the target user ID?");
				System.out.print("--> ");
				
				contato.setId(teclado.nextInt());
				contatoDao.delete(contato);
				
			} else if (resposta == 2) {
				contatoDao.select();
				
			} else if (resposta == 3) {
				System.out.println("Register the user here:");
				System.out.println("----------------------------");
				System.out.print("USER NAME: ");
				contato.setNome(teclado.next());
				System.out.println("---------------------------");
				System.out.print("USER AGE: ");
				contato.setIdade(teclado.nextInt());
				System.out.println("----------------------------");
				contato.setDataCadastro(new Date());
				
				contatoDao.insert(contato);
				
				
			} else if (resposta == 4) {
				
				System.out.println("What is the target user ID?");
				System.out.print("--> ");
				contato.setId(teclado.nextInt());
				System.out.println("----------------------------");
				System.out.print("UPDATE USER NAME: ");
				contato.setNome(teclado.next());
				System.out.println("----------------------------");
				System.out.print("UPDATE USER AGE: ");
				contato.setIdade(teclado.nextInt());
				System.out.println("----------------------------");
				contato.setDataCadastro(new Date());
				
				contatoDao.update(contato);
				
			} else if (resposta == 5) {
				contatoDao.deleteAll();
				
			} else {
				System.out.println("Goodbye user!");
				break;
			}
		}


		teclado.close();


	}

}
