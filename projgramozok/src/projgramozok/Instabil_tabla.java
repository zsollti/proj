package projgramozok;


//Instabil táblák egvalósítása.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	@Override
	public void ralep(Szereplo k)
	{
		this.szereplok[this.szereplok.length] = k;
		if(this.szereplok.length > birokepesseg)
			for(int i = 0; i < this.szereplok.length; i++)
				this.szereplok[i].beleesik();
		//palya.vizsgal(szereplok);?????
	}
	
	//Megadja a tábla karakter bíró képességét.
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
