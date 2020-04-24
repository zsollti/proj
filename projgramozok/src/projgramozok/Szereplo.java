package projgramozok;

public abstract class Szereplo {
	//static Palya palya;	//Ahhoz, hogy tudja a p�lya f�ggv�nyeit h�vogatni
	protected Tabla tabla;
	
	public Szereplo(Tabla t) {
		this.tabla = t;
	}
	public abstract void addhopont(int i);
	public abstract void beleesik();
	public abstract void utkozik(Karakter k);
	
	/**Adott t�bl�ra l�pteti a karaktert.
	 * @param t A t�bla, amire l�pni fog
	 */
	public abstract void lep(Tabla t);
		
	/**Elkezdi a szerepl� k�r�t.
	 * 
	 */
	public abstract void korkezd();
		
	/**A szerepl� befejezi a k�r�t.
	 * 
	 */
	public void endTurn()
	{
		System.out.println("\t\t-->endtrun()");
		//a p�ly�nak sz�lni k�ne. Majd ha l�tszik, hogy n�z ki a main loop, el�g akkor.
		System.out.println("\t\tvoid<--");
	}
		
	/**Be�ll�tja a szerepl� t�bl�j�t
	 * @param erre a szerpl� �j t�bl�ja
	 */
	public void setTabla(Tabla erre) {
		System.out.println("\t-->setTabla()");
		System.out.println("\tvoid<--");
		this.tabla = erre;
	}
}
