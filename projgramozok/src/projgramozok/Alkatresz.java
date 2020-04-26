package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;

public class Alkatresz extends Targy{

	private static int db = 0;
	
	/**Alkatr�sz haszn�lata. Megnyeri a j�t�kot, ha mindeki egy helyen van �s mind a 3 alkatr�st n�luk van.
	 *
	 */
	@Override
	public void hasznal(Karakter k) {
		//az m�g kellene, hogy ha az �sszes alkatr�sz egy helyen van
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
			if (db == 3) Palya.gameover(null);
		}
	}
	public  String getName() {
		return "Alkatresz";
	}
}
