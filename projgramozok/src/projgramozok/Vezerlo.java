package projgramozok;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Vezerlo extends JFrame {
	
	/**
	 *A vezérlõhöz tartozó pálya
	 */
	static Palya palya;
	
	/**
	 *A vezérlõhöz tartozó nézet
	 */
	static Nezet nezet;
	
	private JPanel buttonPanel;
	
	/**
	 *Indítás gomb
	 */
	private JButton bInditas;
	
	/**
	 *Ásás gomb
	 */
	private JButton bAsas;
	
	/**
	 *Kötél használat gomb
	 */
	private JButton bKotel;
	
	/**
	 *Sátor felállítása gomb
	 */
	private JButton bSator;
	
	/**
	 *Képesség használat gomb
	 */
	private JButton bKepesseg;
	
	/**
	 *Evés gomb
	 */
	private JButton bEves;
	
	private JButton bLapat;
	
	private JButton bTaso;
	
	private JButton bKorvege;
	
	private JButton bAlkatresz;
	
	private JButton bTargykias;
	
	/**
	 *Játék bezárása gomb
	 */
	private JButton bBezaras;
	
	/**
	 *Label
	 */
	private JLabel label;
	
	/**
	 *Textfield, amibe a felhasználó beleírhatja, hogy hány játékossal szeretne játszani.
	 */
	private JTextField textfield;
	
	/**
	 *Játékosszám. (Default értéke 3)
	 */
	private int jatekosszam = 3;
	
	private Szereplo aktualis;
	
	/**
	 *Konstruktor
	 *Létrehoz egy framet, lehetõséget ad a játékosszám megadására.
	 *Egy gombnyomásra inicilizálja a pályát és a nézetet,
	 *majd elindítja a játékot.
	 */
	public Vezerlo() {
		//A jFrame beéllítása.
		super("Játék");
		this.setBounds(10, 10, 1205, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//Gomb, label, textfield, panel inicializálása
		bInditas = new JButton("Indítás"); 
        label = new JLabel("Adja meg a játékosszámot. (Csak számot adjon meg!)");
        textfield = new JTextField(16);
        textfield.setText(Integer.toString(jatekosszam));
        buttonPanel = new JPanel();
       
        //Objektumok hozzáadása a panelhez illetve framehez
        buttonPanel.add(label);
        buttonPanel.add(textfield);
        buttonPanel.add(bInditas);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.setVisible(true); 
        
        /**
    	 *A bInditas gomb eseménykezelõje
    	 *A játékosszámot beállítja a textfieldbe írt értékre
    	 *Inicializálja a pályát és a nézetet
    	 *Elindítja a játékot
    	 */
        bInditas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
        		if(Integer.parseInt(textfield.getText())>=3 && Integer.parseInt(textfield.getText())<=6)
        			jatekosszam = Integer.parseInt(textfield.getText());
            	}catch(NumberFormatException n) {
            		n.printStackTrace();
            	}catch(InputMismatchException i) {
            		i.printStackTrace();
            	}
        		
        		palya = new Palya(jatekosszam, "uj.txt");		//A pálya kétparaméteres konstruktorát kell majd meghívni, csak azon még változtatni kell
        		nezet = new Nezet();
        		
        		for(int i = 0; i < Palya.tablak.size(); i++) {
        			nezet.addObjektum(Palya.tablak.get(i));
        			Palya.tablak.get(i).y = i*5;
        			Palya.tablak.get(i).x = i*5;
        		}
        		
        		jatek();
            }
        });
	}
	
	/**
	 *
	 */
	public void jatek () {
		Palya.vezerlo = this;
		this.remove(buttonPanel);
		buttonPanel.removeAll();
		
		//Gombok inicializálása
		bAsas = new JButton("Ásás");
		bEves = new JButton("Evés");
		bKepesseg = new JButton("Képesség");
		bKotel = new JButton("Kötél");
		bSator = new JButton("Sátor");
		bLapat = new JButton("Lapát");
		bTaso = new JButton("Törékeny ásó");
		bKorvege = new JButton("Kör átadása");
		bAlkatresz = new JButton("Alkatrész");
		bBezaras = new JButton("Bezárás");
		bTargykias = new JButton("Tárgy kiásása");
		
		//Gombok panelhez adása
		buttonPanel.add(bAsas);
		buttonPanel.add(bKepesseg);
		buttonPanel.add(bKorvege);
		buttonPanel.add(bEves);
		buttonPanel.add(bKotel);
		buttonPanel.add(bSator);
		buttonPanel.add(bLapat);
		buttonPanel.add(bTaso);
		buttonPanel.add(bAlkatresz);
		buttonPanel.add(bTargykias);
		buttonPanel.add(bBezaras);
		
		
		//A gombokat tartalmazo panel framehez adása
		this.add(buttonPanel, BorderLayout.NORTH);
		
		//A nézet framehez adása
		this.add(nezet, BorderLayout.WEST);
		this.revalidate();
		this.repaint();
		
		/**
		 *Az ásás gomb eseménykezelõje
		 */
		bAsas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		((Karakter)aktualis).tevekenyseg("hoasas");
            }
        });
		
		/**
		 *Az evés gomb eseménykezelõje
		 */
		bEves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		((Karakter)aktualis).tevekenyseg("targyhasznal Elelem");
        		gombBeallit();
            }
        });
		
		/**
		 *A képesség gomb eseménykezelõje
		 */
		bKepesseg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		((Karakter)aktualis).tevekenyseg("kepesseg");
            }
        });
		
		/**
		 *A kötél gomb eseménykezelõje
		 */
		bKotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Kotel");
            }
        });
		
		/**
		 *A sátor gomb eseménykezelõje
		 */
		bSator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Sator");
            	gombBeallit();
            }
        });
		
		bLapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Lapat");
            }
        });
		
		bTaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Torekeny_aso");
            	gombBeallit();
            }
        });
		
		bKorvege.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("endTurn");
            }
        });
		
		bTargykias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targykias");
            }
        });
		
		/**
		 *A bezárás gomb eseménykezelõje
		 *Gombnyomáskor bezárja a játékot.
		 */
		bBezaras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		System.exit(0);
            }
        });
		aktualis = Palya.szereplok.get(jatekosszam);
		players();
		frissit();
	}
	
	public void players() {
		int index = Palya.szereplok.indexOf(aktualis)+1;
		
		if(index == Palya.jatekosok + 1) {
			palya.start();
			index = 0;
		}
		
		aktualis = Palya.szereplok.get(index);
		gombBeallit();
		
		aktualis.korkezd();
	}
	
	public void gombBeallit() {
		bEves.setVisible(false);
		bLapat.setVisible(false);
		bKotel.setVisible(false);
		bTaso.setVisible(false);
		bSator.setVisible(false);
		bAlkatresz.setVisible(false);
		
		if(aktualis.getInventory() != null) {
		Set<String> targyak = aktualis.getInventory().keySet();
			for(String s: targyak) {
				switch(s) {
					case "Elelem": bEves.setVisible(true);
					case "Lapat": bLapat.setVisible(true);
					case "Kotel": bKotel.setVisible(true);
					case "Torekeny_aso": bTaso.setVisible(true);
					case "Sator": bSator.setVisible(true);
					case "Alkatresz": bAlkatresz.setVisible(true);
				}
			}
		}
	}
	
	public void vege(String szoveg) {
		JFrame felugro = new JFrame("Vége");
		JLabel label = new JLabel(szoveg);
		JButton gomb = new JButton("bezár");
		gomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
		felugro.add(label);
		felugro.add(gomb);
		felugro.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		felugro.setVisible(true);
	}
	/**
	 *
	 */
	public void frissit() {
		nezet.mindentRajzol();
	}
	
	
}
