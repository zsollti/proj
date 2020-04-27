package projgramozok;

import java.util.Scanner;

//A sarkkutat� megval��t�sa
public class Sarkkutato extends Karakter{
	
	/**
	 * @param t a kezd�t�bla
	 */
	public Sarkkutato(Tabla t) {
		super(t);
		hopont = 4;
	}

	/**Sarkkutat� k�pess�ge, lek�rdezi egy szomsz�dos t�bla karakterb�r� k�pess�g�t.
	 *
	 */
	@Override
	public void kepesseg() {
		int n;
		if (Palya.sc != null) {
			n = Palya.sc.nextInt();
		}
		else {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			while (n > tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = sc.nextInt();
			}
			sc.close();
		}
		int birokepesseg = tabla.szomszed.get(n).getbirokepesseg();
		munkavegzes();
		Kiiro.Kiir("A szomsz�dos t�bla b�r�k�pess�ge:" + birokepesseg);
	}

	/**A sarkkutat� h�pontj�t n�veli max 4-ig, vagy cs�kkenti.
	 *Ha null�ra cs�kken a j�t�k v�get �r.
	 *@param i mennyivel n�j�n a h�pontja (lehet negat�v)
	 */
	@Override
	public void addhopont(int i) {	
		Kiiro.Kiir("A r�gi h�pont: " + hopont);
		hopont += i;
		if(hopont > 4) hopont = 4;
		else if(hopont < 1)Palya.gameover(this);
		Kiiro.Kiir("Az aktu�lis h�pont: " + hopont);
	}

	@Override
	public void setMunka(int i) {
		if (i > 4) i=4;
		munka = i;
	}

	@Override
	public void setHopont(int i) {
		if (i > 4) i=4;
		hopont = i;
	}

}
