package projgramozok;

public class Tabla {
	protected int homennyiseg;
	protected boolean iglu;
	protected boolean atfordul;
	protected Karakter[] karakterek;
	protected Targy targy;
	protected Tabla[] szomszed;
	
	public Karakter[] getkarakterek()
	{
		return karakterek;
	}
	
	
	public Tabla getszomszed(Irany i)
	{
		return szomszed[0];
	}
	
	public void setiglu() {
		if(iglu)
			iglu = false;
		else iglu = true;
	}
	
	public void ralep(Karakter k)
	{
		
	}
	
	
	public void lelep(Karakter k) 
	{
		
	}
	
	
	public void addhomennyiseg(int i)
	{
		
	}
	
	
	public void targykias(Karakter k)
	{
		
	}
	
	
	public int getbirokepesseg() {
		return 7;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
