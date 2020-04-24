package projgramozok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//A t�b�kat megval�s�t� oszt�ly. Yay
public class Tabla {
	
	static Palya palya;				//Ahhoz, hogy tudja a p�lya f�ggv�nyeit h�vogatni
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
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
	}
	
	//A t�bla karaktereivel t�r vissza.
	public List<Szereplo> getSzereplok(){
		return szereplok;
	}
	
	//A k�t t�bla szomsz�dja-e egym�snak
	public boolean szomszede(Tabla sz){
		for(Tabla szo: szomszed) {
			if(szo.equals(sz)) return true;
		}
		return false;
	}
	
	//Iglut helyez a t�bl�ra
	public void setMenedek(Menedek m) {
		if(menedek != null) {
			menedek.destroy();
		}
		if(menedek == null) {
			menedek = m;
		}
	}
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ezen a t�bl�n az �sszes karakter elf�r.
	public void ralep(Szereplo k){
		this.szereplok.add(k);
		szereplok.get(0).utkozik(k);
		k.setTabla(this);
	}
	
	//Elt�vol�tja a param�terk�nt kapott karaktert a saj�tjai k�z�l.
	public void lelep(Szereplo k) {
		this.szereplok.remove(k);
	}
	
	//A t�bl�n lev� h� mennyis�g�t v�ltoztatja.
	//Max 5 min 0 lehet rajta.
	public void addhomennyiseg(int i){
		homennyiseg += i;
		if(i > 0 && menedek != null) {
			for(Szereplo sz: szereplok) {
				sz.addhopont(-1);
			}
		}
		if(homennyiseg > 5)homennyiseg = 5;
		else if(homennyiseg < 0)homennyiseg = 0;
	}
	
	//A param�terk�nt kapott karakternek adja a befagyott t�rgyj�t.
	public void targykias(Karakter k){
		if(targy != null) {
			k.addTargy(targy);
			targy = null;
		}
	}
	
	//Megadja a t�bla karakterb�r� k�pess�g�t (T�bla eset�n mindig minden karaktert elb�r).
	public int getbirokepesseg() {
		return -1;
	}
	
	//Megadja, a t�bla �tfordult �llapot�t.
	public boolean getatfordult(){
		return atfordul;
	}
}
