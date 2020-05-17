package projgramozok;


/**Törékeny ásó osztály, a lapát leszármazottja. Õséhez hasonló, csak 3 használat után eltörik.
 *
 */
public class Torekeny_aso extends Lapat{
	/**
	 *Itt tartjuk számon, hogy hányszor lehet még használni az ásót.
	 */
	int hasznalat;
	
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
		return "Torekeny_aso";
	}
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("torekeny_lapat", xpos+75, ypos+75);
	}
}
