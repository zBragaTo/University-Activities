package DSP1;

public class Curso {
	private String nomeCurso;
	private String nivelCurso;
	private double mensalidade;
	
	public Curso(String nomeCurso, String nivelCurso, double mensalidade) {
		super();
		this.nomeCurso = nomeCurso;
		this.nivelCurso = nivelCurso;
		this.mensalidade = mensalidade;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	
	
}
