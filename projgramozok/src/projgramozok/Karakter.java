package projgramozok;

import java.util.ArrayList;

public abstract class Karakter {
	protected int hopont;
	protected int munka;
	protected Tabla tabla;
	protected ArrayList<Targy> targyak;
	
	
	public Karakter() {
		targyak = new ArrayList<Targy>();
	}
	public void lep(Irany i) 
	{
		
	}
	
	
	public void korkezd()
	{
		
	}
	
	
	public void addTargy(Targy t)
	{
		
	}
	
	
	public abstract void kepesseg();
	
	
	public void endturn()
	{
		
	}
	
	
	public abstract void addhopont(int i);
	
	
	public Tabla getTabla() 
	{
		return tabla;
	}
	
	
	public void beleesik()
	{
		
	}
	
	
	
	
	
	
}
