package projgramozok;


public class Alkatresz extends Targy{

	/**ez a t�rgy haszn�lhatatlan
	 *
	 */
	@Override
	public void hasznal(Karakter k) {
		//az m�g kellene, hogy ha az �sszes alkatr�sz egy helyen van
		if(Palya.vizsgal(k)) Palya.gameover(null);
	}
	public  String getName() {
		return "Alkatresz";
	}
}
