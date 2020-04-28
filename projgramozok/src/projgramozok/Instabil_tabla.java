package projgramozok;

import java.util.Random;



/**
 *Instabil t�bl�k megval�s�t�sa.
 */
public class Instabil_tabla extends Tabla{
	
	/**
	 *A t�bla karakterb�r� k�pess�g�t t�rolja.
	 */
	private int birokepesseg;
	
	/**
	 * Param�ter n�lk�li konstruktor.
	 * Random b�r�k�pess�get �ll�t be mag�nak.(6 �s 1 k�z�tt)
	 */
	public Instabil_tabla() {
		super();
		birokepesseg = new Random().nextInt(5) +1;
	}
	
	/**
	 * Param�teres konstruktor.
	 * @param ho: A t�bl�n elhelyezked� h� ennyis�ge.
	 * @param fordult: A t�bla �tfordult �llapota.
	 * @param bir: A t�bla b�r�k�pess�ge.
	 */
	public Instabil_tabla(int ho, boolean fordult, int bir) {
		super(ho, fordult);
		birokepesseg = bir;
	}
	
	/**
	 * A param�terk�nt kapott szerepl�t a saj�tjaihoz adja.
	 * @param k: A szerepl� aki r�l�p a t�bl�ra.
	 */
	@Override
	public void ralep(Szereplo k)
	{
		szereplok.add(k);
		k.setTabla(this);
		if(atfordul) k.beleesik();
		else if(szereplok.size() > birokepesseg) {
			atfordul = true;
			Kiiro.Kiir("Atfordult!");
			for(Szereplo sz : szereplok) {
				sz.beleesik();
			}
		}
		szereplok.get(0).utkozik(k);
	}
	
	/**
	 * Elt�vol�tja a param�terk�nt kapott szerepl�t a saj�tjai k�z�l.
	 * @param k: A szerepl� aki lel�p a t�bl�r�l.
	 */
	public void lelep(Szereplo k) {
		this.szereplok.remove(k);
		if(szereplok.size() == 0) {
			atfordul = false;
		}
	}
	
	/**
	 * Megadja a t�bla karakterb�r� k�pess�g�t.
	 */
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
