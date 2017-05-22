package Jogo;

public class Jogador {	
	
	public Tabuleiro tabuleiro;
	private char simbolo;
	protected boolean vencedor = false;
	protected boolean vez;
	private boolean isFirst;
	
	public Jogador(boolean isFirst){
		this.tabuleiro = new Tabuleiro();
		this.isFirst = isFirst;
		if(isFirst == true){
			setSimbolo('O');
			vez = true;
			
		}else{
			setSimbolo('X');
		}
	}
	public Jogador(boolean isFirst, Tabuleiro t){
		this.tabuleiro = t;
		this.isFirst = isFirst;
		if(isFirst == true){
			setSimbolo('O');
			vez = true;
		}else{
			setSimbolo('X');
		}
	}
	// faz a jogada e checa se o jogador foi vencedor
	public  boolean fazerJogada(int linha, int coluna){
		tabuleiro.jogada(this.getSimbolo(), linha, coluna);
		
		if(tabuleiro.checarVitoria() == true){
			vencedor = true;
			return true;
		}
		return false;
	}

	public boolean isVencedor() {
		return vencedor;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public char getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}


}
