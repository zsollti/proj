package projgramozok;


//Instabil táblák egvalósítása.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	@Override
	public void ralep(Karakter k)
	{
		this.karakterek[this.karakterek.length] = k;
		if(this.karakterek.length > birokepesseg)
			for(int i = 0; i < this.karakterek.length; i++)
				this.karakterek[i].beleesik();
		//palya.vizsgal(karakterek);?????
	}
	
	//Megadja a tábla karakter bíró képességét.
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
