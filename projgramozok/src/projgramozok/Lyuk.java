package projgramozok;


/**Lyuk oszt�ly, olyan t�bla, ami nem b�r el egy karaktert sem.
 *
 */
public class Lyuk extends Tabla{
	
	/**
	 *Konstruktor
	 */
	public Lyuk() {
	}
	
	/**
	 *Param�teres konstruktor
	 *@param ho A t�bl�n l�v� kezd� h�mennyis�g
	 *@param atfordult A t�bla �t van-e fordulba kezdetben
	 */
	public Lyuk(int ho, boolean atfordult) {
		super(ho, true);
	}
	/**Lyukra l�p�s
	 * @param k lyukra l�pett, beleesik a v�zbe.
	 */
	@Override
	public void ralep(Szereplo k){
		homennyiseg = 0;
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
	
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		if(homennyiseg == 0)Kepek.rajzol("lyuk", x, y);
		else {Kepek.rajzol("tablahoval", x, y);}	
	}
	/**
	 * Visszaadja, hogy �tfordult-e a t�bla
	 * Mivel lyuk, ez�rt mindig igaz
	 */
	public boolean getatfordult() {
		return true;
	}
}
