package objetos;

public class Pedido {
	private int numero;
	Produto item;
	private int qtd;
	private double valor;
	
	Pedido(int numero, Produto item, int qtd){
		this.numero = numero;
		this.item = item;
		this.qtd = qtd;
	}
	
	public void calculaPedido(){
		this.valor = item.getPreco() * getQtd();
	}
	
	@Override
	public String toString(){
		return "Número do produto: " + getNumero() + "\n" +
				getItem() + "\n" +
				"Quantidade: " + getQtd() + "\n" +
				"Valor Total: " + getValor();
	}

	public Produto getItem() {
		return item;
	}

	public int getNumero() {
		return numero;
	}

	public int getQtd() {
		return qtd;
	}

	public double getValor() {
		return valor;
	}
	
}
