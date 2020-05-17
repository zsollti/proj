package projgramozok;


/**Absztarkt oszt�ly a t�rgyak megval�s�t�s�hoz.
 *
 */
public abstract class Targy implements Rajzolhato{
	/**
	 *Absztrakt f�ggv�ny a t�rgy haszn�lat�hoz
	 */
	public abstract void hasznal(Karakter k);
	
	/**
	 *Absztrakt f�ggv�ny a t�rgy nev�nek lek�r�s�hez
	 */
	public abstract String getName();
	
	/**
	 * Absztrakt rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	public abstract void rajzol(int xpos, int ypos);

}
