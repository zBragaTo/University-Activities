package objetos;

public class Alimentos {
	private int codigo;
	public int tipo;
	public String desc;
	private float preco;
	
	 Alimentos(int codigo, String desc) {
		 this.codigo = codigo;
		 this.desc = desc;
		 tipo = 0;
		 preco = 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	 
	 
	 
}
