package projgramozok;

import java.util.ArrayList;
//import java.util.HashMap;


//Absztrakt osztály a karakterek hazsnálatához
public abstract class Karakter extends Szereplo{
		
	protected int hopont = 0;
	protected int munka;
	
	protected ArrayList<Targy> targyak;
	//protected HashMap<Targy, Targy> a;
	
	public abstract void kepesseg();
	public abstract void addhopont(int i);
	
	/**
	 * @param t A tábla, ahol kezdeni fog.
	 */
	public Karakter(Tabla t) {
		super(t);
		this.targyak = new ArrayList<Targy>();
		this.addhopont(5);
		this.munka = 4;
	}
	
	/**
	 *
	 */
	@Override
	public void korkezd() {
		//System.out.println("\t-->korkezd()");
		if(this.tabla.getatfordult())
			Palya.gameover(this);
			
		munka = 4;
		//this.endturn(); //??
		//System.out.println("\tvoid<--");
	}
	
	/**Karakter lépése
	 *@param t a tábla, amire lépni fog
	 */
	@Override
	public void lep(Tabla t) {
		tabla.lelep(this);
		t.ralep(this);
		munkavegzes();
		//ezt elvileg a tábla hívja majd, nem kell ide
		/*for (Szereplo sz : t.getkarakterek()) {
			sz.utkozik(this);
		}*/
	}
	
	/**
	 *
	 */
	@Override
	public void utkozik(Karakter k) {
		//üres
	}

	/**Tárgyat ad a karakterhez.
	 * @param t a Tárgy amit a karakternek ad.
	 */
	public void addTargy(Targy t)
	{
		System.out.println("\t-->addTargy(t)");
		this.targyak.add(t);
		System.out.println("\tvoid<--");
		
	}
	
	/**
	 * @return a tábla amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		System.out.println("\t-->getTabla()");
		System.out.println("\tTabla<--");
		return tabla;
	}
	
	/**A karakter beleesik a vízbe.
	 *
	 */
	public void beleesik()
	{
		System.out.println("-->beleesik()");
		munka = 0;
		//!!!!!!!!!!!!
		//targyak.get(0).hasznal(this);
		//!!!!!!!!!!!!
		System.out.println("void<--");
		
	}
	
	/**Csökkenti a karakter munkáját eggyel.
	 * 
	 */
	public void munkavegzes() {
		munka--;
	}
}
