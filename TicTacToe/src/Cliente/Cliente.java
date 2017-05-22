 package Cliente;

import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Jogo.*;

public class Cliente extends JFrame{
	Jogador jogador;
	boolean isFirst = true;
	
	Socket cliente;
	DataOutputStream saida;
	
	JPanel painel = new JPanel();
	JPanel pGeral = new JPanel();
	JPanel pTabuleiro = new JPanel();
	
	
	public Cliente(){
		iniciarJogador();
		iniciarPainelGeral();
		inciarPainelTabuleiro();
		inicarPainel();
		configurarJanela();
		
	}
	

	private void iniciarJogador() {
		jogador = new Jogador(isFirst);
		
	}


	private void iniciarPainelGeral() {
		// TODO Auto-generated method stub
		
	}


	private void inciarPainelTabuleiro() {
		// TODO Auto-generated method stub
		
	}


	private void inicarPainel() {
		// TODO Auto-generated method stub
		
	}


	private void configurarJanela() {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args){		
		new Cliente().setVisible(true);
	}
}
