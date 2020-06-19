package jogoDaVelha;

import java.util.Scanner;

public class Jogo {
	private Historico historico;
	private Tabuleiro tabuleiro;
	private Jogador jogador1 = new Jogador(1);
	private Jogador jogador2 = new Jogador(2);
	private int rodada = 1, turno = 1;
	private Scanner sc = new Scanner(System.in);
	private boolean valido;
	private int opcao;
	
	public Jogo() {
		tabuleiro = new Tabuleiro();
		historico = new Historico();
		System.out.println("JOGO DA VELHA");
		System.out.println("O jogador1 usa X e o jogador2 usa O");
		while (iniciarPartida());
	}
	public boolean iniciarPartida() {
		if(fimDoJogo() == 0 ){
            System.out.println("=======================");
            System.out.println("Rodada "+rodada);
            System.out.println("É o turno do jogador" + whoIs() );
            System.out.println("=======================");
            
            tabuleiro.printTabuleiro();
            
            if(whoIs()==1) {
            	valido = false;
            		do {
	            	String jogada = sc.nextLine();
	            	String[] vect = jogada.split(",");
	            	int linha = Integer.valueOf(vect[0]);
	            	linha--;
	            	int coluna = Integer.valueOf(vect[1]);
	            	coluna--;
	            	if (tabuleiro.checarJogada(linha, coluna) == false) {
		            	tabuleiro.setJogada(linha,coluna,1);
		            	historico.registrarJogada(rodada, linha, coluna, jogador1);
		            	turno++;
		            	rodada++;
		            	valido = true;
	            	} else {
	            		System.out.println("JÁ EXISTE UM SÍMBOLO NESSE LUGAR, TENTE NOVAMENTE");
	            	} } while (valido=false);
            }
            else {
            		do {
            		valido = false;
	            	String jogada2 = sc.nextLine();
	            	String[] vect = jogada2.split(",");
	            	int linha = Integer.valueOf(vect[0]);
	            	linha--;
	            	int coluna = Integer.valueOf(vect[1]);
	            	coluna--;
	            	if (tabuleiro.checarJogada(linha, coluna) == false) {
		            	tabuleiro.setJogada(linha,coluna,-1);
		            	historico.registrarJogada(rodada, linha, coluna, jogador2);
		            	turno++;
		            	rodada++;
		            	valido = true;
	            	} else {
	            		System.out.println("JÁ EXISTE UM SÍMBOLO NESSE LUGAR, TENTE NOVAMENTE");
	            	} } while (valido=false);
            }
            if(tabuleiro.verCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                tabuleiro.printTabuleiro();
                historico.printHistorico();
                System.out.println();
                System.out.println("Você quer continuar jogando?");
                System.out.println("1 - sim");
                System.out.println("0 - não");
                String opcaos = sc.nextLine();
                switch (Integer.valueOf(opcaos)) {
                	case 1:
                		tabuleiro.clearTabuleiro();
                		historico.clearHistorico();
                		rodada = 1;
                		turno = 1;
                		return true;
                	case 0:
                		System.out.println("JOGO TERMINADO");
                		return false;
                }
            }
            return true;
        } else{
            if(fimDoJogo() == 1 ) {
                System.out.println("\nJogador1 ganhou!");
            	tabuleiro.printTabuleiro();
            	historico.printHistorico();
            	System.out.println();
            	System.out.println("Você quer continuar jogando?");
                System.out.println("1 - sim");
                System.out.println("0 - não");
                String opcaos = sc.nextLine();
                switch (Integer.valueOf(opcaos)) {
                	case 1:
                		tabuleiro.clearTabuleiro();
                		historico.clearHistorico();
                		rodada = 1;
                		turno = 1;
                		return true;
                	case 0:
                		System.out.println("JOGO TERMINADO");
                		return false;
                }
            }
            else {
                System.out.println("\nJogador2 ganhou!");
            	tabuleiro.printTabuleiro();
            	historico.printHistorico();
            	System.out.println();
            	System.out.println("Você quer continuar jogando?");
                System.out.println("1 - sim");
                System.out.println("0 - não");
                String opcaos = sc.nextLine();
                Integer.valueOf(Integer.valueOf(opcaos));
                switch (opcao) {
                	case 1:
                		tabuleiro.clearTabuleiro();
                		historico.clearHistorico();
                		rodada = 1;
                		turno = 1;
                		return true;
                	case 0:
                		System.out.println("JOGO TERMINADO");
                		return false;
                }
            }
            
            return false;
        }
    }
	public int whoIs() {
		if(turno%2 == 1)
			return 1;
		else
			return 2;
	}
	public int fimDoJogo() {
		if(tabuleiro.verLinhas() == 1)
			return 1;
		if(tabuleiro.verColunas() == 1)
            return 1;
		if(tabuleiro.verDiagonais() == 1)
        	return 1;
        
        if(tabuleiro.verLinhas() == 2)
            return 2;
        if(tabuleiro.verColunas() == 2)
            return 2;
        if(tabuleiro.verDiagonais() == 2)
            return 2;
        
        return 0;
	}
}
