package Praticando1;

public class Ponto {
	private int x,y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Ponto p) {
		int deltaX = p.x - this.x;
		int deltaY = p.y - this.y;
		
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}
	
	@Override
	public String toString() {
		return "Ponto{" + "x=" + x +", y=" + y + "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		return x == other.x && y == other.y;
	}
	
}
