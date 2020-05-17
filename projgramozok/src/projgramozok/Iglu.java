package projgramozok;

/**Iglu menedék, az eszkimó tudja létrehozni. Véd a hóvihartól és a medvétõl.
 *Egy tábla menedéke, ami nem semmisül meg.
 */
public class Iglu extends Menedek{
	
	/**
	 *Konstruktor
	 *@param t A tábla ahova felálítjuk az iglut
	 */
	public Iglu (Tabla t) {
		super(t);
	}
	
	/**Nem lehet megsemmisíteni, így ez üres.
	 * 
	 */
	@Override
	public void destroy() {
		
	}
	
	/**
	 * Rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("iglu", xpos, ypos-25);
	}
}
