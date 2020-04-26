package projgramozok;

public class Torekeny_aso extends Lapat{
	private int hasznalat;
	
	public Torekeny_aso() {
		hasznalat = 3;
	}
	/**T�r�keny �s� haszn�lata
	 *@param k Az � t�bl�j�n fog cs�kkenni a h�
	 */
	@Override
	public void hasznal(Karakter k) {
		super.hasznal(k);
		k.munkavegzes();
		hasznalat--;
		if(hasznalat <= 0) {
			k.targyak.get(getName()).remove(this);
			Kiiro.Kiir(getName() + "elt�rt!");
			return;
		}
	}
	public  String getName() {
		return "Torekeny aso";
	}
}
