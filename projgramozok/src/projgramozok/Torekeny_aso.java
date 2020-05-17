package projgramozok;


/**T�r�keny �s� oszt�ly, a lap�t lesz�rmazottja. �s�hez hasonl�, csak 3 haszn�lat ut�n elt�rik.
 *
 */
public class Torekeny_aso extends Lapat{
	/**
	 *Itt tartjuk sz�mon, hogy h�nyszor lehet m�g haszn�lni az �s�t.
	 */
	int hasznalat;
	
	/**
	 *Konstruktor
	 */
	public Torekeny_aso() {
		hasznalat = 3;
	}
	/**T�r�keny �s� haszn�lata
	 *@param k Az � t�bl�j�n fog cs�kkenni a h�
	 *egy munkav�gz�sbe ker�l
	 */
	@Override
	public void hasznal(Karakter k) {
		super.hasznal(k);
		hasznalat--;
		if(hasznalat <= 0) {
			k.targyak.get(getName()).remove(this);
			Kiiro.Kiir(getName() + " elt�rt!");
			return;
		}
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel.
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
