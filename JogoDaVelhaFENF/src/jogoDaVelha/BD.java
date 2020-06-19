package jogoDaVelha;

public abstract class BD {
	String jogadas[] = new String[10];
	
	public abstract void registrarJogada(int rodada,int linha, int coluna, Jogador jogador);
}
