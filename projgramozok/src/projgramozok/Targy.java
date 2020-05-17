package projgramozok;


/**Absztarkt osztály a tárgyak megvalósításához.
 *
 */
public abstract class Targy implements Rajzolhato{
	/**
	 *Absztrakt függvény a tárgy használatához
	 */
	public abstract void hasznal(Karakter k);
	
	/**
	 *Absztrakt függvény a tárgy nevének lekéréséhez
	 */
	public abstract String getName();
	
	/**
	 * Absztrakt rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	public abstract void rajzol(int xpos, int ypos);

}
