package Cliente;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Jogo {
	public static void main(String [] args){
		JFrame janela = new JFrame("TicTacToe");
		JPanel painel = new JPanel();
		
		JButton tabuleiro[][] = new JButton[3][3];
		
		JButton botao1 = new JButton("1, 1");
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				botao1.setText("X");
			}
		});
		
		JButton botao2 = new JButton("1, 2");
		JButton botao3 = new JButton("1, 3");
		JButton botao4 = new JButton("2, 1");
		JButton botao5 = new JButton("2, 2");
		JButton botao6 = new JButton("2, 3");
		JButton botao7 = new JButton("3, 1");
		JButton botao8 = new JButton("3, 2");
		JButton botao9 = new JButton("3, 3");
		
		tabuleiro[0][0] = botao1;
		tabuleiro[0][1] = botao2;
		tabuleiro[0][2] = botao3;
		tabuleiro[1][0] = botao4;
		tabuleiro[1][1] = botao5;
		tabuleiro[1][2] = botao6;
		tabuleiro[2][0] = botao7;
		tabuleiro[2][1] = botao8;
		tabuleiro[2][2] = botao9;
		
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(new JSeparator(SwingConstants.VERTICAL));
		painel.add(botao4);
		painel.add(botao5);
		painel.add(botao6);
		painel.add(new JSeparator(SwingConstants.VERTICAL));
		painel.add(botao7);
		painel.add(botao8);
		painel.add(botao9);
		
		//janela.setSize(200, 300);
		janela.add(painel);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}
