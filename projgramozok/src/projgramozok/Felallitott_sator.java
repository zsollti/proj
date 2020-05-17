package projgramozok;

/**Felállított sátor osztály, egy sátor használata során keletkezik, menedék egy táblán, ami egy körig marad ott.
 *A medvétõl nem véd, hóvihartól egy körig igen.
 */
public class Felallitott_sator extends Menedek{

	/**
	 *Konstruktor
	 *@param t A tábla ahova felállítjuk a sátort
	 */
	public Felallitott_sator(Tabla t) {
		super(t);
	}
	
	/**Sátor lerombolása, mivel az maximum egy körig marad.
	 * 
	 */
	@Override
	public void destroy() {
		tabla.menedek = null;
	}
	
	/**
	 * Rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("felallitott_sator", xpos, ypos-25);
	}

}
