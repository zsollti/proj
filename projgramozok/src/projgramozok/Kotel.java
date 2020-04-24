package projgramozok;

import java.util.List;

//A kötél megvalósítása
public class Kotel extends Targy{

	/**A kötél használat
	 *@param k Ennek a táblárája lépteti egy szomszédos tábla karaktereit.
	 */
	@Override
	public void hasznal(Karakter k) {
		int warningunused; //magamnek emlékeztetõ, ne vedd ki, amíg nincs kijavítva
		//!!!!!!!!!!!
		//szomszed.get(0)-t javítani!
		List<Szereplo> rajta = k.getTabla().szomszed.get(0).getSzereplok();
		while(!rajta.isEmpty()) {
			rajta.get(0).lep(k.getTabla());
		}
		k.munkavegzes();
		System.out.println("Kotel");
	}
}
