package jogoDaVelha;

public class Jogador {
	private int id;
	private String simbolo;
	public Jogador(int id2) {
		if (id2 == 1) {
			this.id = id2;
			this.simbolo = "X";
		}
		else {
			this.id = id2;
			this.simbolo = "O";
		}
	}
	
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id2) {
		this.id = id2;
	}
}
