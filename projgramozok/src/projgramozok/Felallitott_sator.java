package projgramozok;

/**Fel�ll�tott s�tor oszt�ly, egy s�tor haszn�lata sor�n keletkezik, mened�k egy t�bl�n, ami egy k�rig marad ott.
 *A medv�t�l nem v�d, h�vihart�l egy k�rig igen.
 */
public class Felallitott_sator extends Menedek{

	/**
	 *Konstruktor
	 *@param t A t�bla ahova fel�ll�tjuk a s�tort
	 */
	public Felallitott_sator(Tabla t) {
		super(t);
	}
	
	/**S�tor lerombol�sa, mivel az maximum egy k�rig marad.
	 * 
	 */
	@Override
	public void destroy() {
		tabla.menedek = null;
	}
	
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("felallitott_sator", xpos, ypos-25);
	}

}
