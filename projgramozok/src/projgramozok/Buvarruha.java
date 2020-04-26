package projgramozok;


//A búvárruha megvalósítása
public class Buvarruha extends Targy{

	/**A búvárruha használata
	 *@param k  ezt egy másik táblára lépteti 
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
