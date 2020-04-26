package projgramozok;


public class Alkatresz extends Targy{

	private static int db = 0;
	
	/**Alkatr�sz haszn�lata. Megnyeri a j�t�kot, ha mindeki egy helyen van �s mind a 3 alkatr�st n�luk van.
	 *
	 */
	@Override
	public void hasznal(Karakter k) {
		//az m�g kellene, hogy ha az �sszes alkatr�sz egy helyen van
		if(Palya.vizsgal(k)) {
			db = 0;
			for (Szereplo sz : Palya.szereplok) {
				db += sz.getInventory().get(getName()).size(); //medv�nek null, de ha ott a medve �gyse haszn�lhatj�k
			}
			if (db == 3) Palya.gameover(null);
		}
	}
	public  String getName() {
		return "Alkatresz";
	}
}
