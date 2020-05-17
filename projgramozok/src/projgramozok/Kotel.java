package projgramozok;

import java.util.List;

/**Kötél osztály. Egy szomszédos tábláról kimenti az összes vízben levõ játékost, maga mellé húzza.
 *
 */
public class Kotel extends Targy{

	/**A kötél használata
	 *@param k Ennek a táblárája lépteti egy szomszédos tábla karaktereit.
	 *egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		
		for (Tabla t : k.tabla.szomszed) {
			if (t.getatfordult()) {
				List<Szereplo> rajta = t.getSzereplok();
				while(!rajta.isEmpty()) {						//Az összes vízben levõt kimenti
					rajta.get(0).lep(k.getTabla());
				}
			}
		}
		Kiiro.Kiir(getName() + " hasznalva");
		k.munkavegzes();
		
	}
	
	/**
	 *Visszatér az osztály nevével
	 */
	public  String getName() {
		return "Kotel";
	}
	/**
	 * Rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("kotel", xpos+75, ypos+75);
	}
	
}
