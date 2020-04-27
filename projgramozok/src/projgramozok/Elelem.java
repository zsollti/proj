package projgramozok;


//Az �lelem megval�s�t�sa
public class Elelem extends Targy{

	/**Az �lelem haszn�lata
	 *@param k a h�potj�t eggyel n�veli.
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
