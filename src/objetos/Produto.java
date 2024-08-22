package objetos;

public class Produto {
	private int cod;
	private String desc;
	private double preco;
	
	Produto(int cod, String desc, double preco){
		this.cod = cod;
		this.desc = desc;
		this.preco = preco;
	}	
	
	@Override
	public String toString(){
		return "Código do produto: " + getCod() + "\n" +
				"Descrição: " + getDesc() + "\n" +
				"Preço: " + getPreco();
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public double getPreco() {
		return preco;
	}	
	
}
