package projgramozok;


//Lyuk megval�s�t�sa
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
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ha t�bben vannak rajta mint amennyit elb�r akkor a t�bla �tfordul.
	@Override
	public void ralep(Karakter k)
	{
		System.out.println("\t-->ralep(k)");
		this.karakterek[0] = k; 
		k.setTabla(this);
			k.beleesik();
			System.out.println("\tvoid<--");
	}
	
	//Megadja a t�bla karakterb�r� k�pess�g�t (Lyuk eset�n ez mindig 0).
	@Override
	public int getbirokepesseg()
	{
		return 0;
	}
}
