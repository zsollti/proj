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


/**A táblákat megvalósító osztály.
 *
 */

public class Tabla implements Rajzolhato{
	
	/**
	 *A táblára épített menedék
	 */
	protected Menedek menedek;
	
	/**
	 *A táblára rakódott hó mennyisége
	 */
	protected int homennyiseg;
	
	/**
	 *A tábla átfordult állapota
	 */
	protected boolean atfordul;
	
	/**
	 *A táblá elhelyezkedõ szereplõk
	 */
	protected List<Szereplo> szereplok;
	
	/**
	 *A táblába fagyott tárgy
	 */
	protected Targy targy;
	
	/**
	 *Az adott tábla szomszédai
	 */
	protected List<Tabla> szomszed;
	
	protected int x, y;
	
	/**Konstruktor. Létrehoz egy alapértékekkel rendelkezõ táblát.
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
	
	/**Konstruktor. Paraméterek alapján hoz létre táblát.
	 * @param ho A táblán lévõ kezdõ hómennyiség
	 * @param atfordult A tábla át van-e fordulba kezdetben
	 */
	public Tabla(int ho, boolean atfordult) {
		szereplok = new ArrayList<Szereplo>();
		homennyiseg = ho;
		menedek = null;
		targy = null;
		atfordul = atfordult;
		szomszed = new ArrayList<Tabla>();
	}
	
	/**Visszadja a tábla szereplõit.
	 * @return a táblán álló szereplõk
	 */
	public List<Szereplo> getSzereplok(){
		return szereplok;
	}
	
	/**Szomszédságot vizsgál két tábla között.
	 * @param sz a vizsgálandó tábla
	 * @return igaz, ha szomszéd
	 */
	public boolean szomszede(Tabla sz){
		for(Tabla szo: szomszed) {
			if(szo.equals(sz)) return true;
		}
		return false;
	}
	
	/**Menedéket helyez a táblára.
	 * @param m a felállítandó menedék
	 */
	public void setMenedek(Menedek m) {
		if(menedek != null) {
			menedek.destroy();
		}
		if(menedek == null) {
			menedek = m;
		}
		if (menedek != null && m != null) Kiiro.Kiir("A menedék felépült");

	}
	
	/**Valaki rálép a táblára. Ezen a táblán az összes karakter elfér.
	 * @param k eltárolja a sajátjai közt.
	 */
	public void ralep(Szereplo k){
		this.szereplok.add(k);
		szereplok.get(0).utkozik(k);
		k.setTabla(this);
	}
	
	/**Valaki lelép a tábláról
	 * @param k Eltávolítja a sajátjai közül.
	 */
	public void lelep(Szereplo k) {
		this.szereplok.remove(k);
	}
	
	/**A táblán levõ hó mennyiségét változtatja. Maximum 5 minimum 0 lehet rajta.
	 * @param i ennyivel változik a hómennyiség. Elõjeles.
	 */
	public void addhomennyiseg(int i){
		Kiiro.Kiir("A régi hómennyiség: " + this.homennyiseg);
		homennyiseg += i;
		if(i > 0 && menedek == null) {
			for(Szereplo sz: szereplok) {
				sz.addhopont(-1);
			}
		}
		if(homennyiseg > 5)homennyiseg = 5;
		else if(homennyiseg < 0)homennyiseg = 0;
		Kiiro.Kiir("Az új hómennyiség: " + this.homennyiseg);

	}
	
	/**A táblába fagyott tárgyat valaki kiássa.
	 * @param k neki adja a befagyott tárgyat.
	 */
	public void targykias(Karakter k){
		if(targy != null && homennyiseg == 0) {
			Kiiro.Kiir("A targy kiasasa megtortent. " + targy.getName());
			k.addTargy(targy);
			targy = null;
		}
		else if(homennyiseg != 0) Kiiro.Kiir("Nem látszik a hótól a tábla.");
		else Kiiro.Kiir("Nincs is itt tárgy.");
	}
	
	/**Visszaadja a tábla bíróképességét. Ez a tábla mindig mindenkit elbír.
	 * @return a tábla karakterbíró képessége
	 */
	public int getbirokepesseg() {
		return -1;
	}
	
	/**Visszaadja a tábla átfordult állapotát.
	 * @return igaz, ha átfordult
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
