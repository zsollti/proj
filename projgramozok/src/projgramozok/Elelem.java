package projgramozok;


/**�lelem oszt�ly, melynek haszn�lata a h�pontokat n�veli eggyel.
 *
 */
public class Elelem extends Targy{

	/**Az �lelem haszn�lata
	 *@param k a h�pontj�t eggyel n�veli.
	 *Egy munkav�gz�sbe ker�l,
	 *majd t�rl�dik a @param k t�rgyjai k�z�l.
	 */
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName() + " hasznalva");
		k.addhopont(1);
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
	}
	public  String getName() {
		return "Elelem";
	}
}
