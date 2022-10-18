package sistema;

public class Euro extends Moeda {

	public Euro() {
		super();
	}

	public Euro(double valor, String nome, double cotacao) {
		super(valor, nome = "Euro", cotacao = 5.18);//cotação baseada na data de 14/10/2022
	}
	
	@Override
	public void info() {
		System.out.println("Valor da cotação do Euro no dia 14/10/2022: : R$" + this.cotacao);

	}

	@Override
	public double converter() {
		return this.getValor() * this.cotacao;

	}

	@Override
	public String toString() {
		return "Euro: " + valor;
	}

	

}
