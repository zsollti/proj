package projgramozok;

public class Torekeny_aso extends Lapat{
	private int hasznalat;
	
	public Torekeny_aso() {
		hasznalat = 3;
	}
	/**Törékeny ásó használata
	 *@param k Az õ tábláján fog csökkenni a hó
	 */
	@Override
	public void hasznal(Karakter k) {
		if(hasznalat <= 0) {
			return; //destroy kéne?
		}
		super.hasznal(k);
		k.munkavegzes();
		hasznalat--;
	}
}
