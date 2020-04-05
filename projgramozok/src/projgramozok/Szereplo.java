package projgramozok;

public abstract class Szereplo {
	static Palya palya;	//Ahhoz, hogy tudja a pálya függvényeit hívogatni
	protected Tabla tabla;
	
	public Szereplo(Tabla t) {
		this.tabla = t;
	}
	public abstract void addhopont(int i);
	public abstract void beleesik();
	
		//Adott táblára lépteti a karaktert.
		public void lep(Tabla t) 
		{
			System.out.println("-->lep(i)");
			tabla.lelep(this);
			t.ralep(this);
			System.out.println("void<--");
		}
		
		//Elkezdi a karakter körét.
		public void korkezd()
		{
			System.out.println("\t-->korkezd()");
			if(this.tabla.getatfordult())
				palya.gameover(this);
			this.endturn();
			System.out.println("\tvoid<--");
		}
		
		//A karakter befejezi a körét.
		public void endturn()
		{
			System.out.println("\t\t-->endtrun()");
			
			System.out.println("\t\tvoid<--");
		}
		
		//Beállítja a karakter tábláját.
		public void setTabla(Tabla erre) {
			System.out.println("\t-->setTabla()");
			System.out.println("\tvoid<--");
			this.tabla = erre;
		}
}
