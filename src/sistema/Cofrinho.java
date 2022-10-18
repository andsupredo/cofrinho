package sistema;

import java.util.ArrayList;

public class Cofrinho {

	ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();

	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda);
		System.out.println("Adicionando $" + moeda.valor + " " + moeda.nome + " ao cofrinho.");
	}

	public void remover(Moeda moeda) {
		listaMoedas.remove(moeda);
	}

	public void listagemMoedas() {
		System.out.println();
		System.out.println("Lista de moedas:");
		for (Moeda m : listaMoedas) {
			System.out.println(m);
		}
	}

	public void totalConvertido() {
		double soma = 0;
		for (Moeda m : listaMoedas) {
			soma += ((Moeda) m).converter();
		}
			System.out.printf("%nTotal convertido em R$: %.2f", soma, "%n");
		}
	}
