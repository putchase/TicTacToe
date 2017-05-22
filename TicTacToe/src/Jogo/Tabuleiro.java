package Jogo;

public class Tabuleiro {
	protected char[][] tabuleiro;
	protected boolean existeVencedor = false;

	public Tabuleiro() {
		setTabuleiro(new char[3][3]);
	}

	public char[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(char[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public boolean isExisteVencedor() {
		return existeVencedor;
	}

	public void jogada(char simbolo, int linha, int coluna) {
		tabuleiro[linha][coluna] = simbolo;
	}

	 boolean checarVitoria() {
		int i;
		// linhas
		for (i = 0; i <= 2; i++) {
			if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
				existeVencedor = true;
				return true;
			}
		}
		
		// colunas
		for (i = 0; i <= 2; i++) {
			if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
				existeVencedor = true;
				return true;
			}
		}
		
		// diagonais
		if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
			existeVencedor = true;
			return true;
		} else if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
			existeVencedor = true;
			return true;
		}
		return false;

	}
}
