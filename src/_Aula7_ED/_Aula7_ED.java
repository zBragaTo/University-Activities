package _Aula7_ED;

import java.util.Scanner;

//Classe __Aula7_ED: encarregada de executar alguns testes/funcionalidades
//com a estrutura de dados ABB.
//Autor 1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
//Autor 2: LEONARDO BRAGATO BASSI 10416029
//Data da Atualização: 19/11/2024
public class _Aula7_ED {
  	private static Scanner ler = new Scanner(System.in);
	
	// armazenaDadosABB(ABB<Veiculo> abb): realiza o cadastro de 15
	//   veículos na árvore de busca binária (ABB) abb.
	public static void armazenaDadosABB(ABB<Veiculo> abb) {
		abb.inserir(new Veiculo("FPE5U59", 2021, 105000, "passeio"));
		abb.inserir(new Veiculo("UJP0T10", 2022, 100000, "passeio"));
		abb.inserir(new Veiculo("APK1A21", 2019, 100000, "passeio"));
		abb.inserir(new Veiculo("FAD1P10", 2021, 110000, "passeio"));
 		abb.inserir(new Veiculo("PST1B77", 2023, 300000, "carga"));
		abb.inserir(new Veiculo("PAQ1C33", 2024, 440000, "carga"));
		abb.inserir(new Veiculo("FID2T42", 2023, 410000, "carga"));
		abb.inserir(new Veiculo("PAB3Q78", 2023, 210000, "carga"));
		abb.inserir(new Veiculo("CAO4R91", 2023, 180000, "suv"));
		abb.inserir(new Veiculo("FEE6A21", 2023, 150000, "suv"));
		abb.inserir(new Veiculo("DDA5T55", 2024, 160000, "suv"));
		abb.inserir(new Veiculo("PPR9W76", 2023, 190000, "suv"));
		abb.inserir(new Veiculo("AAC8X55", 2019, 210000, "pick_up"));
		abb.inserir(new Veiculo("BAA6F22", 2018, 290000, "pick_up"));
		abb.inserir(new Veiculo("CDD5B34", 2023, 260000, "pick_up"));
	}
	// mostraQuantidadeVeiculos(ABB<Veiculo> abb): método que mostra os 
	//   veículos de um certo tipo e ano informados
	//   pelo usuário. O percurso é realizado na árvore abb fornecida.
	//   Faz as buscas enquanto o usuário desejar.
	public static void mostraQuantidadeVeiculos(ABB<Veiculo> abb) {
		System.out.println("Deseja procurar veículos (S/N)?");
		char opcao = ler.next().charAt(0);
		while (opcao == 'S' || opcao == 's') {
			System.out.println("Forneça o ano do veículo: ");
			int ano = Integer.parseInt(ler.next());
			boolean correto = false;
			String tipo = "";
			while (!correto){
			   System.out.println("Forneça o tipo do veículo (passeio, suv, carga ou pick_up): ");
			   tipo = ler.next();
			   if ((tipo.toLowerCase().equals("passeio") ||
			       tipo.toLowerCase().equals("suv") ||
			       tipo.toLowerCase().equals("carga") ||
			       tipo.toLowerCase().equals("pick_up")))
			       correto = true;
			}
			System.out.println(String.format("Veículos do ano = %d e tipo = %s", ano, tipo));
            System.out.println(abb.veiculosIgualAnoETipo(ano,  tipo));
			System.out.println("Deseja continuar a procurar veículos (S/N)?");
			opcao = ler.next().charAt(0);
		}
	}	

	public static void main(String[] args) {
	    System.out.println("ABB de objetos da classe Veículo (ordenadas pela Placa):\n");
	    ABB<Veiculo> abb = new ABB<Veiculo>();
	    armazenaDadosABB(abb);
	    abb.emOrdem();  
	    System.out.println("Total de Veículos: " + abb.getSize());
	    System.out.println("Total de Veículos com preço maior do que a média: " 
	    + abb.qtdeMaiorMediaPrecos());
	    mostraQuantidadeVeiculos(abb);
	    System.out.println("Fim");
	}
}
