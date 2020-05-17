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
	 *A vez�rl�h�z tartoz� p�lya
	 */
	static Palya palya;
	
	/**
	 *A vez�rl�h�z tartoz� n�zet
	 */
	static Nezet nezet;
	
	private JPanel buttonPanel;
	
	/**
	 *Ind�t�s gomb
	 */
	private JButton bInditas;
	
	/**
	 *�s�s gomb
	 */
	private JButton bAsas;
	
	/**
	 *K�t�l haszn�lat gomb
	 */
	private JButton bKotel;
	
	/**
	 *S�tor fel�ll�t�sa gomb
	 */
	private JButton bSator;
	
	/**
	 *K�pess�g haszn�lat gomb
	 */
	private JButton bKepesseg;
	
	/**
	 *Ev�s gomb
	 */
	private JButton bEves;
	
	private JButton bLapat;
	
	private JButton bTaso;
	
	private JButton bKorvege;
	
	private JButton bAlkatresz;
	
	private JButton bTargykias;
	
	/**
	 *J�t�k bez�r�sa gomb
	 */
	private JButton bBezaras;
	
	/**
	 *Label
	 */
	private JLabel label;
	
	static JLabel info = new JLabel();
	/**
	 *J�t�kossz�m. (Default �rt�ke 3)
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
	 *L�trehoz egy framet, lehet�s�get ad a j�t�kossz�m megad�s�ra.
	 *Egy gombnyom�sra iniciliz�lja a p�ly�t �s a n�zetet,
	 *majd elind�tja a j�t�kot.
	 */
	public Vezerlo() {
		//A jFrame be�ll�t�sa.
		super("J�t�k");
		this.setBounds(10, 10, 1205, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Kepek.create();
		
		//Gomb, label, textfield, panel inicializ�l�sa
		bInditas = new JButton("Ind�t�s"); 
        label = new JLabel("V�lassza ki a sarkkutat�k �s az eszkim�k sz�m�t! (�sszesen legal�bb 3, legfeljebb 6 lehet.)");
        buttonPanel = new JPanel();
    	Object[] jatekos = {"0", "1", "2", "3", "4","5","6"};
    	cbSarkkutato = new JComboBox<Object>(jatekos);
	    cbEszkimo = new JComboBox<Object>(jatekos);
	    info = new JLabel("");
       
        //Objektumok hozz�ad�sa a panelhez illetve framehez
        buttonPanel.add(label);
        buttonPanel.add(cbSarkkutato);
        buttonPanel.add(cbEszkimo);
        buttonPanel.add(bInditas);
        buttonPanel.add(info);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.setVisible(true); 
        
        /**
    	 *A bInditas gomb esem�nykezel�je
    	 *A j�t�kossz�mot be�ll�tja a textfieldbe �rt �rt�kre
    	 *Inicializ�lja a p�ly�t �s a n�zetet
    	 *Elind�tja a j�t�kot
    	 */
        
        
   
        bInditas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int sarkkutatoszam = Integer.parseInt(((String)cbSarkkutato.getSelectedItem()));
            	int eszkimoszam = Integer.parseInt(((String)cbEszkimo.getSelectedItem()));
            	jatekosszam = sarkkutatoszam + eszkimoszam;
            	if(jatekosszam < 3 || jatekosszam > 6)
            		info.setText("Nem j� a j�t�kossz�m :( Pr�b�ld �jra!");
			   
				    
            	else {
            		palya = new Palya(sarkkutatoszam, eszkimoszam, "uj.txt");		//A p�lya k�tparam�teres konstruktor�t kell majd megh�vni, csak azon m�g v�ltoztatni kell
            		nezet = new Nezet();
            		TablaPosBeallit();
            		jatek();
            	}
            }
        });
	}
	
	public Vezerlo(String fname) {
		//A jFrame be�ll�t�sa.
		super("J�t�k");
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
		
		//Gombok inicializ�l�sa
		bAsas = new JButton("�s�s");
		bEves = new JButton("Ev�s");
		bKepesseg = new JButton("K�pess�g");
		bKotel = new JButton("K�t�l");
		bSator = new JButton("S�tor");
		bLapat = new JButton("Lap�t");
		bTaso = new JButton("T�r�keny �s�");
		bKorvege = new JButton("K�r �tad�sa");
		bAlkatresz = new JButton("Alkatr�sz");
		bBezaras = new JButton("Bez�r�s");
		bTargykias = new JButton("T�rgy ki�s�sa");
		
		//Gombok panelhez ad�sa
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
		
		
		//A gombokat tartalmazo panel framehez ad�sa
		this.add(buttonPanel, BorderLayout.NORTH);
		
		//A n�zet framehez ad�sa
		this.add(nezet, BorderLayout.WEST);
		this.revalidate();
		this.repaint();
		
		/**
		 *Az �s�s gomb esem�nykezel�je
		 */
		bAsas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		((Karakter)aktualis).tevekenyseg("hoasas");
        		frissit();
            }
        });
		
		/**
		 *Az ev�s gomb esem�nykezel�je
		 */
		bEves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		((Karakter)aktualis).tevekenyseg("targyhasznal Elelem");
        		gombBeallit();
            }
        });
		
		/**
		 *A k�pess�g gomb esem�nykezel�je
		 */
		bKepesseg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		((Karakter)aktualis).tevekenyseg("kepesseg");
        		frissit();
            }
        });
		
		/**
		 *A k�t�l gomb esem�nykezel�je
		 */
		bKotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Kotel");
            	frissit();
            }
        });
		
		/**
		 *A s�tor gomb esem�nykezel�je
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
		 *A bez�r�s gomb esem�nykezel�je
		 *Gombnyom�skor bez�rja a j�t�kot.
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
		JFrame felugro = new JFrame("V�ge");
		felugro.setSize(200, 150);
		felugro.setLocation(350, 350);
		JLabel label = new JLabel(szoveg);
		JButton gomb = new JButton("bez�r");
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
