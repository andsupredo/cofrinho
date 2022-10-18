package sistema;

public class Dolar extends Moeda {

	public Dolar() {
		super();

	}

	public Dolar(double valor, String nome, double cotacao) {
		super(valor, nome = "Dólar", cotacao = 5.33); //cotação baseada na data de 14/10/2022

	}

	@Override
	public void info() {
		System.out.println("Valor da cotação do Dólar no dia 14/10/2022: R$" + this.cotacao);

	}

	@Override
	public double converter() {
		return this.getValor() * this.cotacao;

	}

	@Override
	public String toString() {
		return "Dolar: " + valor;
	}


}
