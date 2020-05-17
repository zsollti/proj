package projgramozok;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main {

	public static void main(String[] args) {
		JFrame valaszt = new JFrame("Játék indítása");
		valaszt.setMinimumSize(new Dimension(400, 150));
		valaszt.setLocation(300, 300);
		valaszt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel uzenet = new JLabel("Új játékot szeretnél vagy már egy létezõt betölteni?");
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
		valaszt.add(uzenet, BorderLayout.NORTH);
		valaszt.add(felso, BorderLayout.CENTER);
		valaszt.add(gombok, BorderLayout.SOUTH);
		valaszt.setVisible(true);
		
		buj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	valaszt.dispose();
        		new Vezerlo();     		
            }
        });
		
		bbetolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           	
            	if(fnev.getText().length() != 0) {
            		valaszt.dispose();
            		new Vezerlo(fnev.getText());
            	}
            }
        });
		
		
	
		
		//Palya p;
		
		//String s = "";
		/**
		 * Két beolvasó scanner, az egyik a konzolos, a másik fájlból történõ beolvasáshoz
		 */
		/*
		Scanner sc = new Scanner(System.in);
		Scanner fr = null;

		while(true) {	//addig fut a program, míg ki nem lépünk, vagy esetleges hibát nem kapunk
			Kiiro.Kiir("Válaszd ki a futtatni kívánt cselekvést.\n");
			Kiiro.Kiir("jatekBetolt [fajlnév]: Mentett játék betöltése");
			Kiiro.Kiir("jatekBetolt: Új játék kezdése");
			Kiiro.Kiir("testBeolvas [fájlnnév]: Teszteset beolvasása fájlból és futtatása");
			Kiiro.Kiir("kilep: Kilépés");
			
			s = sc.nextLine();
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
				case "jatekBetolt":	//pálya betöltése
					if(ss.length == 2) {	//meglévõ mentett játékállapot betöltése
						p = new Palya(ss[1]);
						p.start(sc);
					} else {	//egy új játék betöltése a megadott játékosszámmal
						Kiiro.Kiir("Hány játékos legyen?");
						int n = sc.nextInt();
						p = new Palya(n, "uj.txt");
						p.start(sc);
					}
					break;
				case "testBeolvas":	//teszt betöltése
				try {
					String string = "Tesztek/"+ss[1];
					fr = new Scanner(new FileReader(string));
					String ts = fr.nextLine();
					String[] tss = ts.split(" ");
					p = new Palya(tss[1]);
					p.start(fr);
				} catch (FileNotFoundException e) {
					Kiiro.Kiir("A fajl nem talalhato");
					break;
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}finally {
					if(fr != null)
					fr.close();
				}
					break;
				case "kilep":	//kilépés
					sc.close();
					System.exit(0);
					break;
				default:  
					Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
				break;
				
			}
		}*/
	}
}
