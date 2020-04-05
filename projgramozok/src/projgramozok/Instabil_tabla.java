package projgramozok;


//Instabil t�bl�k egval�s�t�sa.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ha t�bben vannak rajta mint amennyit elb�r akkor a t�bla �tfordul.
	@Override
	public void ralep(Szereplo k)
	{
		this.szereplok[this.szereplok.length] = k;
		if(this.szereplok.length > birokepesseg)
			for(int i = 0; i < this.szereplok.length; i++)
				this.szereplok[i].beleesik();
		//palya.vizsgal(szereplok);?????
	}
	
	//Megadja a t�bla karakter b�r� k�pess�g�t.
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
