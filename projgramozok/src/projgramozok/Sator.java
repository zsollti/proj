package projgramozok;

public class Sator extends Targy{

	/**S�tor haszn�lata
	 *@param k Az � t�bl�j�n fog meg�p�lni a s�tor
	 */
	@Override
	public void hasznal(Karakter k) {
		k.getTabla().setMenedek(new Felallitott_sator(k.getTabla()));
		k.munkavegzes();
		//inventoryb�l kih�zni
	}

}