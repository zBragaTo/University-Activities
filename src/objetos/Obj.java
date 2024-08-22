package objetos;

import java.util.Scanner;

public class Obj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Retangulo r1 = new Retangulo();
		Triangulo t1 = new Triangulo();

		System.out.println("Digite a altura do retangulo: ");
		r1.altura = sc.nextInt();	
		System.out.println("Digite a largura do retangulo: ");
		r1.largura = sc.nextInt();
		
		System.out.println("Digite a base do Triangulo: ");
		t1.base = sc.nextInt();	
		System.out.println("Digite a altura do Triagulo: ");
		t1.altura = sc.nextInt();
		
		System.out.println("Área do Retangulo é = " +  r1.calcArea() + " e o Perimetro = " + r1.calcPerimetro());
		System.out.println("Área do Triangulo é = " + t1.calcArea());
		
		sc.close();
	}
	
}
