package projgramozok;

import java.util.List;

//A k�t�l megval�s�t�sa
public class Kotel extends Targy{

	/**A k�t�l haszn�lat
	 *@param k Ennek a t�bl�r�ja l�pteti egy szomsz�dos t�bla karaktereit.
	 */
	@Override
	public void hasznal(Karakter k) {
		int warningunused; //magamnek eml�keztet�, ne vedd ki, am�g nincs kijav�tva
		//!!!!!!!!!!!
		//szomszed.get(0)-t jav�tani!
		List<Szereplo> rajta = k.getTabla().szomszed.get(0).getSzereplok();
		while(!rajta.isEmpty()) {
			rajta.get(0).lep(k.getTabla());
		}
		k.munkavegzes();
		System.out.println("Kotel");
	}
}
