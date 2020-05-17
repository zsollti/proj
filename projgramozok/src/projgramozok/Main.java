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
 * Main. Megjelenít egy ablakot, aminek a segítségével elindítható egy új vagy egy már létezõ pálya.
 *
 */
public class Main {
/**
 * main függvény
 * Megjelenít egy ablakot, aminek a segítségével elindítható egy új vagy egy már létezõ pálya.
 */
	public static void main(String[] args) { 
		JFrame valaszt = new JFrame("Játék indítása"); 
		valaszt.setMinimumSize(new Dimension(800, 150));
		valaszt.setLocation(300, 300);
		valaszt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel uzenet = new JLabel("Új játékot szeretnél vagy már egy létezõt betölteni?");
		JLabel leiras = new JLabel("Útmutató: A játékosok képességét a megfelelõ táblára történõ jobb kattintással lehet használni.");
		JButton buj = new JButton("Új");
		JButton  bbetolt = new JButton("Betöltés");
		JPanel gombok = new JPanel();
		JLabel fajlnev = new JLabel("betöltés esetén a fájl neve:");
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
		 * Az új gomb eseménykezelõje. Létrehoz egy új pályát.
		 */
		buj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	valaszt.dispose();
        		new Vezerlo();     		
            }
        });
		
		/**
		 * A betöltés gomb eseménykezelõje. A megadott fájlból olvassa be a pályát.
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
