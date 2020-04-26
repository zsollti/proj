package projgramozok;


public class Alkatresz extends Targy{

	private static int db = 0;
	
	/**Alkatrész használata. Megnyeri a játékot, ha mindeki egy helyen van és mind a 3 alkatrést náluk van.
	 *
	 */
	@Override
	public void hasznal(Karakter k) {
		//az még kellene, hogy ha az összes alkatrész egy helyen van
		if(Palya.vizsgal(k)) {
			db = 0;
			for (Szereplo sz : Palya.szereplok) {
				db += sz.getInventory().get(getName()).size(); //medvének null, de ha ott a medve úgyse használhatják
			}
			if (db == 3) Palya.gameover(null);
		}
	}
	public  String getName() {
		return "Alkatresz";
	}
}
