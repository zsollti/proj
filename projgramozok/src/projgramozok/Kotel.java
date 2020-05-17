package projgramozok;

import java.util.List;
import java.util.Scanner;

/**Kötél osztály. Egy szomszédos tábláról kimenti az összes vízben levõ játékost, maga mellé húzza.
 *
 */
public class Kotel extends Targy{

	/**A kötél használata
	 *@param k Ennek a táblárája lépteti egy szomszédos tábla karaktereit.
	 *egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		/*Kiiro.Kiir(getName());
		Kiiro.Kiir("Melyik szomszédból szeretnéd kihúzni õket?");
		for(Tabla t : k.tabla.szomszed) {				//Ezek a tábla szomszédai
			Kiiro.Kiir(Palya.tablak.indexOf(t)); 
		}
		int n;
		if (Palya.sc != null) {							//Ha fájlból olvasunk
			String nh = Palya.sc.nextLine();
			n = Integer.parseInt(nh);
			n = k.tabla.szomszed.indexOf(Palya.tablak.get(n));
			while (n > k.tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = Palya.sc.nextInt();
			}
		}
		else {											//Ha a konzolról olvasunk
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			while (n > k.tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = sc.nextInt();
			}
			sc.close();
		}*/
		for (Tabla t : k.tabla.szomszed) {
			if (t.getatfordult()) {
				List<Szereplo> rajta = t.getSzereplok();
				while(!rajta.isEmpty()) {						//Az összes vízben levõt kimenti
					rajta.get(0).lep(k.getTabla());
				}
			}
		}
		Kiiro.Kiir(getName() + " hasznalva");
		/*List<Szereplo> rajta = k.getTabla().szomszed.get(n).getSzereplok();
		while(!rajta.isEmpty()) {						//Az összes vízben levõt kimenti
			rajta.get(0).lep(k.getTabla());
		}*/
		k.munkavegzes();
		
	}
	
	/**
	 *Visszatér az osztály nevével
	 */
	public  String getName() {
		return "Kotel";
	}
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("kotel", xpos+75, ypos+75);
	}
	
}
