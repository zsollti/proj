package projgramozok;


//Az élelem megvalósítása
public class Elelem extends Targy{

	/**Az élelem használata
	 *@param k a hõpotját eggyel növeli.
	 */
	@Override
	public void hasznal(Karakter k) {
		//System.out.println("-->hasznal(k)");
		k.addhopont(1);
		k.munkavegzes();
		//System.out.println("void<--");
	}
}
