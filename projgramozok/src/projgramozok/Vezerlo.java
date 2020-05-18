package projgramozok;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	 *Ev�s gomb
	 */
	private JButton bEves;
	
	/**
	 *Lap�t haszn�lata gomb gomb
	 */
	private JButton bLapat;
	
	/**
	 *T�r�keny �s� haszn�lata gomb
	 */
	private JButton bTaso;
	
	/**
	 *K�r �tad�sa gomb
	 */
	private JButton bKorvege;
	
	/**
	 *Alkatr�sz haszn�lata gomb
	 */
	private JButton bAlkatresz;
	
	/**
	 *T�rgy ki�s�sa gomb
	 */
	private JButton bTargykias;
	
	/**
	 *B�v�rruha label
	 */
	private JLabel buvarruha;
	
	/**
	 *H�pont label
	 */
	static JLabel hopont;
	
	/**
	 *J�t�k bez�r�sa gomb
	 */
	private JButton bBezaras;
	
	/**
	 *Label
	 */
	private JLabel label;
	
	/**
	 *Inform�ci�s label
	 */
	static JLabel info = new JLabel();
	
	/**
	 *J�t�kossz�m. (Default �rt�ke 3)
	 */
	private int jatekosszam = 3;
	
 	JComboBox<Object> cbSarkkutato;
 	JComboBox<Object> cbEszkimo;
	
 	/**
	 *A soron k�vetkez� j�t�kos
	 */
	private Szereplo aktualis;
	
	/**
	 *A t�bl�k poz�ci�it kisz�molja
	 */
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
	
	/**
	 *Konstruktor
	 */
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
        		if(jatekosszam == 0) {
        			vege("A f�jl nem tal�lhat�");
        			}
        		else{
        			nezet = new Nezet();
        			TablaPosBeallit();      		
        			jatek();
        		}
	}
	
	
	/**
	 *Figyeli a felhaszn�l�i inputokat �s ezek alapj�n
	 *sz�l a p�ly�nak  v�ltoztat�sr�l illetve a n�zetnek ha sz�ks�ges.
	 */
	public void jatek () {
		this.addMouseListener(new Eger());
		Palya.vezerlo = this;
		this.remove(buttonPanel);
		buttonPanel.removeAll();
		
		//Gombok inicializ�l�sa
		bAsas = new JButton("�s�s");
		bEves = new JButton("Ev�s");
		bKotel = new JButton("K�t�l");
		bSator = new JButton("S�tor");
		bLapat = new JButton("Lap�t");
		bTaso = new JButton("T�r�keny �s�");
		bKorvege = new JButton("K�r �tad�sa");
		bAlkatresz = new JButton("Alkatr�sz");
		bBezaras = new JButton("Bez�r�s");
		bTargykias = new JButton("T�rgy ki�s�sa");
		
		buvarruha = new JLabel("| B�v�rruha");
		hopont = new JLabel("H�pont: ");
		
		//Gombok panelhez ad�sa
		buttonPanel.add(hopont);
		buttonPanel.add(bAsas);
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
		buttonPanel.add(buvarruha);
		
		/**
		 *A gombokat tartalmazo panel framehez ad�sa
		 */
		this.add(buttonPanel, BorderLayout.NORTH);
		
		/**
		 *A n�zet framehez ad�sa
		 */
		this.add(nezet, BorderLayout.CENTER);
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
		
		/**
		 *A lap�t gomb esem�nykezel�je
		 */
		bLapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Lapat");
            	frissit();
            }
        });
		
		/**
		 *A t�r�keny �s� gomb esem�nykezel�je
		 */
		bTaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targyhasznal Torekeny_aso");
            	gombBeallit();
            	frissit();
            }
        });
		
		/**
		 *A a k�rv�ge gomb esem�nykezel�je
		 */
		bKorvege.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("endTurn");
            }
        });
		
		/**
		 *A t�rgyki�s gomb esem�nykezel�je
		 */
		bTargykias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	((Karakter)aktualis).tevekenyseg("targykias");
            	gombBeallit();
            	frissit();
            }
        });
		
		/**
		 *Az alkatr�sz gomb esem�nykezel�je
		 */
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
	
	/**
	 *Az eg�r esem�nykezel�je
	 *Bal klikk l�p�s a t�bl�ra
	 *Jobb klikk k�pess�g haszn�lata
	 */
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
	
	/**
	 *A s�tor gomb esem�nykezel�je
	 */
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
		frissit();
	}
	
	/**
	 *Az soron k�vetkez� karakter t�rgyai alapj�n l�that�v� teszi a hozz�juk tartoz� gombokat
	 */
	public void gombBeallit() {
		bEves.setVisible(false);
		bLapat.setVisible(false);
		bKotel.setVisible(false);
		bTaso.setVisible(false);
		bSator.setVisible(false);
		bAlkatresz.setVisible(false);
		buvarruha.setVisible(false);
		
		if(aktualis.getInventory() != null) {
		Set<String> targyak = aktualis.getInventory().keySet();
			for(String s: targyak) {
				switch(s) {
					case "Elelem": bEves.setVisible(true); break;
					case "Lapat": bLapat.setVisible(true); break;
					case "Kotel": bKotel.setVisible(true); break;
					case "Torekeny_aso": bTaso.setVisible(true); break;
					case "Sator": bSator.setVisible(true); break;
					case "Alkatresz": bAlkatresz.setVisible(true); break;
					case "Buvarruha": buvarruha.setVisible(true); break;
				}
			}
		}
	}
	
	/**
	 *J�t�k v�ge ut�n felugr� ablak.
	 *Ki�rja, hogy melyik j�t�kos halt meg.
	 *@param szoveg A k��rand� sz�veg
	 */
	public void vege(String szoveg) {
		JFrame felugro = new JFrame("V�ge");
		felugro.setSize(200, 150);
		felugro.setLocation(350, 350);
		JLabel label = new JLabel(szoveg);
		JButton gomb = new JButton("bez�r");
		
		/**
		 *Bez�r�s gomb.
		 *Kattint�ssal bez�rja az alkalmaz�st.
		 */
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
	 *Friss�t a n�zetet
	 */
	public void frissit() {
		nezet.mindentRajzol();
	}
	
	
}
