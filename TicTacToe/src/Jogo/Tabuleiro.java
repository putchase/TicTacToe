package Jogo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Tabuleiro {
	protected char[][] tabuleiro;
	//protected boolean existeVencedor = false;
	//Socket cliente; 
	//DataOutputStream out;
	public Tabuleiro() {
//		try {
//			cliente = new Socket("127.0.0.1", 5051);
//			out = new DataOutputStream(cliente.getOutputStream());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		setTabuleiro(new char[3][3]);

		limparTabuleiro();
	}

	public char[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(char[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void jogada(char simbolo, int linha, int coluna) {
		tabuleiro[linha][coluna] = simbolo;
	}

	public boolean checarVitoria() {
		int i;
		// linhas
		for (i = 0; i <= 2; i++) {
			if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
				//System.out.println("venceu por linha" + i);
				limparTabuleiro();
				return true;
			}
		}

		// colunas
		for (i = 0; i <= 2; i++) {
			if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[i][0] != ' ') {
				//System.out.println("venceu por coluna");
				limparTabuleiro();
				return true;
			}
		}

		// diagonais
		if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[1][1] != ' ') {
			//System.out.println("venceu por diagonal1");
			limparTabuleiro();
			return true;
		}
		if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[1][1] != ' ') {
			//System.out.println("venceu por diagonal2");
			limparTabuleiro();
			return true;
		}
		return false;

	}

	public void showTabuleiro() {
		int i;
		for (i = 0; i <= 2; i++) {
			System.out.println("[" + tabuleiro[i][0] + "]" + "[" + tabuleiro[i][1] + "]" + "[" + tabuleiro[i][2] + "]");
		}
	}
	
	public void limparTabuleiro(){
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}
}
