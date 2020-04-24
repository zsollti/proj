package projgramozok;

import java.util.Random;

public class Medve extends Szereplo{

	private Random random = new Random(); //csak hogy ne kelljen miding �jra l�trehozni
	
	public Medve(Tabla t) {
		super(t);
	}

	@Override
	public void addhopont(int i) {
		//�res	
	}

	@Override
	public void beleesik() {
		//�res
	}
	
	/**ha elkap valakit, az meghal
	 *@param sz a karakter, akit elkapott
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//� az egyetlen medve
		if (sz != null && sz != this) {
			Palya.gameover(sz);
		}
	}
	
	@Override
	public void lep(Tabla t) {
		tabla.lelep(this);
		t.ralep(this);
		//umlben az van, hogy a tabla h�vja a destroyt meg mindent, de azt csak a maci csin�lja, ez�rt szerintem ide k�ne.
	}
	
	/**Kiv�laszt egy random t�bl�t, majd arra l�p.
	 *
	 */
	@Override
	public void korkezd() {
		int i = random.nextInt(tabla.szomszed.size()-1);
		lep(tabla.szomszed.get(i));
		tabla.setMenedek(null); //elpuszt�tja, ha tudja
		endTurn();
	}
}
