package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.model.Instrumento;
import ecommerce.model.Musica;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {
				
		Scanner input = new Scanner(System.in);
		System.out.println("Digite 1 para Cliente, 2 para Funcionário e 3 para Sair: ");
		int opcao;
		
		
		Instrumento i1 = new Instrumento(1,"Guitarra",1,2,199);
		i1.visualizar(null);
		
		Musica m1 = new Musica(2,"Pink Floyd - The Wall",2,2,500);
		m1.visualizar(null);
		
		//Realiza login como Cliente ou Funcionario
		while(true) {
			
			
			try {
				opcao = input.nextInt();
				if (opcao < 1 && opcao > 3) {
					System.out.println("Digite 1, 2 ou 3");
				}
			}catch(InputMismatchException e) {
				System.out.println("\nDigite  valores inteiros");
				input.nextLine();
				opcao = 0;
			}
			
			
			if (opcao == 3) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\n    Loja Musica é Arte!    \n");
				sobre();
				input.close();
				System.exit(0);
			}
		
		
		
		// Area do Cliente
		if(opcao == 1) {
			
			//Continua o menu até entrar na condição 5 que dá exit no programa
			while(true) {
				
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                Loja Musica é Arte                   ");
				System.out.println("                    (Cliente)                        ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Comprar Produto                      ");
				System.out.println("            2 - Listar todos Produtos                ");
				System.out.println("            3 - Buscar Produto pelo numero           ");
				System.out.println("            4 - Devolver Produto                     ");
				System.out.println("            5 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				System.out.println("                                                     " + Cores.TEXT_RESET);
				
				try {
					opcao = input.nextInt();
					if (opcao < 1 && opcao > 5) {
						System.out.println("Digite uma opção válida");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nDigite  valores inteiros");
					input.nextLine();
					opcao = 0;
				}
				
				
				if (opcao == 5) {
					System.out.println(Cores.TEXT_WHITE_BOLD + "\n    Loja Musica é Arte!    ");
					System.out.println(Cores.TEXT_WHITE_BOLD + "\n       Volte Sempre!     \n");
					sobre();
					input.close();
					System.exit(0);
				}
				
				switch (opcao) {
				case 1: 
					System.out.println(Cores.TEXT_WHITE + "Digite o número do produto que deseja comprar");
					break;
				case 2: 
					System.out.println(Cores.TEXT_WHITE + "Lista de Produtos: ");
					break;
				case 3: 
					System.out.println(Cores.TEXT_WHITE + "Buscar Produto pelo numero: ");
					break;
				case 4: 
					System.out.println(Cores.TEXT_WHITE + "Devolver Produto ");
					break;
				
				default:
					System.out.println("Opçao Inválida");
					break;
					
				}
				
			}
			}

		
		
		
		
		// Area do Funcionario
		if (opcao == 2) {
			
			//continua o menu até entrar na condição 5 que dá exit no programa
			while(true){
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                Loja Musica é Arte                   ");
				System.out.println("                  (Funcionário)                      ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Cadastrar Produto                    ");
				System.out.println("            2 - Listar todos Produtos                ");
				System.out.println("            3 - Buscar Produto pelo número           ");
				System.out.println("            4 - Atualizar Dados do Produto           ");
				System.out.println("            5 - Listar Produtos vendidos             ");					
				System.out.println("            6 - Apagar Produto                       ");
				System.out.println("            7 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				System.out.println("                                                     " + Cores.TEXT_RESET);
				
				
				try {
					opcao = input.nextInt();
					if (opcao < 1 && opcao > 7) {
						System.out.println("Digite uma opção válida");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nDigite  valores inteiros");
					input.nextLine();
					opcao = 0;
				}
				
				
				if (opcao == 7) {
					System.out.println("             Loja Musica é Arte!          ");
					System.out.println("           Obrigado por colaborar!     \n");
					sobre();
					input.close();
					System.exit(0);
				}
				
				switch (opcao) {
				case 1: 
					System.out.println(Cores.TEXT_WHITE + "Cadastro de Produto: ");
					break;
				case 2: 
					System.out.println(Cores.TEXT_WHITE + "Lista de Produtos: ");
					break;
				case 3: 
					System.out.println(Cores.TEXT_WHITE + "Buscar Produto pelo numero: ");
					break;
				case 4: 
					System.out.println(Cores.TEXT_WHITE + "Atualizar Dados do Produto: ");
					break;
				case 5: 
					System.out.println(Cores.TEXT_WHITE + "Lista de Produtos Vendidos: ");
					break;
				case 6: 
					System.out.println(Cores.TEXT_WHITE + "Apagar Produto: ");
					break;
				
				default:
					System.out.println("Opçao Inválida");
					break;
					
				}
			}
			
			
		}

		
		}

			
		
		
		
	}
	
	  public static void sobre() {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
							 + "*********************************************************");
			System.out.println("Projeto Desenvolvido por:                                ");
			System.out.println("Generation Brasil - pedrowesleyfs@gmail.com              ");
			System.out.println("github.com/Pedro-Musart/projeto_final_bloco_01           ");
			System.out.println("*********************************************************");
		   }

}
