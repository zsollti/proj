package projgramozok;


/**Lyuk oszt�ly, olyan t�bla, ami nem b�r el egy karaktert sem.
 *
 */
public class Lyuk extends Tabla{
	
	public Lyuk() {
	}
	
	public Lyuk(int ho, boolean atfordult) {
		super(ho, true);
	}
	/**Lyukra l�p�s
	 * @param k lyukra l�pett, beleesik a v�zbe.
	 */
	@Override
	public void ralep(Szereplo k){
		szereplok.add(k);
		k.setTabla(this);
		Kiiro.Kiir("Lyukra leptel!");
		k.beleesik();
		if(szereplok.size() > 0)
		  szereplok.get(0).utkozik(k);
	}
	
	/**Megadja a t�bla karakterb�r� k�pess�g�t (Lyuk eset�n ez mindig 0).
	 * 
	 */
	@Override
	public int getbirokepesseg(){
		return 0;
	}
}
