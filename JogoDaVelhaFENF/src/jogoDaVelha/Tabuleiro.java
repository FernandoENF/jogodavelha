package jogoDaVelha;

public class Tabuleiro{
	
	public int tabuleiro[][] = new int[3][3];
	
	public Tabuleiro() {
		clearTabuleiro();
	}
	public void printTabuleiro() {
		System.out.println();
		System.out.println("   1   2   3 ");
        for(int linha=0 ; linha<3 ; linha++){
        	System.out.print(linha+1+"|");
            for(int coluna=0 ; coluna<3 ; coluna++){
                if(tabuleiro[linha][coluna]==1){
                    System.out.print(" X ");
                }
                if(tabuleiro[linha][coluna]==-1){
                    System.out.print(" O ");
                }
                if(tabuleiro[linha][coluna]==0){
                    System.out.print("   ");
                }
                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }
	}
	public boolean checarJogada(int linha, int coluna) {
		if (tabuleiro[linha][coluna] != 0)
			return true;
		else
			return false;
	}
	
	public void setJogada(int linha, int coluna, int jogador) {
		tabuleiro[linha][coluna] = jogador;
	}
	public void delJogada(int linha, int coluna) {
		tabuleiro[linha][coluna] = 0;
	}
	public void clearTabuleiro() {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				tabuleiro[linha][coluna] = 0;
			}
		}
	}
	public int verLinhas() {
		for(int linha=0 ; linha<3 ; linha++){
			if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return 2;
			if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
				return 1;
		}
		return 0;
    }
	public int verColunas() {
		for(int coluna=0 ; coluna<3 ; coluna++){
            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
                return 2;
            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
                return 1;
        }
        return 0;       
	}
	public int verDiagonais() {
		if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return 2;
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return 2;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;
        return 0;
			}
	public boolean verCompleto() {
	        for(int linha=0 ; linha<3 ; linha++)
	            for(int coluna=0 ; coluna<3 ; coluna++)
	                if( tabuleiro[linha][coluna]== 0 )
	                    return false;
	        return true;
	}
}
