package sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus { // Essa classe foi criada com o intuito de diminuir repetição de código.

	static Scanner sc = new Scanner(System.in);
	Cofrinho cofrinho = new Cofrinho();

	public int menuPrincipal() { // Método do menu principal, que ficará em loop, sempre que terminar uma
									// transação no cofrinho.
		int menu = 0; // iniciando a variável fora do escopo do 'do while'.

		do {
			while (true) {
				try {
					System.out.println("\n\n***COFRINHO***\n");
					System.out.println("Menu\n");
					System.out.println("1 - Adicionar moedas");
					System.out.println("2 - Remover moedas moedas");
					System.out.println("3 - Listar moedas moedas");
					System.out.println("4 - Calcular valor do cofrinho em R$");
					System.out.println("0 - Fechar cofrinho");
					System.out.print(">>> ");

					menu = sc.nextInt();
					break;
				} catch (InputMismatchException erro) {
					System.out.println("\nDigite apenas números inteiros!");
					sc.next();
				}
			}
			switch (menu) { // Utilizei a opção de desvio switch case para obter um código menos repetitivo
							// e funcional.

			case 0:
				System.out.println("Encerrando o programa...");
				System.exit(0);

			case 1:
				selecionaAdd();
				break;

			case 2:
				if (cofrinho.listaMoedas.isEmpty()) {
					System.out.println("\nNão existem moedas para serem removidas!");
					break;
				} else {
					selecionaRemovida();
					break;
				}

			case 3:

				cofrinho.listagemMoedas();
				break;

			case 4:

				cofrinho.totalConvertido();
				break;

			default:
				System.out.println("Opção inválida"); // opção para valor incorreto inserido.
			}

		} while (menu != 0);// condição do loop.
		if (menu == 1) {
			return menu;
		} else if (menu == 2) {
			return menu;
		} else {
			return 0;
		}
	}

	public void selecionaAdd() { // Método criado para poupar tempo e repetição de código sem necessidade.
		int select;

		do {
			while (true) { // Laço para que só saia do bloco try quando inserido um dado válido.
				try { // Captura erro de input para evitar que sejam introduzidos caracteres que não
						// sejam números inteiros e quebrar a aplicação.
					System.out.println("\nSelecione a moeda\n");
					System.out.println("1 - Dólar");
					System.out.println("2 - Euro");
					System.out.println("3 - Real");
					System.out.println("0 - Retornar ao menu principal");
					System.out.print(">>> ");
					select = sc.nextInt();
					break;
				} catch (InputMismatchException erro) {
					System.out.println("\nDigite apenas números inteiros!");
					sc.next();
				}
			}
			switch (select) {

			case 0:
				System.out.println("Voltando ao menu anterior...");
				break; // Encerra o loop e retorna.

			case 1:
				System.out.println("Selecionado dólar");
				var dolar = new Dolar(valorMoeda(), null, 0.0);
				cofrinho.adicionar(dolar);
				break;

			case 2:
				System.out.println("Selecionado euro");
				var euro = new Euro(valorMoeda(), null, 0.0);
				cofrinho.adicionar(euro);
				break;

			case 3:
				System.out.println("Selecionado real");
				var real = new Real(valorMoeda(), null, 0.0);
				cofrinho.adicionar(real);
				break;

			default:
				System.out.println("Seleção inválida...");
			}
			break;
		} while (select != 0);
	}

	// Novo método

	public void selecionaRemovida() { // Método criado para poupar tempo e repetição de código sem necessidade.
		int select;

		do {
			while (true) { // Laço para que só saia do bloco try quando inserido um dado válido.
				try {
					System.out.println("\nSelecione a moeda\n");
					System.out.println("1 - Dólar");
					System.out.println("2 - Euro");
					System.out.println("3 - Real");
					System.out.println("0 - Retornar ao menu principal");
					System.out.print(">>> ");
					select = sc.nextInt();
					break;
				} catch (InputMismatchException erro) { // Captura erro de input para evitar que sejam introduzidos
														// caracteres que não sejam números inteiros e quebrar a
														// aplicação.
					System.out.println("\nDigite apenas números inteiros!");
					sc.next();
				}
			}

			switch (select) {

			case 0:
				System.out.println("Voltando ao menu anterior...");
				break; // Encerra o loop e retorna.

			case 1:
				try { // bloco try para evitar puxar moedas inexistentes no cofrinho e gerar alguma
						// excessão que quebre o sistema.
					System.out.println("\nSelecionado dólar");
					var valor = valorMoeda(); // invocação do método que seleciona o valor escolhido de moeda
					// salva em uma variável local.
					for (Moeda m : cofrinho.listaMoedas) { // Laço para iterar na ArrayList cofrinho toda.
						if (m instanceof Dolar) { // Capturando todo m que for objeto da classe Dolar.
							Dolar dolar = (Dolar) m; // Casting de n salvo na variável dolar.
							if (dolar.valor == valor) {
								cofrinho.listaMoedas.remove(dolar);// Se o valor for igual, a moeda é removida.
								break; // Encerrando o laço para não remover uma segunda moeda que possua mesmo
										// valor.
							} else {
								continue;
							}
						}
					}
				} catch (RuntimeException erro) {
					System.out.println("\nOperação não permitida, tente novamente!");
					break;
				}
				break;

			case 2:
				try {
					System.out.println("\nSelecionado euro");
					var valor = valorMoeda(); // invocação do método que seleciona o valor escolhido de
					// moeda e salva em uma variável local.
					for (Moeda m : cofrinho.listaMoedas) { // Laço para iterar na ArrayList cofrinho toda.
						if (m instanceof Euro) { // Capturando todo m que for objeto da classe Euro.
							Euro euro = (Euro) m; // Casting de n salvo na variável euro.
							if (euro.valor == valor) { // Verficiar se o valor do euro iterado é o mesmo do valor
														// da variável local de nome valor.
								cofrinho.listaMoedas.remove(euro);// Se o valor for igual, a moeda é removida.
								break; // Encerrando o laço para não remover uma segunda moeda que possua mesmo
										// valor.
							}
						} else {
							continue;
						}
					}
				} catch (RuntimeException erro) {
					System.out.println("\nNão existem moedas desse tipo & valor no cofrinho!");
					break;
				}
				break;

			case 3:

				try {
					System.out.println("\nSelecionado real");
					var valor = valorMoeda(); // invocação do método que seleciona o valor escolhido de
					// moeda e salva em uma variável local.
					for (Moeda m : cofrinho.listaMoedas) { // Laço para iterar na ArrayList cofrinho toda.
						if (m instanceof Real) { // Capturando todo m que for objeto da classe Real.
							Real real = (Real) m; // Casting de n salvo na variável real.
							if (real.valor == valor) { // Verficiar se o valor do real iterado é o mesmo do valor
														// da variável local de nome valor.
								cofrinho.listaMoedas.remove(real);// Se o valor for igual, a moeda é removida.
								break; // Encerrando o laço para não remover uma segunda moeda que possua mesmo
										// valor.
							}
						} else {
							continue;
						}
					}
				} catch (RuntimeException erro) {
					System.out.println("\nNão existem moedas desse tipo & valor no cofrinho!");
					break;
				}
				break;

			default:
				System.out.println("\nEntrada inválida");
				break;
			}
			break;
		} while (select != 0);

	}

	public static double valorMoeda() {
		int valor;
		do {
			while (true) {
				try {
					System.out.println("\nQual o valor da moeda?\n");
					System.out.println("1 - 0,10");
					System.out.println("2 - 0,25");
					System.out.println("3 - 0,50");
					System.out.println("4 - 1,00");
					System.out.print(">>> ");

					valor = sc.nextInt();
					break;
				} catch (InputMismatchException erro) {
					System.out.println("\nDigite apenas números inteiros!");
					sc.next();
				}
			}
			switch (valor) {

			case 1:
				System.out.println("\nrealziando transação...");
				return 0.10;

			case 2:
				System.out.println("\nrealziando transação...");
				return 0.25;

			case 3:
				System.out.println("\nrealziando transação...");
				return 0.50;

			case 4:
				System.out.println("\nrealziando transação...");
				return 1;

			default:
				System.out.println("\nOpção inválida, selecione um valor de moeda existente");
				return 0;
			}

		} while (valor != 1 && valor != 2 && valor != 3 && valor != 4);
	}
}
