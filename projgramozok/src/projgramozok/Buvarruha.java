package projgramozok;


//A b�v�rruha megval�s�t�sa
public class Buvarruha extends Targy{

	/**A b�v�rruha haszn�lata
	 *@param k  ezt egy m�sik t�bl�ra l�pteti 
	 */
	@Override
	public void hasznal(Karakter k) {
		k.lep(k.getTabla().szomszed.get(0));
		Kiiro.Kiir(getName());
	}
	public  String getName() {
		return "Buvarruha";
	}
}
