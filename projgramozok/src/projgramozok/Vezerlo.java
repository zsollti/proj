package projgramozok;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
	
	/**
	 *J�t�k bez�r�sa gomb
	 */
	private JButton bBezaras;
	
	/**
	 *Label
	 */
	private JLabel label;
	
	/**
	 *Textfield, amibe a felhaszn�l� bele�rhatja, hogy h�ny j�t�kossal szeretne j�tszani.
	 */
	private JTextField textfield;
	
	/**
	 *J�t�kossz�m. (Default �rt�ke 3)
	 */
	private int jatekosszam = 3;
	
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
		
		//Gomb, label, textfield, panel inicializ�l�sa
		bInditas = new JButton("Ind�t�s"); 
        label = new JLabel("Adja meg a j�t�kossz�mot. (Csak sz�mot adjon meg!)");
        textfield = new JTextField(16);
        textfield.setText(Integer.toString(jatekosszam));
        buttonPanel = new JPanel();
       
        //Objektumok hozz�ad�sa a panelhez illetve framehez
        buttonPanel.add(label);
        buttonPanel.add(textfield);
        buttonPanel.add(bInditas);
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
        		if(Integer.parseInt(textfield.getText())>=3 && Integer.parseInt(textfield.getText())<=6)
        			jatekosszam = Integer.parseInt(textfield.getText());
        		
        		palya = new Palya(jatekosszam, "uj.txt");		//A p�lya k�tparam�teres konstruktor�t kell majd megh�vni, csak azon m�g v�ltoztatni kell
        		nezet = new Nezet();
        		
        		for(int i = 0; i < palya.tablak.size(); i++) {
        			
        			nezet.addObjektum(palya.tablak.get(i));
        		}
        		
        		jatek();
            }
        });
	}
	
	/**
	 *
	 */
	public void jatek () {
		palya.vezerlo = this;
		this.remove(buttonPanel);
		buttonPanel.removeAll();
		
		//Gombok inicializ�l�sa
		bAsas = new JButton("�s�s");
		bEves = new JButton("Ev�s");
		bKepesseg = new JButton("K�pess�g");
		bKotel = new JButton("K�t�l");
		bSator = new JButton("S�tor");
		bBezaras = new JButton("Bez�r�s");
		
		//Gombok panelhez ad�sa
		buttonPanel.add(bAsas);
		buttonPanel.add(bEves);
		buttonPanel.add(bKepesseg);
		buttonPanel.add(bKotel);
		buttonPanel.add(bSator);
		buttonPanel.add(bBezaras);
		
		//A gombokat tartalmazo panel framehez ad�sa
		this.add(buttonPanel, BorderLayout.NORTH);
		
		//A n�zet framehez ad�sa
		this.add(nezet, BorderLayout.CENTER);
		
		this.revalidate();
		this.repaint();
		
		/**
		 *Az �s�s gomb esem�nykezel�je
		 */
		bAsas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		
            }
        });
		
		/**
		 *Az ev�s gomb esem�nykezel�je
		 */
		bEves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		
            }
        });
		
		/**
		 *A k�pess�g gomb esem�nykezel�je
		 */
		bKepesseg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		
            }
        });
		
		/**
		 *A k�t�l gomb esem�nykezel�je
		 */
		bKotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		
            }
        });
		
		/**
		 *A s�tor gomb esem�nykezel�je
		 */
		bSator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		
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
	}
	
	/**
	 *
	 */
	public void frissit() {
		nezet.mindentRajzol();
	}
	
	
}
