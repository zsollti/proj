package projgramozok;


//A búvárruha megvalósítása
public class Buvarruha extends Targy{

	/**A búvárruha használata
	 *@param k  ezt egy másik táblára lépteti 
	 */
	@Override
	public void hasznal(Karakter k) {
		if(k.getTabla().getatfordult() == true){ //nem felesleges? csak a beleesiknél hívódik meg
			k.lep(k.getTabla().szomszed.get(0));
			Kiiro.Kiir(getName() + " hasznalva:");
		}
		else Kiiro.Kiir("Nem vagy vizben, nem tudod hasznalni");
	}
	public  String getName() {
		return "Buvarruha";
	}
}
