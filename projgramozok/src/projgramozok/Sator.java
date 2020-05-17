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
		Kiiro.Kiir(getName() + " fel�p�tve");
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel.
	 */
	public  String getName() {
		return "Sator";
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("sator", xpos+75, ypos+75);
	}
}
