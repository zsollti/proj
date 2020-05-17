package projgramozok;


/**Lapát osztály, használatával 2 egység hó lapátolható el a tábláról.
 *
 */
public class Lapat extends Targy{

	/**Lapát használata
	 * @param k 2 egység havat lapátol el a k karakter táblájáról
	 * egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName() + " hasznalva");
		k.getTabla().addhomennyiseg(-2);
		k.munkavegzes();
	}
	
	/**
	 *Visszatér az osztály nevével
	 */
	public  String getName() {
		return "Lapat";
	}
	/**
	 * Rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("lapat", xpos+75, ypos+75);
	}
}
