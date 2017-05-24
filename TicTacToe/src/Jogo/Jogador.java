package Jogo;

public class Jogador {	
	
	public Tabuleiro tabuleiro;
	
	protected char simbolo;
	private int vitorias = 0;
	
	protected boolean vencedor = false;
	private boolean vez;
	protected boolean isFirst;
	
	public Jogador(boolean isFirst){
		this.tabuleiro = new Tabuleiro();
		this.isFirst = isFirst;
		if(isFirst == true){
			setSimbolo('O');
			setVez(true);
			
		}else{
			setSimbolo('X');
		}
	}
	public Jogador(boolean isFirst, Tabuleiro t){
		this.tabuleiro = t;
		this.isFirst = isFirst;
		if(isFirst == true){
			setSimbolo('O');
			setVez(true);
		}else{
			setSimbolo('X');
		}
	}
	// faz a jogada e checa se o jogador foi vencedor
	public  boolean fazerJogada(int linha, int coluna){
		tabuleiro.jogada(this.getSimbolo(), linha, coluna);
		vez = false;
		if(tabuleiro.checarVitoria() == true){
			vencedor = true;
			setVitorias(getVitorias() + 1);
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
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public boolean isVez() {
		return vez;
	}
	public void setVez(boolean vez) {
		this.vez = vez;
	}


}
