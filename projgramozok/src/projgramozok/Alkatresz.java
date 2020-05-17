package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *Alkatr�sz oszt�ly, a j�t�k megnyer�s�hez kell, �sszesen h�rom darab objektum van bel�le
 */
public class Alkatresz extends Targy{

	/**
	 *Statikus v�ltoz�, ahol a karakterek �ltal megtal�lt alkatr�szeket sz�moljuk.
	 */
	private static int db = 0;
	
	/**Alkatr�sz haszn�lata. Megnyeri a j�t�kot, ha mindenki egy helyen van �s mind a 3 alkatr�sz n�luk van.
	 *Egy�bk�nt ki�rja, hogy mi hi�nyzik.
	 *egy munkav�gz�sbe ker�l
	 */
	@Override
	public void hasznal(Karakter k) {
		if(Palya.vizsgal(k)) {
			db = 0;
			for (Szereplo sz : Palya.szereplok) {
				HashMap<String, ArrayList<Targy>> t = sz.getInventory();
				if ( t != null) {
					ArrayList<Targy> l = sz.getInventory().get(getName());
					if (l != null) {
						db += sz.getInventory().get(getName()).size();
					}
				}
			}
			if (db == 3) {
				k.munkavegzes();
				Palya.gameover(null);
			}
			else Kiiro.Kiir("Nincs meg az osszes alkatresz");
		} else Kiiro.Kiir("Nincs mindenki egyutt");
	}

	/**
	 *Visszat�r az alkatr�sz nev�vel.
	 */
	public  String getName() {
		return "Alkatresz";
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("alkatresz", xpos, ypos);
	}
	
}
