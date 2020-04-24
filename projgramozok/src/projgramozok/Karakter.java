package projgramozok;

import java.util.ArrayList;
//import java.util.HashMap;


//Absztrakt oszt�ly a karakterek hazsn�lat�hoz
public abstract class Karakter extends Szereplo{
		
	protected int hopont = 0;
	protected int munka;
	
	protected ArrayList<Targy> targyak;
	//protected HashMap<Targy, Targy> a;
	
	public abstract void kepesseg();
	public abstract void addhopont(int i);
	
	/**
	 * @param t A t�bla, ahol kezdeni fog.
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
	
	/**Karakter l�p�se
	 *@param t a t�bla, amire l�pni fog
	 */
	@Override
	public void lep(Tabla t) {
		tabla.lelep(this);
		t.ralep(this);
		munkavegzes();
		//ezt elvileg a t�bla h�vja majd, nem kell ide
		/*for (Szereplo sz : t.getkarakterek()) {
			sz.utkozik(this);
		}*/
	}
	
	/**
	 *
	 */
	@Override
	public void utkozik(Karakter k) {
		//�res
	}

	/**T�rgyat ad a karakterhez.
	 * @param t a T�rgy amit a karakternek ad.
	 */
	public void addTargy(Targy t)
	{
		System.out.println("\t-->addTargy(t)");
		this.targyak.add(t);
		System.out.println("\tvoid<--");
		
	}
	
	/**
	 * @return a t�bla amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		System.out.println("\t-->getTabla()");
		System.out.println("\tTabla<--");
		return tabla;
	}
	
	/**A karakter beleesik a v�zbe.
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
	
	/**Cs�kkenti a karakter munk�j�t eggyel.
	 * 
	 */
	public void munkavegzes() {
		munka--;
	}
}
