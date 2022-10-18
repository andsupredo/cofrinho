package sistema;

public abstract class Moeda {

	double valor;
	String nome;
	double cotacao;

	public Moeda() {
	}

	public Moeda(double valor, String nome, double cotacao) {
		this.valor = valor;
		this.nome = nome;
		this.cotacao = cotacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public abstract void info();

	public abstract double converter();
}
