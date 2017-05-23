package Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Jogo.*;

public class Cliente extends JFrame {



	Jogador jogador;
	boolean isFirst = true;

	Socket cliente;
	DataOutputStream saida;

	JButton tabuleiro[][];
	JPanel painel = new JPanel();
	JPanel pGeral = new JPanel();
	JPanel pLinhas[];
	

	public Cliente() {

		iniciarJogador();
		iniciarPainelGeral();
		inciarPainelTabuleiro();
		inicarPainel();
		configurarJanela();
		try {
			cliente = new Socket("127.0.0.1", 5051);
			saida = new DataOutputStream(cliente.getOutputStream());
			new Thread(new Listen()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * Paineis GUI
	 */
	private void iniciarJogador() {
		jogador = new Jogador(isFirst);

	}

	private void iniciarPainelGeral() {
		String noJogador = "Jogador ";
		String simbolo = "Simbolo: ";
		if (jogador.isFirst() == true) {
			noJogador = noJogador + "1";
			simbolo = simbolo + "O";
		} else {
			noJogador = noJogador + "2";
			simbolo = simbolo + "X";
		}

		JLabel geral = new JLabel();
		geral.setFont(new Font(null, 1, 26));
		geral.setText("<html>" + noJogador + "<br/>" + simbolo + "<br/> Vitórias: " + jogador.getVitorias() + "<br/></html>");
		pGeral = new JPanel();
		pGeral.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		pGeral.add(geral);
	}

	private void inciarPainelTabuleiro() {
		criarBotoes();
		mostrarBotoes();
	}
	
	
	
	private void criarBotoes() {
		tabuleiro = new JButton[3][3];
		pLinhas = new JPanel[3];
		int i, j;
		for (i = 0; i <= 2; i++) {
			pLinhas[i] = new JPanel();
			for (j = 0; j <= 2; j++) {
				tabuleiro[i][j] = new JButton("  ");
				tabuleiro[i][j].setFont(new Font(null, 1, 36));
				pLinhas[i].add(tabuleiro[i][j]);
			}
		}

	}
	
	private void limparTabuleiroGUI() {
			
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				tabuleiro[i][j].setText("  ");
				
			}
		}
	}
	
	public void vitoria() {
		if (jogador.isVencedor() == true) {
			JOptionPane.showMessageDialog(null, "VocÃª Venceu!");
			limparTabuleiroGUI();
		}
	}
	
	

	private void mostrarBotoes() {
		tabuleiro[0][0].addActionListener(new ActionListener() {

			@Override 
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(0, 0);
				try {
					saida.writeBytes("$0:0\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[0][0].setText("" + jogador.getSimbolo());
				vitoria();
				
			}

			
		});

		tabuleiro[0][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(0, 1);
				try {
					saida.writeBytes("$0:1\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[0][1].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[0][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(0, 2);
				try {
					saida.writeBytes("$0:2\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[0][2].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[1][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(1, 0);
				try {
					saida.writeBytes("$1:0\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[1][0].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[1][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(1, 1);
				try {
					saida.writeBytes("$1:1\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[1][1].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[1][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(1, 2);
				try {
					saida.writeBytes("$1:2\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[1][2].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[2][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(2, 0);
				try {
					saida.writeBytes("$2:0\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[2][0].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[2][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(2, 1);
				try {
					saida.writeBytes("$2:1\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[2][1].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});

		tabuleiro[2][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogador.fazerJogada(2, 2);
				try {
					saida.writeBytes("$2:2\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				tabuleiro[2][2].setText("" + jogador.getSimbolo());
				vitoria();
			}
		});
	}

	private void inicarPainel() {
		painel = new JPanel();
		painel.add(pGeral);
		painel.add(pLinhas[0]);
		painel.add(pLinhas[1]);
		painel.add(pLinhas[2]);
	}

	private void configurarJanela() {
		setTitle("TicTacToe - Redes1");
		setSize(300, 350);
		add(painel);
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	private class Listen implements Runnable {

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader( new InputStreamReader(cliente.getInputStream()));
				String msg;
				while ((msg = br.readLine()) != null) {
					if (msg.substring(0,1).equals("$")){
						int x = Integer.parseInt( msg.substring(1,2));
						int y = Integer.parseInt( msg.substring(3,4));
						tabuleiro[x][y].setText("$");
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Cliente();
	}
}

