package projgramozok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**A t�bl�kat megval�s�t� oszt�ly.
 *
 */
public class Tabla {
	protected Menedek menedek;
	protected int homennyiseg;
	protected boolean atfordul;
	protected List<Szereplo> szereplok;
	protected Targy targy;
	protected List<Tabla> szomszed;
	
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
}
