package projgramozok;


/**Lap�t oszt�ly, haszn�lat�val 2 egys�g h� lap�tolhat� el a t�bl�r�l.
 *
 */
public class Lapat extends Targy{

	/**Lap�t haszn�lata
	 * @param k 2 egys�g havat lap�tol el a k karakter t�bl�j�r�l
	 * egy munkav�gz�sbe ker�l
	 */
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName() + " hasznalva");
		k.getTabla().addhomennyiseg(-2);
		k.munkavegzes();
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel
	 */
	public  String getName() {
		return "Lapat";
	}
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("lapat", xpos+75, ypos+75);
	}
}
