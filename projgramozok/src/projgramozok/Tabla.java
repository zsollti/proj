package projgramozok;

//A tábákat megvalósító osztály.
public class Tabla {
	
	static Palya palya;				//Ahhoz, hogy tudja a pálya függvényeit hívogatni
	
	protected int homennyiseg;
	protected boolean iglu;
	protected boolean atfordul;
	protected Karakter[] karakterek;
	protected Targy targy;
	protected Tabla[] szomszed;
	
	//Konstruktor
	public Tabla() {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[4];
	}
	
	//Paraméteres konstruktor
	public Tabla(Tabla t) {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[3];
		szomszed[0] = t;
	}
	
	//A tábla karaktereivel tér vissza.
	public Karakter[] getkarakterek()
	{
		System.out.println("\t-->getkarakterek()");
		System.out.println("\tKarakter<--");
		return karakterek;
	}
	
	//A tábla adott irányba elhelyezkedõ szomszédjával tér vissza.
	public Tabla getszomszed(Irany i)
	{
		System.out.println("\t-->getszomszed(i)");
		System.out.println("\tTabla<--");
		return szomszed[0];
		
	}
	
	//Iglut helyez a táblára
	public void setiglu() {
		System.out.println("\t-->setiglu()");
		iglu = true;
		System.out.println("\tvoid<--");
	}
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ezen a táblán az összes karakter elfér.
	public void ralep(Karakter k)
	{
		System.out.println("\t-->ralep(k)");
		this.karakterek[0] = k;
		k.setTabla(this);
		System.out.println("\tvoid<--");
	}
	
	//Eltávolítja a paraméerként kapott karaktert a sajátkai közül.
	public void lelep(Karakter k) 
	{
		System.out.println("\t-->lelep(k)");
		this.karakterek = null;
		System.out.println("\tvoid<--");
	}
	
	//A táblán levõ hó mennyiségét változtatja.
	//Max 5 min 0 lehet rajta.
	public void addhomennyiseg(int i)
	{
		System.out.println("\t-->addhomennyiseg(i)");
		System.out.println("\tvoid<--");
		if(i>0 && !iglu) {
			this.karakterek[0].addhopont(-1);
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
