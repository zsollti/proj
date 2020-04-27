package projgramozok;

import java.util.Random;

//Instabil táblák egvalósítása.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	public Instabil_tabla() {
		super();
		birokepesseg = new Random().nextInt(5) +1;
	}
	
	public Instabil_tabla(int ho, boolean fordult, int bir) {
		super(ho, fordult);
		birokepesseg = bir;
	}
	
	//A paraméterként kapott szereplõt a sjátjaihoz adja.
	@Override
	public void ralep(Szereplo k)
	{
		szereplok.add(k);
		k.setTabla(this);
		if(atfordul) k.beleesik();
		else if(szereplok.size() > birokepesseg) {
			atfordul = true;
			Kiiro.Kiir("Atfordult!");
			for(Szereplo sz : szereplok) {
				sz.beleesik();
			}
		}
		szereplok.get(0).utkozik(k);
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
