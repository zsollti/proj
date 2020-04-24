package projgramozok;

import java.util.Random;

public class Medve extends Szereplo{

	private Random random = new Random(); //csak hogy ne kelljen miding újra létrehozni
	
	public Medve(Tabla t) {
		super(t);
	}

	@Override
	public void addhopont(int i) {
		//üres	
	}

	@Override
	public void beleesik() {
		//üres
	}
	
	/**ha elkap valakit, az meghal
	 *@param k a karakter, akit elkapott
	 */
	@Override
	public void utkozik(Karakter k) {
		if (k != null) {
			Palya.gameover(k);
		}
	}
	
	@Override
	public void lep(Tabla t) {
		tabla.lelep(this);
		t.ralep(this);
		//umlben az van, hogy a tabla hívja a destroyt meg mindent, de azt csak a maci csinálja, ezért szerintem ide kéne.
	}
	
	/**Kiválaszt egy random táblát, majd arra lép.
	 *
	 */
	@Override
	public void korkezd() {
		int i = random.nextInt(tabla.szomszed.size()-1);
		lep(tabla.szomszed.get(i));
		endTurn();
	}
}
