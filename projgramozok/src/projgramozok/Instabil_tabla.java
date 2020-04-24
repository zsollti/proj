package projgramozok;


//Instabil táblák egvalósítása.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	@Override
	public void ralep(Szereplo k)
	{
		szereplok.add(k);
		k.setTabla(this);
		if(szereplok.size() > birokepesseg) {
			atfordul = true;
			for(Szereplo sz : szereplok) {
				sz.beleesik();
			}
		}
	}
	
	//Eltávolítja a paraméterként kapott karaktert a sajátjai közül.
		public void lelep(Szereplo k) {
			this.szereplok.remove(k);
			if(szereplok.size() == 0) {
				atfordul = false;
			}
		}
	
	//Megadja a tábla karakter bíró képességét.
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
