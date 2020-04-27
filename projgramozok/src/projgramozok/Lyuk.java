package projgramozok;


/**Lyuk osztály, olyan tábla, ami nem bír el egy karaktert sem.
 *
 */
public class Lyuk extends Tabla{
	
	public Lyuk() {
	}
	
	public Lyuk(int ho, boolean atfordult) {
		super(ho, true);
	}
	/**Lyukra lépés
	 * @param k lyukra lépett, beleesik a vízbe.
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
	
	/**Megadja a tábla karakterbíró képességét (Lyuk esetén ez mindig 0).
	 * 
	 */
	@Override
	public int getbirokepesseg(){
		return 0;
	}
}
