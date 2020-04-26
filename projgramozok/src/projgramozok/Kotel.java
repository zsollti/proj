package projgramozok;

import java.util.List;
import java.util.Scanner;

//A k�t�l megval�s�t�sa
public class Kotel extends Targy{

	/**A k�t�l haszn�lat
	 *@param k Ennek a t�bl�r�ja l�pteti egy szomsz�dos t�bla karaktereit.
	 */
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName());
		Scanner sc = new Scanner(System.in);
		Kiiro.Kiir("Melyik szomsz�b�l szeretn�d kih�zni �ket?");
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
