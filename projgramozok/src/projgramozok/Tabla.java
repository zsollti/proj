package projgramozok;

//A tábákat megvalósító osztály.
public class Tabla {
	
	static Palya palya;				//Ahhoz, hogy tudja a pálya függvényeit hívogatni
	protected Menedek menedek;
	protected int homennyiseg;
	protected boolean atfordul;
	protected Szereplo[] szereplok;
	protected Targy targy;
	protected Tabla[] szomszed;
	
	//Konstruktor
	public Tabla() {
		szereplok = new Szereplo[2];
		homennyiseg = 3;
		menedek = null;
		atfordul = false;
		szomszed = new Tabla[4];
	}
	
	//Paraméteres konstruktor
	public Tabla(Tabla t) {
		szereplok = new Szereplo[2];
		homennyiseg = 3;
		atfordul = false;
		szomszed = new Tabla[3];
		szomszed[0] = t;
	}
	
	//A tábla karaktereivel tér vissza.
	public Szereplo[] getkarakterek()
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
		return szomszed[0];
		
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
		this.szereplok[0] = k;
		k.setTabla(this);
		System.out.println("\tvoid<--");
	}
	
	//Eltávolítja a paraméerként kapott karaktert a sajátkai közül.
	public void lelep(Szereplo k) 
	{
		System.out.println("\t-->lelep(k)");
		this.szereplok = null;
		System.out.println("\tvoid<--");
	}
	
	//A táblán levõ hó mennyiségét változtatja.
	//Max 5 min 0 lehet rajta.
	public void addhomennyiseg(int i)
	{
		System.out.println("\t-->addhomennyiseg(i)");
		System.out.println("\tvoid<--");
		if(i>0 ) {
			this.szereplok[0].addhopont(-1);
		}
	}
	
	//A paraméterként kapott karakternek adja a befagyott tárgyját.
	public void targykias(Karakter k)
	{
		System.out.println("-->targykias(k)");
		Lapat lapat = new Lapat();
		k.addTargy(lapat);
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
