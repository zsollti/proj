package projgramozok;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Main. Megjelen�t egy ablakot, aminek a seg�ts�g�vel elind�that� egy �j vagy egy m�r l�tez� p�lya.
 *
 */
public class Main {
/**
 * main f�ggv�ny
 * Megjelen�t egy ablakot, aminek a seg�ts�g�vel elind�that� egy �j vagy egy m�r l�tez� p�lya.
 */
	public static void main(String[] args) { 
		JFrame valaszt = new JFrame("J�t�k ind�t�sa"); 
		valaszt.setMinimumSize(new Dimension(800, 150));
		valaszt.setLocation(300, 300);
		valaszt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel uzenet = new JLabel("�j j�t�kot szeretn�l vagy m�r egy l�tez�t bet�lteni?");
		JLabel leiras = new JLabel("�tmutat�: A j�t�kosok k�pess�g�t a megfelel� t�bl�ra t�rt�n� jobb kattint�ssal lehet haszn�lni.");
		JButton buj = new JButton("�j");
		JButton  bbetolt = new JButton("Bet�lt�s");
		JPanel gombok = new JPanel();
		JLabel fajlnev = new JLabel("bet�lt�s eset�n a f�jl neve:");
		JTextField fnev = new JTextField(20);
		fnev.setText("palya.txt");
		JPanel felso = new JPanel();
		felso.add(fajlnev);
		felso.add(fnev);
		gombok.add(buj);
		gombok.add(bbetolt);
		valaszt.add(leiras, BorderLayout.WEST);
		valaszt.add(uzenet, BorderLayout.NORTH);
		valaszt.add(felso, BorderLayout.CENTER);
		valaszt.add(gombok, BorderLayout.SOUTH);
		valaszt.setVisible(true);
		/**
		 * Az �j gomb esem�nykezel�je. L�trehoz egy �j p�ly�t.
		 */
		buj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	valaszt.dispose();
        		new Vezerlo();     		
            }
        });
		
		/**
		 * A bet�lt�s gomb esem�nykezel�je. A megadott f�jlb�l olvassa be a p�ly�t.
		 */
		
		bbetolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           	
            	if(fnev.getText().length() != 0) {
            		valaszt.dispose();
            		new Vezerlo(fnev.getText());
            	}
            }
        });
		
	}
}
