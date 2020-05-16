package projgramozok;



import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;

public class Nezet extends JPanel{
	
	/**
	 *A Rajzolhato interfésszel rendelkezõ objektumok
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
	 *Újrarajzolja az objektumokat
	 */
	public void mindentRajzol() {
		
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
