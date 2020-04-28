package projgramozok;

/**Ki�r� oszt�ly, ak�r egyszerre t�bb helyre is k�pes �rni.
 * 
 */
public class Kiiro {
	/**
	 *Statikus v�ltoz�, true eset�n a konzolra �rja a param�terk�nt kapott adatokat.
	 */
	private static boolean Konzolra = true;
	
	/**Ki�rja a be�ll�tot helyekre a sz�veget.
	 * @param s a ki�rand� string
	 */
	public static void Kiir(String s) {
		if(Konzolra) {
			System.out.println(s);
		}
	}
	/**Sz�m ki�r�sa
	 * @param i a ki�rand� sz�m
	 */
	public static void Kiir(int i) {
		Kiir(Integer.toString(i));
	}
}
