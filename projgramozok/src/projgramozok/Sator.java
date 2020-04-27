package projgramozok;

/**Sátor osztály, ebbõl lehet felállított sátor objektumot létrehozni.
 *
 */
public class Sator extends Targy{

	/**Sátor használata
	 *@param k Az õ tábláján fog megépülni a felállított sátor
	 *egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		k.getTabla().setMenedek(new Felallitott_sator(k.getTabla()));
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
		Kiiro.Kiir(getName() + " felépítve");
	}
	public  String getName() {
		return "Sator";
	}
}
