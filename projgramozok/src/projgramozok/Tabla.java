package projgramozok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//A tábákat megvalósító osztály.
public class Tabla {
	
	static Palya palya;				//Ahhoz, hogy tudja a pálya függvényeit hívogatni
	protected Menedek menedek;
	protected int homennyiseg;
	protected boolean atfordul;
	protected List<Szereplo> szereplok;
	protected Targy targy;
	protected List<Tabla> szomszed;
	
	//Konstruktor
	public Tabla() {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		menedek = null;
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
	}
	
	//Paraméteres konstruktor
	public Tabla(Tabla t) {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		menedek = null;
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
		szomszed.add(t);
		
	}
	
	//A tábla karaktereivel tér vissza.
	public List<Szereplo> getkarakterek()
	{
		System.out.println("\t-->getkarakterek()");
		System.out.println("\tKarakter<--");
		return szereplok;
	}
	
	//A tábla adott irányba elhelyezkedõ szomszédjával tér vissza.
	public Tabla getszomszed(Irany i)
	{
		System.out.println("\t-->getszomszed(i)");
		System.out.println("\tTabla<--");
		return szomszed.get(0);
		
	}
	
	//Iglut helyez a táblára
	public void setMenedek(Menedek m) {
		System.out.println("\t-->setiglu()");
		
		System.out.println("\tvoid<--");
	}
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ezen a táblán az összes karakter elfér.
	public void ralep(Szereplo k)
	{
		System.out.println("\t-->ralep(k)");
		this.szereplok.add(k);
		k.setTabla(this);
		System.out.println("\tvoid<--");
		
	}
	
	//Eltávolítja a paraméerként kapott karaktert a sajátkai közül.
	public void lelep(Szereplo k) 
	{
		System.out.println("\t-->lelep(k)");
		this.szereplok.remove(k);
		if(szereplok.size() == 0) {
			atfordul = false;
		}
		System.out.println("\tvoid<--");
	}
	
	//A táblán levõ hó mennyiségét változtatja.
	//Max 5 min 0 lehet rajta.
	public void addhomennyiseg(int i)
	{
		System.out.println("\t-->addhomennyiseg(i)");
		System.out.println("\tvoid<--");
		
		homennyiseg += i;
		if(i > 0 && menedek != null) {
			for(Szereplo sz: szereplok) {
				sz.addhopont(-1);
			}
		}
		if(homennyiseg > 5)homennyiseg = 5;
		else if(homennyiseg < 0)homennyiseg = 0;
	}
	
	//A paraméterként kapott karakternek adja a befagyott tárgyját.
	public void targykias(Karakter k)
	{
		System.out.println("-->targykias(k)");
		if(targy != null) {
			k.addTargy(targy);
			targy = null;
		}
		System.out.println("void<--");
	}
	
	//Megadja a tábla karakterbíró képességét (Tábla esetén mindig minden karaktert elbír).
	public int getbirokepesseg() {
		System.out.println("\t-->getbirokepesseg()");
		System.out.println("\tint<--");
		return 7;
	}
	
	//Megadja, a tábla átfordult állapotát.
	public boolean getatfordult()
	{
		System.out.println("\t\tgetatfordult()");
		System.out.println("\t\tboolean<--");
		return atfordul;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
