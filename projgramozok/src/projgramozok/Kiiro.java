package projgramozok;

/**Kiíró osztály, akár egyszerre több helyre is képes írni.
 * 
 */
public class Kiiro {
	/**
	 *Statikus változó, true esetén a konzolra írja a paraméterként kapott adatokat.
	 */
	private static boolean Konzolra = true;
	
	/**Kiírja a beállítot helyekre a szöveget.
	 * @param s a kiírandó string
	 */
	public static void Kiir(String s) {
		if(Konzolra) {
			System.out.println(s);
		}
	}
	/**Szám kiírása
	 * @param i a kiírandó szám
	 */
	public static void Kiir(int i) {
		Kiir(Integer.toString(i));
	}
}
