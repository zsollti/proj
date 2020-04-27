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
		Kiiro.Kiir("Melyik szomszéból szeretnéd kihúzni õket?");
		for(Tabla t : k.tabla.szomszed) {
			Kiiro.Kiir(k.getTabla().szomszed.indexOf(t));
		}
		int n;
		if (Palya.sc != null) {
			n = Palya.sc.nextInt();
			while (n > k.tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = Palya.sc.nextInt();
			}
		}
		else {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			while (n > k.tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = sc.nextInt();
			}
			sc.close();
		}
		List<Szereplo> rajta = k.getTabla().szomszed.get(n).getSzereplok();
		while(!rajta.isEmpty()) {
			rajta.get(0).lep(k.getTabla());
		}
		k.munkavegzes();
		Kiiro.Kiir(getName() + " hasznalva: ");
	}
	public  String getName() {
		return "Kotel";
	}
}
