package projgramozok;



import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nezet extends JPanel{
	
	protected JLabel label = new JLabel();
	
	/**
	 *A Rajzolhato interfésszel rendelkezõ objektumok
	 */
	private ArrayList<Rajzolhato> objektumok = new ArrayList<Rajzolhato>();
	
	
	/**
	 *Konstruktor
	 */
	public Nezet() {
		super();
		this.setBackground(Color.blue);
		add(label);
		this.setVisible(true);
	}
	
	/**
	 *Újrarajzolja az objektumokat
	 */
	public void mindentRajzol() {
		for(Rajzolhato o : objektumok) {
			o.rajzol();
		}
	}
	
	/**
	 *Eltávolítja a paraméterként kapott objektumot a listából
	 */
	public void reamoveObjektum(Rajzolhato ob) {
		objektumok.remove(ob);
	}
	
	/**
	 *A paraméterként kapott objektumot hozzáadja az objektum listájához
	 */
	public void addObjektum(Rajzolhato ob) {
		objektumok.add(ob);
	}
	
	
}
