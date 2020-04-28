package projgramozok;


/**Absztarkt oszt�ly a t�rgyak megval�s�t�s�hoz.
 *
 */
public abstract class Targy {
	/**
	 *Absztrakt f�ggv�ny a t�rgy haszn�lat�hoz
	 */
	public abstract void hasznal(Karakter k);
	
	/**
	 *Absztrakt f�ggv�ny a t�rgy nev�nek lek�r�s�hez
	 */
	public abstract String getName();
}
