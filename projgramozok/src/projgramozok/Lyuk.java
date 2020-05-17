package projgramozok;


/**Lyuk osztály, olyan tábla, ami nem bír el egy karaktert sem.
 *
 */
public class Lyuk extends Tabla{
	
	/**
	 *Konstruktor
	 */
	public Lyuk() {
	}
	
	/**
	 *Paraméteres konstruktor
	 *@param ho A táblán lévõ kezdõ hómennyiség
	 *@param atfordult A tábla át van-e fordulba kezdetben
	 */
	public Lyuk(int ho, boolean atfordult) {
		super(ho, true);
	}
	/**Lyukra lépés
	 * @param k lyukra lépett, beleesik a vízbe.
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
	
	/**Megadja a tábla karakterbíró képességét (Lyuk esetén ez mindig 0).
	 * 
	 */
	@Override
	public int getbirokepesseg(){
		return 0;
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		if(homennyiseg == 0)Kepek.rajzol("lyuk", x, y);
		else {Kepek.rajzol("tablahoval", x, y);}
	
	}
	
	public boolean getatfordult() {
		return true;
	}
}
