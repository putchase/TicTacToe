package Jogo;

public class Jogador {	
	
	public Tabuleiro tabuleiro;
	protected char simbolo;
	protected boolean vencedor = false;
	protected boolean vez;
	
	public Jogador(boolean isFirst){
		this.tabuleiro = new Tabuleiro();
		if(isFirst == true){
			simbolo = 'O';
			vez = true;
		}else{
			simbolo = 'X';
		}
	}
	public Jogador(boolean isFirst, Tabuleiro t){
		this.tabuleiro = t;
		
		if(isFirst == true){
			simbolo = 'O';
			vez = true;
		}else{
			simbolo = 'X';
		}
	}
	// faz a jogada e checa se o jogador foi vencedor
	public  boolean fazerJogada(int linha, int coluna){
		tabuleiro.jogada(this.simbolo, linha, coluna);
		
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
