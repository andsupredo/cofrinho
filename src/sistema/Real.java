package sistema;

public class Real extends Moeda {

	public Real() {
		super();
	}

	public Real(double valor, String nome, double cotacao) {
		super(valor, nome = "Real", cotacao = 1);//Cotação do real por ser a moeda base, nesse caso, será sempre 1,00.
	}

	@Override
	public void info() {
		System.out.println("O real é a moeda base de conversão, seu valor unitário sempre será R$1.00");
	}

	@Override
	public double converter() {
		return this.getValor() * this.cotacao;
	}

	@Override
	public String toString() {
		return "Real: " + valor;
	}


}
