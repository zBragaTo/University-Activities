package _Aula6_ED;

import java.util.Scanner;

//Classe __Aula6_ED: encarregada de executar alguns testes/funcionalidades
//com a estrutura de dados LinkedList.
//Autor 1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
//Autor 2: Leonardo Bragato Bassi 10416029
//Data da Atualização: 03/11/2024
public class _Aula6_ED {

	private static Scanner ler = new Scanner(System.in);

	// bancoDeDados(LinkedList<Trabalhador> func): realiza o cadastro de 10
	// trabalhadores na lista ligada (LinkedList) func.
	public static void bancoDeDados(LinkedList<Trabalhador> func) {
		func.addLast(new Trabalhador(1, 25, 'M', 5000.0f, "Analista Jr."));
		func.addLast(new Trabalhador(2, 22, 'M', 3000.0f, "Auxiliar Administrativo."));
		func.addLast(new Trabalhador(3, 27, 'F', 5000.0f, "Analista Jr."));
		func.addLast(new Trabalhador(4, 35, 'M', 7000.0f, "Programador Sr."));
		func.addLast(new Trabalhador(5, 45, 'F', 7000.0f, "Gerente Jr."));
		func.addLast(new Trabalhador(6, 51, 'M', 7500.0f, "Gerente Pleno"));
		func.addLast(new Trabalhador(7, 60, 'M', 8000.0f, "Vice-Presidente"));
		func.addLast(new Trabalhador(8, 34, 'F', 7000.0f, "Analista Pleno"));
		func.addLast(new Trabalhador(9, 43, 'F', 8000.0f, "Programador Sr."));
		func.addLast(new Trabalhador(10, 63, 'F', 10000.0f, "Presidente"));
	}

	// demiteFuncionarios(LinkedList<Trabalhador> func): remove funcionários
	// demitidos da lista
	// de funcionários da empresa enquanto o usuário desejar.
	public static void demiteFuncionarios(LinkedList<Trabalhador> func) {
		String opcao;
		boolean primeiraVez = true;
		do {
			
			if (primeiraVez) {
				System.out.print("Deseja demitir um funcionário (S/N)? ");
				primeiraVez = false;
			} else {
				System.out.print("Deseja continuar a demitir um funcionário (S/N)? ");
			}
			
			opcao = ler.nextLine();
			if (opcao.equalsIgnoreCase("S")) {
				System.out.print("Forneça o número do funcionário: ");
				int id = ler.nextInt();
				ler.nextLine();

				boolean removed = false;
				for (int i = 1; i <= func.getSize(); i++) {
					if (func.get(i).getDado().getId() == id) {
						func.remove(func.get(i).getDado());
						System.out.println("Funcionário " + id + " encontrado e removido com sucesso!");
						removed = true;
						break;
					}
				}
				if (!removed) {
					System.out.println("Funcionário " + id + " NÃO foi encontrado!");
				}
			}
		} while (opcao.equalsIgnoreCase("S"));

	}

	public static void main(String[] args) {
		LinkedList<Trabalhador> func = new LinkedList<Trabalhador>();

		bancoDeDados(func);
		System.out.println(func);

		LinkedList<Trabalhador> contratados = new LinkedList<Trabalhador>();

		contratados.addLast(new Trabalhador(11, 23, 'M', 3900.0f, "Programador Jr."));
		contratados.addLast(new Trabalhador(12, 29, 'F', 4500.0f, "Secretária Bilíngue"));
		contratados.addLast(new Trabalhador(13, 35, 'M', 6000.0f, "Programador Pleno"));
		contratados.addLast(new Trabalhador(14, 53, 'M', 5000.0f, "Programador Jr."));
		contratados.addLast(new Trabalhador(15, 63, 'F', 8000.0f, "Analista Sr."));
		contratados.addLast(new Trabalhador(16, 56, 'M', 9000.0f, "Analista Sr."));

		func.concatena(contratados);
		System.out.println(func);

		demiteFuncionarios(func);
		System.out.println(func);
	}
}
