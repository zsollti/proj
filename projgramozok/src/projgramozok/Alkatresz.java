package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *Alkatrész osztály, a játék megnyeréséhez kell, összesen három darab objektum van belõle
 */
public class Alkatresz extends Targy{

	/**
	 *Statikus változó, ahol a karakterek által megtalált alkatrészeket számoljuk.
	 */
	private static int db = 0;
	
	/**Alkatrész használata. Megnyeri a játékot, ha mindenki egy helyen van és mind a 3 alkatrész náluk van.
	 *Egyébként kiírja, hogy mi hiányzik.
	 *egy munkavégzésbe kerül
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
	 *Visszatér az alkatrész nevével.
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
