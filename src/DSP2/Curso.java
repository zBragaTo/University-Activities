package DSP2;

class Curso {
	private String nome;
	private String nivel;
	private double mensalidade;

	public Curso(String nome, String nivel, double mensalidade) {
		this.nome = nome;
		this.nivel = nivel;
		this.mensalidade = mensalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public double getMensalidadeComDesconto(double desconto) {
		return mensalidade * (1 - desconto / 100);
	}

	public String getTituloTcc() {
		return switch (nivel) {
		case "Graduação" -> "do TCC";
		case "Lato sensu" -> "da monografia";
		case "Mestrado" -> "da dissertação";
		case "Doutorado" -> "da tese";
		default -> "do trabalho";
		};
	}

	@Override
	public String toString() {
		return "Curso: " + nivel + " em " + nome + "\n";
	}
}
