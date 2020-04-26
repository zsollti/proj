package projgramozok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//A táblákat megvalósító osztály.
public class Tabla {
	protected Menedek menedek;
	protected int homennyiseg;
	protected boolean atfordul;
	protected List<Szereplo> szereplok;
	protected Targy targy;
	protected List<Tabla> szomszed;
	
	//Konstruktor
	public Tabla() {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		menedek = null;
		targy = null;
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
	}
	
	public Tabla(int ho, boolean atfordult) {
		szereplok = new ArrayList<Szereplo>();
		homennyiseg = ho;
		menedek = null;
		targy = null;
		atfordul = atfordult;
		szomszed = new ArrayList<Tabla>();
	}
	
	//A tábla karaktereivel tér vissza.
	public List<Szereplo> getSzereplok(){
		return szereplok;
	}
	
	//A két tábla szomszédja-e egymásnak
	public boolean szomszede(Tabla sz){
		for(Tabla szo: szomszed) {
			if(szo.equals(sz)) return true;
		}
		return false;
	}
	
	//Iglut helyez a táblára
	public void setMenedek(Menedek m) {
		if(menedek != null) {
			menedek.destroy();
		}
		if(menedek == null) {
			menedek = m;
		}
		if (menedek != null && m != null) Kiiro.Kiir("A menedék felépült");

	}
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ezen a táblán az összes karakter elfér.
	public void ralep(Szereplo k){
		this.szereplok.add(k);
		if(szereplok.size() > 0)
		for (Szereplo sz : szereplok) {
			sz.utkozik(k);
		}
		k.setTabla(this);
	}
	
	//Eltávolítja a paraméterként kapott karaktert a sajátjai közül.
	public void lelep(Szereplo k) {
		this.szereplok.remove(k);
	}
	
	//A táblán levõ hó mennyiségét változtatja.
	//Max 5 min 0 lehet rajta.
	public void addhomennyiseg(int i){
		Kiiro.Kiir("A régi hómennyiség: " + this.homennyiseg);
		homennyiseg += i;
		if(i > 0 && menedek != null) {
			for(Szereplo sz: szereplok) {
				sz.addhopont(-1);
			}
		}
		if(homennyiseg > 5)homennyiseg = 5;
		else if(homennyiseg < 0)homennyiseg = 0;
		Kiiro.Kiir("Az új hómennyiség: " + this.homennyiseg);

	}
	
	//A paraméterként kapott karakternek adja a befagyott tárgyját.
	public void targykias(Karakter k){
		if(targy != null && homennyiseg == 0) {
			k.addTargy(targy);
			targy = null;
			Kiiro.Kiir("A targy kiasasa megtortent.");
		}
		else Kiiro.Kiir("Nincs is itt látható tárgy.");
	}
	
	//Megadja a tábla karakterbíró képességét (Tábla esetén mindig minden karaktert elbír).
	public int getbirokepesseg() {
		return -1;
	}
	
	//Megadja, a tábla átfordult állapotát.
	public boolean getatfordult(){
		return atfordul;
	}
}
