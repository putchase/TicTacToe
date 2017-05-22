package Cliente;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Jogo {
	public static void main(String [] args){
		JFrame janela = new JFrame("TicTacToe");
		JPanel painel = new JPanel();
		JPanel linha1 = new JPanel();
		JPanel linha2 = new JPanel();
		JPanel linha3 =  new JPanel();
		JButton tabuleiro[][] = new JButton[3][3];
		
		JButton botao1 = new JButton(" ");
		botao1.setFont(new java.awt.Font(null, 1, 12));
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				botao1.setText("X");
			}
		});
		
		JButton botao2 = new JButton(" ");
		botao2.setFont(new Font(null, 1, 12));
		JButton botao3 = new JButton(" ");
		botao3.setFont(new Font(null, 1, 12));
		JButton botao4 = new JButton(" ");
		JButton botao5 = new JButton(" ");
		JButton botao6 = new JButton(" ");
		JButton botao7 = new JButton(" ");
		JButton botao8 = new JButton(" ");
		JButton botao9 = new JButton(" ");
		
		tabuleiro[0][0] = botao1;
		tabuleiro[0][1] = botao2;
		tabuleiro[0][2] = botao3;
		tabuleiro[1][0] = botao4;
		tabuleiro[1][1] = botao5;
		tabuleiro[1][2] = botao6;
		tabuleiro[2][0] = botao7;
		tabuleiro[2][1] = botao8;
		tabuleiro[2][2] = botao9;
		
		
		linha1.add(botao1);
		linha1.add(botao2);
		linha1.add(botao3);
		
		
		//linha2.add(new JSeparator(SwingConstants.HORIZONTAL));	
		linha2.add(botao4);
		linha2.add(botao5);
		linha2.add(botao6);
		
		//linha3.add(new JSeparator(SwingConstants.HORIZONTAL));
		linha3.add(botao7);
		linha3.add(botao8);
		linha3.add(botao9);
		
		painel.add(linha1);
		painel.add(linha2);
		painel.add(linha3);
		painel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		
		janela.setSize(200, 300);
		janela.add(painel);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}
