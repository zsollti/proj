package projgramozok;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nezet extends JPanel{
	
	protected JLabel label = new JLabel();
	
	/**
	 *A Rajzolhato interfésszel rendelkezõ objektumok
	 */
	private ArrayList<Rajzolhato> objektumok = new ArrayList<Rajzolhato>();
	
	protected BufferedImage bi = new BufferedImage(1100, 600, BufferedImage.TYPE_INT_ARGB);
	
	
	/**
	 *Konstruktor
	 */
	public Nezet() {
		super();
		//this.setBackground(Color.blue);
		label.setLocation(100, 200);
		add(label);
		this.setVisible(true);
	}
	
	/**
	 *Újrarajzolja az objektumokat
	 */
	public void mindentRajzol() {
		Graphics g = bi.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
		ImageIcon icon = new ImageIcon(Vezerlo.nezet.bi);
		Vezerlo.nezet.label.setIcon(icon);
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
