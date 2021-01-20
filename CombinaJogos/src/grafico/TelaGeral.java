package grafico;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class TelaGeral extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JToggleButton dezenas[];
	private JRadioButton[] quantidades;
	private ButtonGroup itens;
	public int xxx = 0;
	
	public TelaGeral(int linhax, int colunay, int minimus, int maximus) {
		
		//Prepando o Container
		Container container = getContentPane();
		
		//Criando os paineis para tela
		JPanel cartoes = new JPanel();
		JPanel QuantidadeDeDezenas = new JPanel();
		
		//Definindo variaveis de ambiente
		NumberFormat f = new DecimalFormat("00");
		
		//iniciando variaveis para preparar tela dos cartoes
		cartoes.setLayout(new GridLayout(linhax, colunay));
		dezenas = new JToggleButton[linhax * colunay];
		tratarDezenas tratarDezenas = new tratarDezenas();
		
		for(int i = 0; i < dezenas.length ; i++) {
			
			dezenas[i] = new JToggleButton(f.format(i));
			cartoes.add(dezenas[i]);
			//dezenas[i].addActionListener(tratDezenas);
		}
		
		QuantidadeDeDezenas.setLayout(new GridLayout(1, maximus - minimus + 1));
		quantidades = new JRadioButton[maximus - minimus + 1];
		itens = new ButtonGroup();
		
		for( int i = 0; i < quantidades.length ; i++ ) {
			
			quantidades[i] = new JRadioButton(f.format(i));
			quantidades[i].addItemListener(tratarDezenas);
			QuantidadeDeDezenas.add(quantidades[i]);
			itens.add(quantidades[i]);
		}
		
		container.add(cartoes, BorderLayout.NORTH);
		container.add(QuantidadeDeDezenas, BorderLayout.SOUTH);
//		container.add(itens,BorderLayout.SOUTH);
	}
	
	private class tratarDezenas implements ItemListener {
		
		// processa a seleção de aparência e comportamento feita pelo usuário
		public void itemStateChanged( ItemEvent evento )
		{
			for ( int count = 0; count < quantidades.length; count++ ) {
				if(quantidades[count].isSelected()) {
					xxx = Integer.parseInt(quantidades[count]);
					xxx = quantidades[count];
				}
			}
		}
	}
}
