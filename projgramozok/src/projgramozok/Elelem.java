package projgramozok;


/**Élelem osztály, melynek használata a hõpontokat növeli eggyel.
 *
 */
public class Elelem extends Targy{

	/**Az élelem használata
	 *@param k a hõpontját eggyel növeli.
	 *Egy munkavégzésbe kerül,
	 *majd törlõdik a @param k tárgyjai közül.
	 */
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName() + " hasznalva");
		k.addhopont(1);
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
	}
	/**
	 *Visszatér az osztály nevével.
	 */
	public  String getName() {
		return "Elelem";
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("elelem", xpos+75, ypos+75);
	}
}
