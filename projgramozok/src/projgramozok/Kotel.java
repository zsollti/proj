package projgramozok;

import java.util.List;
import java.util.Scanner;

/**K�t�l oszt�ly. Egy szomsz�dos t�bl�r�l kimenti az �sszes v�zben lev� j�t�kost, maga mell� h�zza.
 *
 */
public class Kotel extends Targy{

	/**A k�t�l haszn�lata
	 *@param k Ennek a t�bl�r�ja l�pteti egy szomsz�dos t�bla karaktereit.
	 *egy munkav�gz�sbe ker�l
	 */
	@Override
	public void hasznal(Karakter k) {
		/*Kiiro.Kiir(getName());
		Kiiro.Kiir("Melyik szomsz�db�l szeretn�d kih�zni �ket?");
		for(Tabla t : k.tabla.szomszed) {				//Ezek a t�bla szomsz�dai
			Kiiro.Kiir(Palya.tablak.indexOf(t)); 
		}
		int n;
		if (Palya.sc != null) {							//Ha f�jlb�l olvasunk
			String nh = Palya.sc.nextLine();
			n = Integer.parseInt(nh);
			n = k.tabla.szomszed.indexOf(Palya.tablak.get(n));
			while (n > k.tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = Palya.sc.nextInt();
			}
		}
		else {											//Ha a konzolr�l olvasunk
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
				while(!rajta.isEmpty()) {						//Az �sszes v�zben lev�t kimenti
					rajta.get(0).lep(k.getTabla());
				}
			}
		}
		Kiiro.Kiir(getName() + " hasznalva");
		/*List<Szereplo> rajta = k.getTabla().szomszed.get(n).getSzereplok();
		while(!rajta.isEmpty()) {						//Az �sszes v�zben lev�t kimenti
			rajta.get(0).lep(k.getTabla());
		}*/
		k.munkavegzes();
		
	}
	
	/**
	 *Visszat�r az oszt�ly nev�vel
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
