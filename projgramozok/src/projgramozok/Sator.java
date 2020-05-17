package projgramozok;

/**Sátor osztály, ebbõl lehet felállított sátor objektumot létrehozni.
 *
 */
public class Sator extends Targy{

	/**Sátor használata
	 *@param k Az õ tábláján fog megépülni a felállított sátor
	 *egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		k.getTabla().setMenedek(new Felallitott_sator(k.getTabla()));
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
		if (k.targyak.get(getName()).isEmpty()) {
			k.targyak.remove(getName());
		}
		Kiiro.Kiir(getName() + " felépítve");
	}
	
	/**
	 *Visszatér az osztály nevével.
	 */
	public  String getName() {
		return "Sator";
	}
	
	/**
	 * Rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("sator", xpos+75, ypos+75);
	}
}
