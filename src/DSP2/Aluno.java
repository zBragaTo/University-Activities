package DSP2;

class Aluno extends Curso {
	private String nome;
	private boolean bolsista, cursoFinalizado, temTrabalho;
	private int anoFinalizacao;
	private double desconto;
	private String[] dadosTcc;

	public Aluno(String nome, boolean bolsista, boolean cursoFinalizado, boolean temTrabalho, int anoFinalizacao,
			double desconto, String nomeCurso, String nivelCurso, double mensalidade, String[] dadosTcc) {
		super(nomeCurso, nivelCurso, mensalidade);
		this.nome = nome;
		this.bolsista = bolsista;
		this.cursoFinalizado = cursoFinalizado;
		this.temTrabalho = temTrabalho;
		this.anoFinalizacao = anoFinalizacao;
		this.desconto = desconto;
		this.dadosTcc = dadosTcc;
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

	public boolean isCursoFinalizado() {
		return cursoFinalizado;
	}

	public void setCursoFinalizado(boolean cursoFinalizado) {
		this.cursoFinalizado = cursoFinalizado;
	}

	public boolean isTemTrabalho() {
		return temTrabalho;
	}

	public void setTemTrabalho(boolean temTrabalho) {
		this.temTrabalho = temTrabalho;
	}

	public int getAnoFinalizacao() {
		return anoFinalizacao;
	}

	public void setAnoFinalizacao(int anoFinalizacao) {
		this.anoFinalizacao = anoFinalizacao;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String[] getDadosTcc() {
		return dadosTcc;
	}

	public void setDadosTcc(String[] dadosTcc) {
		this.dadosTcc = dadosTcc;
	}

	@Override
	public String toString() {
		StringBuilder resp = new StringBuilder("Aluno: " + nome + "\n" + super.toString()
				+ (bolsista
						? "Bolsista com desconto de: " + desconto + "%\nMensalidade: R$ "
								+ getMensalidadeComDesconto(desconto) + "\n"
						: "Mensalidade: R$ " + getMensalidade() + "\n"));

		if (cursoFinalizado) {
			resp.append("Curso finalizado em ").append(anoFinalizacao).append("\n");
			if (temTrabalho && dadosTcc != null) {
				resp.append("Título ").append(getTituloTcc()).append(": ").append(dadosTcc[1])
						.append("\nOrientador(a): Prof. ").append(dadosTcc[0]).append("\nNota: ").append(dadosTcc[2])
						.append("\n");
			}
		}
		return resp.toString();
	}
}
