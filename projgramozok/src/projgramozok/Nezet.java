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
	
	protected BufferedImage bi = new BufferedImage(1205, 700, BufferedImage.TYPE_INT_ARGB);
	
	
	/**
	 *Konstruktor
	 */
	public Nezet() {
		super();
		//this.setBackground(Color.blue);
		label.setLocation(0, 0);
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
			o.rajzol(0, 0);
		}
		
		g.setColor(Color.BLACK);
		for(int i = 0; i < Palya.tablak.size(); i++) {
			for(int j = i; j < Palya.tablak.size(); j++) {
				if(Palya.tablak.get(i).szomszede(Palya.tablak.get(j))) {
					g.drawLine(Palya.tablak.get(i).x+50, Palya.tablak.get(i).y+50, Palya.tablak.get(j).x+50, Palya.tablak.get(j).y+50);
				}
			}
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
