package DSP1;

class Aluno extends Curso {
	private String nome;
	private int codMat;
	private boolean bolsista;
	private double desconto;

	public Aluno(String nome, int codMat, boolean bolsista, double desconto, String nomeCurso, String nivelCurso, double mensalidade) {
		super(nomeCurso, nivelCurso, mensalidade);
		this.nome = nome;
		this.codMat = codMat;
		this.bolsista = bolsista;
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isBolsista() {
		return bolsista;
	}

	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getCodMat() {
		return codMat;
	}

	public void setCodMat(int codMat) {
		this.codMat = codMat;
	}

	public String verificaBolsa() {
		if (bolsista) {
			double novaMensalidade = this.getMensalidade() * (1 - this.desconto / 100);
			return "Bolsista com desconto de: " + this.desconto + "%\n"
					+ "Mensalidade: R$: " + novaMensalidade;
		} else {
			return "Mensalidade: " + getMensalidade();
		}
	}

	@Override
	public String toString() {
		return "Aluno: " + this.nome + "\n"
				+ "Curso: " + getNivelCurso() + " em " + getNomeCurso() + "\n" + verificaBolsa(); 
	}

}

