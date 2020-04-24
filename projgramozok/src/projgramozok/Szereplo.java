package projgramozok;

public abstract class Szereplo {
	//static Palya palya;	//Ahhoz, hogy tudja a pálya függvényeit hívogatni
	protected Tabla tabla;
	
	public Szereplo(Tabla t) {
		this.tabla = t;
	}
	public abstract void addhopont(int i);
	public abstract void beleesik();
	public abstract void utkozik(Karakter k);
	
	/**Adott táblára lépteti a karaktert.
	 * @param t A tábla, amire lépni fog
	 */
	public abstract void lep(Tabla t);
		
	/**Elkezdi a szereplõ körét.
	 * 
	 */
	public abstract void korkezd();
		
	/**A szereplõ befejezi a körét.
	 * 
	 */
	public void endTurn()
	{
		System.out.println("\t\t-->endtrun()");
		//a pályának szólni kéne. Majd ha látszik, hogy néz ki a main loop, elég akkor.
		System.out.println("\t\tvoid<--");
	}
		
	/**Beállítja a szereplõ tábláját
	 * @param erre a szerplõ új táblája
	 */
	public void setTabla(Tabla erre) {
		System.out.println("\t-->setTabla()");
		System.out.println("\tvoid<--");
		this.tabla = erre;
	}
}
