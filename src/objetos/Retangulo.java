package objetos;

public class Retangulo {
	int altura,largura;
	
	public double calcArea(){
		return (altura * largura);
		
	}
	
	public int calcPerimetro() {
		return ((altura * 2) + (largura * 2));
	}
}
