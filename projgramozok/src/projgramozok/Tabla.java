package projgramozok;

import java.util.ArrayList;

public class Tabla {
	protected int homennyiseg;
	protected boolean iglu;
	protected boolean atfordul;
	protected Karakter[] karakterek;
	protected Targy targy;
	protected Tabla[] szomszed;
	
	
	public Tabla() {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[4];
	}
	public Tabla(Tabla t) {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[3];
		szomszed[0] = t;
	}
	public Karakter[] getkarakterek()
	{
		System.out.println("\t-->getkarakterek()");
		System.out.println("\tKarakter<--");
		return karakterek;
	}
	
	
	public Tabla getszomszed(Irany i)
	{
		System.out.println("\t-->getszomszed(i)");
		System.out.println("\tTabla<--");
		return szomszed[0];
		
	}
	
	public void setiglu() {
		System.out.println("\t-->setiglu()");
		iglu = true;
		System.out.println("\tvoid<--");
	}
	
	public void ralep(Karakter k)
	{
		System.out.println("\t-->ralep(k)");
		this.karakterek[0] = k;
		System.out.println("\tvoid<--");
	}
	
	
	public void lelep(Karakter k) 
	{
		System.out.println("\t-->lelep(k)");
		this.karakterek = null;
		System.out.println("\tvoid<--");
	}
	
	
	public void addhomennyiseg(int i)
	{
		System.out.println("\t-->addhomennyiseg(i)");
		System.out.println("\tvoid<--");
		if(i>0 && !iglu) {
			this.karakterek[0].addhopont(-1);
		}
	}
	
	
	public void targykias(Karakter k)
	{
		System.out.println("-->targykias(k)");
		Lapat lapat = new Lapat();
		k.addTargy(lapat);
		System.out.println("void<--");
	}
	
	
	public int getbirokepesseg() {
		System.out.println("\t-->getbirokepesseg()");
		System.out.println("\tint<--");
		return 7;
	}
	
	public boolean getatfordult()
	{
		return atfordul;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
