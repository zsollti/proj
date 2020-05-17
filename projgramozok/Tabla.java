package projgramozok;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**A t�bl�kat megval�s�t� oszt�ly.
 *
 */

public class Tabla implements Rajzolhato{
	
	/**
	 *A t�bl�ra �p�tett mened�k
	 */
	protected Menedek menedek;
	
	/**
	 *A t�bl�ra rak�dott h� mennyis�ge
	 */
	protected int homennyiseg;
	
	/**
	 *A t�bla �tfordult �llapota
	 */
	protected boolean atfordul;
	
	/**
	 *A t�bl� elhelyezked� szerepl�k
	 */
	protected List<Szereplo> szereplok;
	
	/**
	 *A t�bl�ba fagyott t�rgy
	 */
	protected Targy targy;
	
	/**
	 *Az adott t�bla szomsz�dai
	 */
	protected List<Tabla> szomszed;
	
	protected int x, y;
	
	/**Konstruktor. L�trehoz egy alap�rt�kekkel rendelkez� t�bl�t.
	 * 
	 */	
	public Tabla() {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		menedek = null;
		targy = null;
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
	}
	
	/**Konstruktor. Param�terek alapj�n hoz l�tre t�bl�t.
	 * @param ho A t�bl�n l�v� kezd� h�mennyis�g
	 * @param atfordult A t�bla �t van-e fordulba kezdetben
	 */
	public Tabla(int ho, boolean atfordult) {
		szereplok = new ArrayList<Szereplo>();
		homennyiseg = ho;
		menedek = null;
		targy = null;
		atfordul = atfordult;
		szomszed = new ArrayList<Tabla>();
	}
	
	/**Visszadja a t�bla szerepl�it.
	 * @return a t�bl�n �ll� szerepl�k
	 */
	public List<Szereplo> getSzereplok(){
		return szereplok;
	}
	
	/**Szomsz�ds�got vizsg�l k�t t�bla k�z�tt.
	 * @param sz a vizsg�land� t�bla
	 * @return igaz, ha szomsz�d
	 */
	public boolean szomszede(Tabla sz){
		for(Tabla szo: szomszed) {
			if(szo.equals(sz)) return true;
		}
		return false;
	}
	
	/**Mened�ket helyez a t�bl�ra.
	 * @param m a fel�ll�tand� mened�k
	 */
	public void setMenedek(Menedek m) {
		if(menedek != null) {
			menedek.destroy();
		}
		if(menedek == null) {
			menedek = m;
		}
		if (menedek != null && m != null) Kiiro.Kiir("A mened�k fel�p�lt");

	}
	
	/**Valaki r�l�p a t�bl�ra. Ezen a t�bl�n az �sszes karakter elf�r.
	 * @param k elt�rolja a saj�tjai k�zt.
	 */
	public void ralep(Szereplo k){
		this.szereplok.add(k);
		szereplok.get(0).utkozik(k);
		k.setTabla(this);
	}
	
	/**Valaki lel�p a t�bl�r�l
	 * @param k Elt�vol�tja a saj�tjai k�z�l.
	 */
	public void lelep(Szereplo k) {
		this.szereplok.remove(k);
	}
	
	/**A t�bl�n lev� h� mennyis�g�t v�ltoztatja. Maximum 5 minimum 0 lehet rajta.
	 * @param i ennyivel v�ltozik a h�mennyis�g. El�jeles.
	 */
	public void addhomennyiseg(int i){
		Kiiro.Kiir("A r�gi h�mennyis�g: " + this.homennyiseg);
		homennyiseg += i;
		if(i > 0 && menedek == null) {
			for(Szereplo sz: szereplok) {
				sz.addhopont(-1);
			}
		}
		if(homennyiseg > 5)homennyiseg = 5;
		else if(homennyiseg < 0)homennyiseg = 0;
		Kiiro.Kiir("Az �j h�mennyis�g: " + this.homennyiseg);

	}
	
	/**A t�bl�ba fagyott t�rgyat valaki ki�ssa.
	 * @param k neki adja a befagyott t�rgyat.
	 */
	public void targykias(Karakter k){
		if(targy != null && homennyiseg == 0) {
			Kiiro.Kiir("A targy kiasasa megtortent. " + targy.getName());
			k.addTargy(targy);
			targy = null;
		}
		else if(homennyiseg != 0) Kiiro.Kiir("Nem l�tszik a h�t�l a t�bla.");
		else Kiiro.Kiir("Nincs is itt t�rgy.");
	}
	
	/**Visszaadja a t�bla b�r�k�pess�g�t. Ez a t�bla mindig mindenkit elb�r.
	 * @return a t�bla karakterb�r� k�pess�ge
	 */
	public int getbirokepesseg() {
		return -1;
	}
	
	/**Visszaadja a t�bla �tfordult �llapot�t.
	 * @return igaz, ha �tfordult
	 */
	public boolean getatfordult(){
		return atfordul;
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	public void rajzol() {
		/*Graphics g = Vezerlo.nezet.bi.getGraphics();
		g.drawImage(Kepek.getImage("tablahoval"), x, y, null);
		ImageIcon icon = new ImageIcon(Vezerlo.nezet.bi);
		Vezerlo.nezet.label.setIcon(icon);*/
		Kepek.rajzol("tablahoval", x, y);
		
		for(Szereplo sz: szereplok) {
			sz.rajzol();
		}
		if(menedek != null)menedek.rajzol();
		if(targy != null && homennyiseg == 0)targy.rajzol();
	}
}
