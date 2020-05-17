package projgramozok;

import java.util.List;

/**K�t�l oszt�ly. Egy szomsz�dos t�bl�r�l kimenti az �sszes v�zben lev� j�t�kost, maga mell� h�zza.
 *
 */
public class Kotel extends Targy{

	/**A k�t�l haszn�lata
	 *@param k Ennek a t�bl�r�ja l�pteti egy szomsz�dos t�bla karaktereit.
	 *egy munkav�gz�sbe ker�l
	 */
	@Override
	public void hasznal(Karakter k) {
		
		for (Tabla t : k.tabla.szomszed) {
			if (t.getatfordult()) {
				List<Szereplo> rajta = t.getSzereplok();
				while(!rajta.isEmpty()) {						//Az �sszes v�zben lev�t kimenti
					rajta.get(0).lep(k.getTabla());
				}
			}
		}
		Kiiro.Kiir(getName() + " hasznalva");
		k.munkavegzes();
		
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel
	 */
	public  String getName() {
		return "Kotel";
	}
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("kotel", xpos+75, ypos+75);
	}
	
}
