package projgramozok;

import java.util.ArrayList;


//Absztrakt oszt�ly a karakterek hazsn�lat�hoz
public abstract class Karakter extends Szereplo{
	
					
	
	protected int hopont;
	protected int munka;
	
	protected ArrayList<Targy> targyak;
	
	//Konstruktor
	public Karakter(Tabla t) {
		super(t);
		this.targyak = new ArrayList<Targy>();
		targyak.add(new Buvarruha());
		this.hopont = 4;
		this.munka = 5;
	}
	
	
	

	
	//T�rgyat ad a karakterhez.
	public void addTargy(Targy t)
	{
		System.out.println("\t-->addTargy(t)");
		this.targyak.add(t);
		System.out.println("\tvoid<--");
		
	}
	
	
	public abstract void kepesseg();
	public abstract void addhopont(int i);
	
	//Visszaadja a t�bl�t amin a karakter elhelyezkedik.
	public Tabla getTabla() 
	{
		System.out.println("\t-->getTabla()");
		System.out.println("\tTabla<--");
		return tabla;
	}
	
	
	//A karakter beleesik a v�zbe.
	public void beleesik()
	{
		System.out.println("-->beleesik()");
		targyak.get(0).hasznal(this);
		System.out.println("void<--");
		
	}
	
	
	
	
	
	
}
