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
		Tabla szomszedTabla = tabla.getszomszed(i);
		tabla.lelep(this);
		szomszedTabla.ralep(this);
	}
	
	
	public void korkezd()
	{
		if(this.tabla.getatfordult()) {
			//palya.gameover(this);?????
		}
	}
	
	
	public void addTargy(Targy t)
	{
		this.targyak.add(t);
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
