package projgramozok;


//Az élelem megvalósítása
public class Elelem extends Targy{

	/**Az élelem használata
	 *@param k a hõpotját eggyel növeli.
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
