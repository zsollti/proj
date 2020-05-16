package projgramozok;



import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;

public class Nezet extends JPanel{
	
	/**
	 *A Rajzolhato interf�sszel rendelkez� objektumok
	 */
	private List<Rajzolhato> objektumok;
	
	
	/**
	 *Konstruktor
	 */
	public Nezet() {
		super();
		this.setBackground(Color.blue);
		this.setVisible(true);
	}
	
	/**
	 *�jrarajzolja az objektumokat
	 */
	public void mindentRajzol() {
		
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
