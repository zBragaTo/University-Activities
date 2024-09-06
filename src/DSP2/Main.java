package DSP2;

public class Main {
    public static void main(String[] args) {
        String[] dados1 = {null, null, null};
        Aluno aluno1 = new Aluno("Martin Fowler", true, false, false, -1, 20.5, "ADS", "Graduação", 920.50, dados1);

        String[] dados2 = {"Peter Coad", "Impacto da Refatoração", "9.5"};
        Aluno aluno2 = new Aluno("Kent Beck", false, true, true, 2019, 0, "Computação Aplicada", "Mestrado", 2150.45, dados2);

        System.out.println(aluno1);
        System.out.println(aluno2);
    }
}