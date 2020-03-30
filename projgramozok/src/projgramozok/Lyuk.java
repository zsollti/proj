package projgramozok;


//Lyuk megvalósítása
public class Lyuk extends Tabla{
	
	//Konstruktor
	public Lyuk(Tabla t) {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[3];
		szomszed[0] = t;
	}
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	@Override
	public void ralep(Karakter k)
	{
		System.out.println("\t-->ralep(k)");
		this.karakterek[0] = k; 
		k.setTabla(this);
			k.beleesik();
			System.out.println("\tvoid<--");
	}
	
	//Megadja a tábla karakterbíró képességét (Lyuk esetén ez mindig 0).
	@Override
	public int getbirokepesseg()
	{
		return 0;
	}
}
