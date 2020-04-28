package projgramozok;


/**Absztarkt osztály a tárgyak megvalósításához.
 *
 */
public abstract class Targy {
	/**
	 *Absztrakt függvény a tárgy használatához
	 */
	public abstract void hasznal(Karakter k);
	
	/**
	 *Absztrakt függvény a tárgy nevének lekéréséhez
	 */
	public abstract String getName();
}
