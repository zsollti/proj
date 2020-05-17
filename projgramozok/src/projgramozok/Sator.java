package projgramozok;

/**S�tor oszt�ly, ebb�l lehet fel�ll�tott s�tor objektumot l�trehozni.
 *
 */
public class Sator extends Targy{

	/**S�tor haszn�lata
	 *@param k Az � t�bl�j�n fog meg�p�lni a fel�ll�tott s�tor
	 *egy munkav�gz�sbe ker�l
	 */
	@Override
	public void hasznal(Karakter k) {
		k.getTabla().setMenedek(new Felallitott_sator(k.getTabla()));
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
		if (k.targyak.get(getName()).isEmpty()) {
			k.targyak.remove(getName());
		}
		Kiiro.Kiir(getName() + " fel�p�tve");
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel.
	 */
	public  String getName() {
		return "Sator";
	}
	
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("sator", xpos+75, ypos+75);
	}
}
