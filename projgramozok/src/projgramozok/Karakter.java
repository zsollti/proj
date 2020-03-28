package projgramozok;

import java.util.ArrayList;

public abstract class Karakter {
	protected int hopont;
	protected int munka;
	protected Tabla tabla;
	protected ArrayList<Targy> targyak;
	
	
	public Karakter(Tabla t) {
		this.targyak = new ArrayList<Targy>();
		targyak.add(new Buvarruha());
		this.hopont = 4;
		this.munka = 5;
		this.tabla = t;
	}
	
	public void lep(Irany i) 
	{
		System.out.println("-->lep(i)");
		Tabla szomszedTabla = tabla.getszomszed(i);
		tabla.lelep(this);
		szomszedTabla.ralep(this);
		System.out.println("void<--");
	}
	
	public void lep(Tabla t) 
	{
		System.out.println("-->lep(i)");
		tabla.lelep(this);
		t.ralep(this);
		System.out.println("void<--");
	}
	
	
	public void korkezd()
	{
		
	}
	
	
	public void addTargy(Targy t)
	{
		System.out.println("\t-->addTargy(t)");
		this.targyak.add(t);
		System.out.println("\tvoid<--");
		
	}
	
	
	public abstract void kepesseg();
	
	
	public void endturn()
	{
		
	}
	
	
	public abstract void addhopont(int i);
	
	
	public Tabla getTabla() 
	{
		System.out.println("\t-->getTabla()");
		System.out.println("\tTabla<--");
		return tabla;
	}
	
	
	public void beleesik()
	{
		System.out.println("-->beleesik()");
		targyak.get(0).hasznal(this);
		System.out.println("void<--");
		
	}
	
	
	
	
	
	
}
