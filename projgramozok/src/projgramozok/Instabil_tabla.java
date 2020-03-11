package projgramozok;

public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	
	@Override
	public void ralep(Karakter k)
	{
//		this.karakterek[this.karakterek.length] = k;
//		if(this.karakterek.length > birokepesseg)
//			for(int i = 0; i < this.karakterek.length; i++)
//				this.karakterek[i].beleesik();
		//palya.vizsgal(karakterek);?????
	}
	
	
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
