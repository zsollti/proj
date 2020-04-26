package projgramozok;


//Az �lelem megval�s�t�sa
public class Elelem extends Targy{

	/**Az �lelem haszn�lata
	 *@param k a h�potj�t eggyel n�veli.
	 */
	@Override
	public void hasznal(Karakter k) {
		k.addhopont(1);
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
		Kiiro.Kiir(getName());
	}
	public  String getName() {
		return "Elelem";
	}
}
