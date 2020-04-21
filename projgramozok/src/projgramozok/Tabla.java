package projgramozok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//A t�b�kat megval�s�t� oszt�ly.
public class Tabla {
	
	static Palya palya;				//Ahhoz, hogy tudja a p�lya f�ggv�nyeit h�vogatni
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
	
	//Param�teres konstruktor
	public Tabla(Tabla t) {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		menedek = null;
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
		szomszed.add(t);
		
	}
	
	//A t�bla karaktereivel t�r vissza.
	public List<Szereplo> getkarakterek()
	{
		System.out.println("\t-->getkarakterek()");
		System.out.println("\tKarakter<--");
		return szereplok;
	}
	
	//A t�bla adott ir�nyba elhelyezked� szomsz�dj�val t�r vissza.
	public Tabla getszomszed(Irany i)
	{
		System.out.println("\t-->getszomszed(i)");
		System.out.println("\tTabla<--");
		return szomszed.get(0);
		
	}
	
	//Iglut helyez a t�bl�ra
	public void setMenedek(Menedek m) {
		System.out.println("\t-->setiglu()");
		
		System.out.println("\tvoid<--");
	}
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ezen a t�bl�n az �sszes karakter elf�r.
	public void ralep(Szereplo k)
	{
		System.out.println("\t-->ralep(k)");
		this.szereplok.add(k);
		k.setTabla(this);
		System.out.println("\tvoid<--");
		
	}
	
	//Elt�vol�tja a param�erk�nt kapott karaktert a saj�tkai k�z�l.
	public void lelep(Szereplo k) 
	{
		System.out.println("\t-->lelep(k)");
		this.szereplok.remove(k);
		if(szereplok.size() == 0) {
			atfordul = false;
		}
		System.out.println("\tvoid<--");
	}
	
	//A t�bl�n lev� h� mennyis�g�t v�ltoztatja.
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
	
	//A param�terk�nt kapott karakternek adja a befagyott t�rgyj�t.
	public void targykias(Karakter k)
	{
		System.out.println("-->targykias(k)");
		if(targy != null) {
			k.addTargy(targy);
			targy = null;
		}
		System.out.println("void<--");
	}
	
	//Megadja a t�bla karakterb�r� k�pess�g�t (T�bla eset�n mindig minden karaktert elb�r).
	public int getbirokepesseg() {
		System.out.println("\t-->getbirokepesseg()");
		System.out.println("\tint<--");
		return 7;
	}
	
	//Megadja, a t�bla �tfordult �llapot�t.
	public boolean getatfordult()
	{
		System.out.println("\t\tgetatfordult()");
		System.out.println("\t\tboolean<--");
		return atfordul;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
