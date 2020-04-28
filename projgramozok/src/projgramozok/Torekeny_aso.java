package projgramozok;


/**Törékeny ásó osztály, a lapát leszármazottja. Õséhez hasonló, csak 3 használat után eltörik.
 *
 */
public class Torekeny_aso extends Lapat{
	/**
	 *Itt tartjuk számon, hogy hányszor lehet még használni az ásót.
	 */
	private int hasznalat;
	
	/**
	 *Konstruktor
	 */
	public Torekeny_aso() {
		hasznalat = 3;
	}
	/**Törékeny ásó használata
	 *@param k Az õ tábláján fog csökkenni a hó
	 *egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		super.hasznal(k);
		hasznalat--;
		if(hasznalat <= 0) {
			k.targyak.get(getName()).remove(this);
			Kiiro.Kiir(getName() + " eltört!");
			return;
		}
	}
	
	/**
	 *Visszatér az osztály nevével.
	 */
	public  String getName() {
		return "Torekeny aso";
	}
}
