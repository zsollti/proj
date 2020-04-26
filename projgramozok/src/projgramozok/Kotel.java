package projgramozok;

import java.util.List;
import java.util.Scanner;

//A kötél megvalósítása
public class Kotel extends Targy{

	/**A kötél használat
	 *@param k Ennek a táblárája lépteti egy szomszédos tábla karaktereit.
	 */
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName());
		Scanner sc = new Scanner(System.in);
		Kiiro.Kiir("Melyik szomszéból szeretnéd kihúzni õket?");
		for(Tabla t : k.tabla.szomszed) {
			Kiiro.Kiir(k.getTabla().szomszed.indexOf(t));
		}
		int n = sc.nextInt();
		while (n > k.tabla.szomszed.size() | n < 0) {
			Kiiro.Kiir("Helytelen input!");
			n = sc.nextInt();
		}
		List<Szereplo> rajta = k.getTabla().szomszed.get(n).getSzereplok();
		while(!rajta.isEmpty()) {
			rajta.get(0).lep(k.getTabla());
		}
	//	sc.close();
		k.munkavegzes();
	}
	public  String getName() {
		return "Kotel";
	}
}
