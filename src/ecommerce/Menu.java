package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.ProdutoController;
import ecommerce.model.Instrumento;
import ecommerce.model.Musica;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {			
			
		Scanner input = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		
		String nome;
		float preco;
		int opcao, numero , tipo, variacao = 0;
		boolean voltarLogin = false; 
		
		
		//Realiza login como Cliente ou Funcionario
		while(true) {
			
			System.out.println(Cores.TEXT_RESET + "\nDigite 1 para Cliente, 2 para Funcionário e 3 para Sair: ");
			
			try {
				opcao = input.nextInt();
				if (opcao < 1 && opcao > 3) {
					System.out.println("\nDigite 1, 2 ou 3");
				}else {
					voltarLogin = false;
				}
			}catch(InputMismatchException e) {
				System.out.println("\nDigite  valores inteiros");
				input.nextLine();
				opcao = 0;
			}
			
			if (opcao == 3) {
				System.exit(0);
			}
		
		
		// Area do Cliente
		if(opcao == 1 && voltarLogin == false) {
			
			//Continua o menu até entrar na condição 5 que dá exit no programa
			while(voltarLogin == false) {
				
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
						System.out.println("\nDigite uma opção válida");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nDigite  valores inteiros");
					input.nextLine();
					opcao = 0;
				}
				
				
				
				switch (opcao) {
				
				case 1: 
					System.out.println(Cores.TEXT_WHITE + "\nDigite o número do produto que deseja comprar");
					numero = input.nextInt();
					
					produtos.procurarPorNumero(numero);
					
					if(produtos.buscarNaListaProdutos(numero) != null) {;
					System.out.println("\nDeseja finalizar a compra? 1 para SIM e 2 para NÃO");
					int op = input.nextInt();
					
					if(op == 1) {
						produtos.comprar(numero);
						
					}else {
						System.out.println("\nCompra não finalizada!");
					}
					}			
					break;
					
				case 2: 
					System.out.println(Cores.TEXT_WHITE + "\nLista de Produtos: ");
					produtos.listarProdutos();
					break;
					
				case 3: 
					System.out.println(Cores.TEXT_WHITE + "\nDigite o numero do produto: ");
					numero = input.nextInt();
					produtos.procurarPorNumero(numero);
					break;
					
				case 4: 
					System.out.println(Cores.TEXT_WHITE + "\nDigite o número do pedido que deseja devolver: ");
					numero = input.nextInt();
					
					produtos.procurarVendidoPorNumero(numero);
					
					System.out.println("\n Deseja devolver este produto? 1 para SIM e 2 para NÃO");
					int op = input.nextInt();
					
					if(op == 1) {
						produtos.devolver(numero);
					}else {
						System.out.println("\nProduto não devolvido!");
					}
					
					break;
					
				case 5:
					
					System.out.println(Cores.TEXT_WHITE_BOLD + "\n    Loja Musica é Arte!    ");
					System.out.println(Cores.TEXT_WHITE_BOLD + "\n       Volte Sempre!     \n");
					sobre();
					voltarLogin = true;
					opcao = 0;
					break;
				
				default:
					System.out.println("\nOpçao Inválida");
					break;
					
				}
				
			}
			}

		
		
		
		// Area do Funcionario
		if (opcao == 2 && voltarLogin == false) {
			
			//continua o menu até entrar na condição 5 que dá exit no programa
			while(voltarLogin == false){
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
						System.out.println("\nDigite uma opção válida");
					}
				}catch(InputMismatchException e) {
					System.out.println("\nDigite  valores inteiros");
					input.nextLine();
					opcao = 0;
				}
				
				

				switch (opcao) {
				
				case 1: 
					
					System.out.println("\nDigite o Nome do Produto: ");
					input.nextLine();
					nome =  input.nextLine();
					
					
					
					System.out.println("\nDigite o tipo de produto (1 - Instrumento, 2 - Midia Fisica): ");
					input.skip("\\R?");
					
						
						try {
							tipo = input.nextInt();
						}catch(InputMismatchException e) {								
							System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
							break;
						}
					
					
					do {
						if(tipo == 1) {
							System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
									         + "*****************************************************");
							System.out.println("            Digite a Variação do Instrumento:        ");
							System.out.println("*****************************************************");
							System.out.println("                    1 - Percursão                    ");
							System.out.println("                    2 - Corda                        ");					
							System.out.println("                    3 - Sopro                        ");
							System.out.println("                    4 - Teclas                       ");
							System.out.println("*****************************************************");
							System.out.println("                                                     " + Cores.TEXT_RESET);
							
							try {
								variacao = input.nextInt();
							}catch(InputMismatchException e) {								
								System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
								break;
							}
							
							System.out.println("\nDigite o Preço do Instrumento (R$): ");
							
							try {
								preco  =  input.nextFloat();
								produtos.cadastrar(new Instrumento(produtos.gerarNumero(),nome,tipo,variacao,preco));
							}catch(InputMismatchException e) {								
								System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
							}
							
						}else if (tipo == 2) {
							System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
							            	 + "*****************************************************");
							System.out.println("         Digite a Variação da Midia Fisica:          ");
							System.out.println("*****************************************************");
							System.out.println("         		   1 - CD                            ");
							System.out.println("         		   2 - Vinil                         ");
							System.out.println("*****************************************************");
							System.out.println("                                                     " + Cores.TEXT_RESET);					
							
							try {
								variacao = input.nextInt();
							}catch(InputMismatchException e) {								
								System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
								break;
							}
							
							try {
								preco  =  input.nextFloat();
								produtos.cadastrar(new Musica(produtos.gerarNumero(),nome,tipo,variacao,preco));
							}catch(InputMismatchException e) {								
								System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
							}
							
						}else {
							System.out.println("\nVariação Incorreta");
						}
						
					}while(tipo != 1 && tipo != 2);
					
					
					keyPress();
					break;
					
				case 2: 
					System.out.println(Cores.TEXT_WHITE + "\nLista de Produtos: ");
					produtos.listarProdutos();
					keyPress();
					break;
					
				case 3: 
					System.out.println(Cores.TEXT_WHITE + "\nDigite o numero do produto: ");
					numero = input.nextInt();
					produtos.procurarPorNumero(numero);
					
					break;
					
				case 4: 
					System.out.println(Cores.TEXT_WHITE + "\nAtualizar Dados do Produto ");
					System.out.println("\\nDigite o numero do Produto:");
					numero = input.nextInt();
					
					System.out.println("\nDigite o novo Nome do Produto: ");
					input.nextLine();
					nome =  input.nextLine();
					System.out.println("\nDigite o tipo de produto (1 - Instrumento, 2 - Midia Fisica): ");
					input.skip("\\R?");
					try {
						tipo = input.nextInt();
					}catch(InputMismatchException e) {								
						System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
						tipo = 0;
						break;
					}
					
					do {
						if(tipo == 1) {
							System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
									         + "*****************************************************");
							System.out.println("            Digite a Variação do Instrumento:        ");
							System.out.println("*****************************************************");
							System.out.println("                    1 - Percursão                    ");
							System.out.println("                    2 - Corda                        ");					
							System.out.println("                    3 - Sopro                        ");
							System.out.println("                    4 - Teclas                       ");
							System.out.println("*****************************************************");
							System.out.println("                                                     " + Cores.TEXT_RESET);
							
							try {
								variacao = input.nextInt();
							}catch(InputMismatchException e) {								
								System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
								break;
							}
							
							System.out.println("\nDigite o Preço do Instrumento (R$): ");
							
							
							try {
								preco  =  input.nextFloat();
								produtos.atualizar(new Instrumento(numero,nome,tipo,variacao,preco));
							}catch(InputMismatchException e) {								
								System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
							}
							
						}else if (tipo == 2) {
								System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
							            	 + "*****************************************************");
								System.out.println("         Digite a Variação da Midia Fisica:          ");
								System.out.println("*****************************************************");
								System.out.println("         		   1 - CD                            ");
								System.out.println("         		   2 - Vinil                         ");
								System.out.println("*****************************************************");
								System.out.println("                                                     " + Cores.TEXT_RESET);	
							
								try {
									variacao = input.nextInt();
								}catch(InputMismatchException e) {								
									System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
									break;
								}
							
								System.out.println("\nDigite o Preço da Midia Fisica (R$): ");
							
								try {
									preco  =  input.nextFloat();
									produtos.atualizar(new Musica(numero,nome,tipo,variacao,preco));
								}catch(InputMismatchException e) {								
									System.out.println("\nVocê deve entrar com um valor do tipo inteiro.");
								}	
							}else {
								System.out.println("\nVariacao Incorreta");
							}
						}while(variacao != 1 && variacao != 2);
					
					keyPress();
					break;
					
				case 5: 
					System.out.println(Cores.TEXT_WHITE + "\nLista de Produtos Vendidos: ");
					produtos.listarProdutosVendidos();
					keyPress();
					break;
					
				case 6: 
					System.out.println(Cores.TEXT_WHITE + "\nDigite o número do Produto: ");
					numero = input.nextInt();
					produtos.deletar(numero);
					keyPress();
					break;
				case 7:
					
					System.out.println("             Loja Musica é Arte!          ");
					System.out.println("           Obrigado por colaborar!     \n");
					sobre();
					
					voltarLogin = true;
					
					break;
					
				
				default:
					System.out.println("\nOpçao Inválida");
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
	  
		public static void keyPress() {
			
			try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
		}	

}
