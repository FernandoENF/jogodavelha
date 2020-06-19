package jogoDaVelha;

public class Historico extends BD{
	
	@Override
	public void registrarJogada(int rodada,int linha, int coluna, Jogador jogador) {
		linha++;
		coluna++;
		jogadas[rodada] = "O jogador"+jogador.getId()+" colocou o "+jogador.getSimbolo()+" na posição "+linha+","+coluna;
	}
	
	public void printHistorico() {
		System.out.println();
		System.out.println("-----HISTORICO-----");
		for (int rodadas = 1; rodadas < 10; rodadas++) {
			if(jogadas[rodadas] != null)
				System.out.println(this.jogadas[rodadas]);
		}
	}
	public void clearHistorico() {
		for (int rodadas = 1; rodadas<10; rodadas++) {
			jogadas[rodadas] = null;
		}
	}

}
