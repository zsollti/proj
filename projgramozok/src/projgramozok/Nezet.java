package projgramozok;



import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nezet extends JPanel{
	
	protected JLabel label = new JLabel();
	
	/**
	 *A Rajzolhato interf�sszel rendelkez� objektumok
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
	 *�jrarajzolja az objektumokat
	 */
	public void mindentRajzol() {
		for(Rajzolhato o : objektumok) {
			o.rajzol();
		}
	}
	
	/**
	 *Elt�vol�tja a param�terk�nt kapott objektumot a list�b�l
	 */
	public void reamoveObjektum(Rajzolhato ob) {
		objektumok.remove(ob);
	}
	
	/**
	 *A param�terk�nt kapott objektumot hozz�adja az objektum list�j�hoz
	 */
	public void addObjektum(Rajzolhato ob) {
		objektumok.add(ob);
	}
	
	
}
