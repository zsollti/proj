package projgramozok;

public class Lyuk extends Tabla{
	
	public Lyuk(Tabla t) {
		karakterek = new Karakter[2];
		homennyiseg = 3;
		iglu = false;
		atfordul = false;
		szomszed = new Tabla[3];
		szomszed[0] = t;
	}
	
	public Lyuk() {
	
	}
	@Override
	public void ralep(Karakter k)
	{
		System.out.println("\t-->ralep(k)");
		this.karakterek[0] = k; 
		k.setTabla(this);
			k.beleesik();
			System.out.println("\tvoid<--");
	}
	
	
	@Override
	public int getbirokepesseg()
	{
		return 0;
	}
}
