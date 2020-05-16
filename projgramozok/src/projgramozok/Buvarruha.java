package projgramozok;


/**Búvárruha osztály. Vízbe esés esetén kimenti egy szomszédos mezõre a viselõjét.
 *
 */
public class Buvarruha extends Targy{

	/**A búvárruha használata
	 *@param k  ezt a játékost egy másik táblára lépteti, õ a viselõje
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
	 *Visszatér az osztály nevével.
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
