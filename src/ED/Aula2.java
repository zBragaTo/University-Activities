package ED;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Aula2 {

	private List<Veiculo> veic = new ArrayList();
	private Scanner ler = new Scanner(System.in); 

	public static void main(String[] args) {
		Aula2 loja = new Aula2();
		System.exit(0);
	}

	public Aula2() {
		simularLeituraDeDados();
		System.out.println("Resultados: \n");
		mediaPrecosCaminhoesVendidos();
		veiculoMaisCaroMaisBarato();
		mediaPrecosDeUmTipoDeVeiculo();
		listarTodosOsVeiculosDaLoja();
	}
	
	public void simularLeituraDeDados() {
		veic.add(new Veiculo("ABC-1L34", "Honda", "GL 1800", 2023, 150000f, "moto"));
		veic.add(new Veiculo("DEF-2K45", "Volvo", "Scania X", 2015, 179000f, "caminhão"));
		veic.add(new Veiculo("EDF-1P34", "Audi", "A4", 2019, 234000f, "carro"));
		veic.add(new Veiculo("FGE-2A45", "Ford", "Focus", 2018, 89000f, "carro"));
		veic.add(new Veiculo("ABD-1B34", "Fiat", "Track Gls", 2022, 112000f, "carro"));
		veic.add(new Veiculo("DGF-2C45", "Volvo", "Scania X", 2024, 220000f, "caminhão"));
		veic.add(new Veiculo("FGP-2M45", "Ford", "Focus", 2021, 120000f, "carro"));
		veic.add(new Veiculo("ABC-1234", "Honda", "GL 1000", 2024, 140000f, "moto"));
		veic.add(new Veiculo("AEF-2Q45", "Volvo", "Scania X", 2019, 195000f, "caminhão"));
		veic.add(new Veiculo("IGN-1W45", "Ford", "Focus", 2020, 110000f, "carro"));
	}

	public void mediaPrecosCaminhoesVendidos() {
		float somaPrecos = 0;
		int contadorCaminhoes = 0;

		for (Veiculo veiculo : veic) {
			if ("caminhão".equalsIgnoreCase(veiculo.getTipo())) {
				somaPrecos += veiculo.getPreco();
				contadorCaminhoes++;
			}
		}

		if (contadorCaminhoes > 0) {
			float media = somaPrecos / contadorCaminhoes;
			System.out.printf("Média dos preços dos caminhões: R$ %.2f%n", media);
		} else {
			System.out.println("Não existem caminhões na loja");
		}
	}

	public void veiculoMaisCaroMaisBarato() {

		if (veic.isEmpty()) {
			System.out.println("Não há veículos cadastrados");
		}

		Veiculo veiculoCaro = veic.get(0);
		Veiculo veiculoBarato = veic.get(0);

		for (Veiculo veiculo : veic) {

			if (veiculo.getPreco() > veiculoCaro.getPreco()) {
				veiculoCaro = veiculo;
			}
			if (veiculo.getPreco() < veiculoBarato.getPreco()) {
				veiculoBarato = veiculo;
			}
		}
		System.out.println("Mais caro: " + veiculoCaro);
		System.out.println("Mais barato: " + veiculoBarato);
	}


	public void mediaPrecosDeUmTipoDeVeiculo() {
	    System.out.println("Digite um veículo para calcular a média de preço deles (carro, caminhão ou moto): ");
	    String veicuser = ler.next().toLowerCase();  

	    float somaPrecos = 0;
	    int contador = 0;

	    for (Veiculo veiculo : veic) {
	        if (veiculo.getTipo().equalsIgnoreCase(veicuser)) {
	            somaPrecos += veiculo.getPreco();
	            contador++;
	        }
	    }
	    if (contador > 0) {
	        float media = somaPrecos / contador;
	        System.out.printf("Média dos preços dos veículos do tipo %s: R$ %.2f%n", veicuser, media);
	    } else {
	        System.out.println("Não existem veículos desse tipo na loja");
	    }
	}

	public void listarTodosOsVeiculosDaLoja() {
		if (veic.isEmpty()) {
			System.out.println("Não há veículos cadastrados!");
		}
		for (int i = 0; i < veic.size(); i++) {
			System.out.println(veic.get(i));
		}
	}
}
