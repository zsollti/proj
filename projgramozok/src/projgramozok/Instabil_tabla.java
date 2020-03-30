package projgramozok;


//Instabil t�bl�k egval�s�t�sa.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ha t�bben vannak rajta mint amennyit elb�r akkor a t�bla �tfordul.
	@Override
	public void ralep(Karakter k)
	{
		this.karakterek[this.karakterek.length] = k;
		if(this.karakterek.length > birokepesseg)
			for(int i = 0; i < this.karakterek.length; i++)
				this.karakterek[i].beleesik();
		//palya.vizsgal(karakterek);?????
	}
	
	//Megadja a t�bla karakter b�r� k�pess�g�t.
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
