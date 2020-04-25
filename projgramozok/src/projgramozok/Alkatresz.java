package projgramozok;


public class Alkatresz extends Targy{

	/**ez a tárgy használhatatlan
	 *
	 */
	@Override
	public void hasznal(Karakter k) {
		//az még kellene, hogy ha az összes alkatrész egy helyen van
		if(Palya.vizsgal(k)) Palya.gameover(null);
	}
	public  String getName() {
		return "Alkatresz";
	}
}
