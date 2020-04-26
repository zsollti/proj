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
		super.hasznal(k);
		k.munkavegzes();
		hasznalat--;
		if(hasznalat <= 0) {
			k.targyak.get(getName()).remove(this);
			Kiiro.Kiir(getName() + "eltört!");
			return;
		}
	}
	public  String getName() {
		return "Torekeny aso";
	}
}
