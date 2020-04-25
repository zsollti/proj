package projgramozok;


//A búvárruha megvalósítása
public class Buvarruha extends Targy{

	/**A búvárruha használata
	 *@param k  ezt egy másik táblára lépteti 
	 */
	@Override
	public void hasznal(Karakter k) {
		//System.out.println("\t-->hasznal(k)");
		k.lep(k.getTabla().szomszed.get(0)); //az elsõ szomszéd
		//System.out.println("\tvoid<--");
		
	}
	public  String getName() {
		return "Buvarruha";
	}
}
