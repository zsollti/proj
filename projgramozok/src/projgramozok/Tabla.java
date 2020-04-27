package projgramozok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**A táblákat megvalósító osztály.
 *
 */
public class Tabla {
	protected Menedek menedek;
	protected int homennyiseg;
	protected boolean atfordul;
	protected List<Szereplo> szereplok;
	protected Targy targy;
	protected List<Tabla> szomszed;
	
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
}
