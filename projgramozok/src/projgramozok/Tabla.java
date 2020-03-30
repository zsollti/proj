package projgramozok;

//A t�b�kat megval�s�t� oszt�ly.
public class Tabla {
	
	static Palya palya;				//Ahhoz, hogy tudja a p�lya f�ggv�nyeit h�vogatni
	
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
	
	//Param�teres konstruktor
	public Tabla(Tabla t) {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[3];
		szomszed[0] = t;
	}
	
	//A t�bla karaktereivel t�r vissza.
	public Karakter[] getkarakterek()
	{
		System.out.println("\t-->getkarakterek()");
		System.out.println("\tKarakter<--");
		return karakterek;
	}
	
	//A t�bla adott ir�nyba elhelyezked� szomsz�dj�val t�r vissza.
	public Tabla getszomszed(Irany i)
	{
		System.out.println("\t-->getszomszed(i)");
		System.out.println("\tTabla<--");
		return szomszed[0];
		
	}
	
	//Iglut helyez a t�bl�ra
	public void setiglu() {
		System.out.println("\t-->setiglu()");
		iglu = true;
		System.out.println("\tvoid<--");
	}
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ezen a t�bl�n az �sszes karakter elf�r.
	public void ralep(Karakter k)
	{
		System.out.println("\t-->ralep(k)");
		this.karakterek[0] = k;
		k.setTabla(this);
		System.out.println("\tvoid<--");
	}
	
	//Elt�vol�tja a param�erk�nt kapott karaktert a saj�tkai k�z�l.
	public void lelep(Karakter k) 
	{
		System.out.println("\t-->lelep(k)");
		this.karakterek = null;
		System.out.println("\tvoid<--");
	}
	
	//A t�bl�n lev� h� mennyis�g�t v�ltoztatja.
	//Max 5 min 0 lehet rajta.
	public void addhomennyiseg(int i)
	{
		System.out.println("\t-->addhomennyiseg(i)");
		System.out.println("\tvoid<--");
		if(i>0 && !iglu) {
			this.karakterek[0].addhopont(-1);
		}
	}
	
	//A param�terk�nt kapott karakternek adja a befagyott t�rgyj�t.
	public void targykias(Karakter k)
	{
		System.out.println("-->targykias(k)");
		Lapat lapat = new Lapat();
		k.addTargy(lapat);
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
