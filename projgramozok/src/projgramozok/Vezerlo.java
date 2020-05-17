package projgramozok;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


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
	
	static JLabel info = new JLabel();
	/**
	 *Játékosszám. (Default értéke 3)
	 */
	private int jatekosszam = 3;
	
 	JComboBox<Object> cbSarkkutato;
 	JComboBox<Object> cbEszkimo;
	
	
	private Szereplo aktualis;
	
	private void TablaPosBeallit() {
		int xcenter = Vezerlo.nezet.bi.getWidth()/2;
		int ycenter = Vezerlo.nezet.bi.getHeight()/2;
		int dist = 150;
		for(int i = 0; i < Palya.tablak.size(); i++) {
			nezet.addObjektum(Palya.tablak.get(i));
			Palya.tablak.get(i).y = ycenter - 2*dist + (i/4)*dist;
			Palya.tablak.get(i).x = xcenter - 2*dist + (i%4)*dist;
		}
	}
	
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
		Kepek.create();
		
		//Gomb, label, textfield, panel inicializálása
		bInditas = new JButton("Indítás"); 
        label = new JLabel("Válassza ki a sarkkutatók és az eszkimók számát! (Összesen legalább 3, legfeljebb 6 lehet.)");
        buttonPanel = new JPanel();
    	Object[] jatekos = {"0", "1", "2", "3", "4","5","6"};
    	cbSarkkutato = new JComboBox<Object>(jatekos);
	    cbEszkimo = new JComboBox<Object>(jatekos);
	    info = new JLabel("");
       
        //Objektumok hozzáadása a panelhez illetve framehez
        buttonPanel.add(label);
        buttonPanel.add(cbSarkkutato);
        buttonPanel.add(cbEszkimo);
        buttonPanel.add(bInditas);
        buttonPanel.add(info);

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
            	
            	int sarkkutatoszam = Integer.parseInt(((String)cbSarkkutato.getSelectedItem()));
            	int eszkimoszam = Integer.parseInt(((String)cbEszkimo.getSelectedItem()));
            	jatekosszam = sarkkutatoszam + eszkimoszam;
            	if(jatekosszam < 3 || jatekosszam > 6)
            		info.setText("Nem jó a játékosszám :( Próbáld újra!");
			   
				    
            	else {
            		palya = new Palya(sarkkutatoszam, eszkimoszam, "uj.txt");		//A pálya kétparaméteres konstruktorát kell majd meghívni, csak azon még változtatni kell
            		nezet = new Nezet();
            		TablaPosBeallit();
            		jatek();
            	}
            }
        });
	}
	
	public Vezerlo(String fname) {
		//A jFrame beállítása.
		super("Játék");
		this.setBounds(10, 10, 1205, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Kepek.create();
		
		buttonPanel = new JPanel();
		this.add(buttonPanel, BorderLayout.NORTH);
		this.setVisible(true); 
		        		
        		palya = new Palya(fname);
        		jatekosszam = Palya.jatekosok;
        		nezet = new Nezet();
        		
        		TablaPosBeallit();      		
        		jatek();
	}
	
	/**
	 *
	 */
	public void jatek () {
		this.addMouseListener(new Eger());
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
		buttonPanel.add(info);
		
		
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
        		frissit();
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
        		frissit();
            }
        });
		
		/**
		 *A kötél gomb eseménykezelõje
		 */
		bKotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Kotel");
            	frissit();
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
            	frissit();
            }
        });
		
		bLapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Lapat");
            	frissit();
            }
        });
		
		bTaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Torekeny_aso");
            	gombBeallit();
            	frissit();
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
            	gombBeallit();
            	frissit();
            }
        });
		
		bAlkatresz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Alkatresz");
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
	
	public class Eger implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY() - 50;
			for(Tabla t: Palya.tablak) {
				if(t.x < x && t.x+100 > x && t.y < y && t.y+100 > y) {
					if (SwingUtilities.isRightMouseButton(e)) {
						((Karakter)aktualis).tevekenyseg("kepesseg "+Palya.tablak.indexOf(t));
					}
					else
						((Karakter)aktualis).tevekenyseg("lep "+Palya.tablak.indexOf(t));
				}
			}
			frissit();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public void players() {
		frissit();
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
		felugro.setSize(200, 150);
		felugro.setLocation(350, 350);
		JLabel label = new JLabel(szoveg);
		JButton gomb = new JButton("bezár");
		gomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
		felugro.add(label, BorderLayout.NORTH);
		felugro.add(gomb, BorderLayout.CENTER);
		felugro.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		felugro.setVisible(true);
		this.setVisible(false);
		
	}
	/**
	 *
	 */
	public void frissit() {
		nezet.mindentRajzol();
	}
	
	
}
