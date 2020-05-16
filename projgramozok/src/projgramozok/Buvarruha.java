package projgramozok;


/**B�v�rruha oszt�ly. V�zbe es�s eset�n kimenti egy szomsz�dos mez�re a visel�j�t.
 *
 */
public class Buvarruha extends Targy{

	/**A b�v�rruha haszn�lata
	 *@param k  ezt a j�t�kost egy m�sik t�bl�ra l�pteti, � a visel�je
	 */
	@Override
	public void hasznal(Karakter k) {
		if(k.getTabla().getatfordult() == true){ 
			k.lep(k.getTabla().szomszed.get(0));
			Kiiro.Kiir(getName() + " hasznalva:");
		}
		else Kiiro.Kiir("Nem vagy vizben, nem tudod hasznalni");
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel.
	 */
	public  String getName() {
		return "Buvarruha";
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol() {
		
	}
}
