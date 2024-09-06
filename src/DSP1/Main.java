package DSP1;

public class Main {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Martin Fowler", 11223344, true, 20.5, "ADS", "Graduação", 920.50);
		Aluno a2 = new Aluno("Kent Beck", 22334455, false, 0, "Computação Aplicada", "Mestrado", 2150.45);

		System.out.println(a1);
		System.out.println(a2);
	}

}
