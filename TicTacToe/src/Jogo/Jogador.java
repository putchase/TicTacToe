package Jogo;

public class Jogador {
	
	protected Tabuleiro tabuleiro;
	protected char simbolo;
	private boolean vencedor;
	
	public Jogador(){
		
	}

	public  boolean fazerJogada(char simbolo, int linha, int coluna){
		tabuleiro.jogada(simbolo, linha, coluna);
		
		if(tabuleiro.checarVitoria() == true){
			vencedor = true;
			return true;
		}
		return false;
	}

	public boolean isVencedor() {
		return vencedor;
	}

}
