package projgramozok;

import java.util.ArrayList;

public class Tabla {
	protected int homennyiseg;
	protected boolean iglu;
	protected boolean atfordul;
	protected ArrayList<Karakter> karakterek;
	protected Targy targy;
	protected Tabla[] szomszed;
	
	
	public Tabla() {
		karakterek = new ArrayList<Karakter>();
	}
	
	public ArrayList<Karakter> getkarakterek()
	{
		return karakterek;
	}
	
	
	public Tabla getszomszed(Irany i)
	{
		return szomszed[0];
	}
	
	public void setiglu() {
		iglu = true;
	}
	
	public void ralep(Karakter k)
	{
		this.karakterek.add(k);
	}
	
	
	public void lelep(Karakter k) 
	{
		this.karakterek.remove(k);
		
	}
	
	
	public void addhomennyiseg(int i)
	{
		if(i < 0) {
			if(this.homennyiseg + i < 0)
				this.homennyiseg = 0;
			else this.homennyiseg += i;
		}
		
		else {
			if(this.homennyiseg + i > 5)
				this.homennyiseg = 5;
			else 
				this.homennyiseg += i;
			
			if(!iglu) {
				
			}
		}
		
	}
	
	
	public void targykias(Karakter k)
	{
		
	}
	
	
	public int getbirokepesseg() {
		return 7;
	}
	
	public boolean getatfordult()
	{
		return atfordul;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
