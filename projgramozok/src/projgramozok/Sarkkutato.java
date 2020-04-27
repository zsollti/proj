package projgramozok;

import java.util.Scanner;

//A sarkkutató megvalóítása
public class Sarkkutato extends Karakter{
	
	/**
	 * @param t a kezdõtábla
	 */
	public Sarkkutato(Tabla t) {
		super(t);
		hopont = 4;
	}

	/**Sarkkutató képessége, lekérdezi egy szomszédos tábla karakterbíró képességét.
	 *
	 */
	@Override
	public void kepesseg() {
		Kiiro.Kiir("Melyik szomszédos tábla bíróképességét szeretnéd megnézni?");
		for(Tabla t : tabla.szomszed) {
			Kiiro.Kiir(Palya.tablak.indexOf(t)); 
		}
		int n;
		if (Palya.sc != null) {
			String nh = Palya.sc.nextLine();
			n = Integer.parseInt(nh);
			n = tabla.szomszed.indexOf(Palya.tablak.get(n));
			while (n > tabla.szomszed.size() | n < 0) {
				Kiiro.Kiir("Helytelen input!");
				n = Palya.sc.nextInt();
			}
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
		if (birokepesseg >= 0)Kiiro.Kiir("A szomszédos tábla bíróképessége:" + birokepesseg);
		else Kiiro.Kiir("A szomszédos tábla stabil");
	}

	/**A sarkkutató hõpontját növeli max 4-ig, vagy csökkenti.
	 *Ha nullára csökken a játék véget ér.
	 *@param i mennyivel nõjön a hõpontja (lehet negatív)
	 */
	@Override
	public void addhopont(int i) {	
		Kiiro.Kiir("A régi hõpont: " + hopont);
		hopont += i;
		if(hopont > 4) hopont = 4;
		if(hopont < 1) {
			Palya.gameover(this);
			Kiiro.Kiir("Megfagyott.");
		}
		else Kiiro.Kiir("Az aktuális hõpont: " + hopont);
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
