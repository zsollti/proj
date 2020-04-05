package projgramozok;

public abstract class Szereplo {
	static Palya palya;	//Ahhoz, hogy tudja a p�lya f�ggv�nyeit h�vogatni
	protected Tabla tabla;
	
	public Szereplo(Tabla t) {
		this.tabla = t;
	}
	public abstract void addhopont(int i);
	public abstract void beleesik();
	
		//Adott t�bl�ra l�pteti a karaktert.
		public void lep(Tabla t) 
		{
			System.out.println("-->lep(i)");
			tabla.lelep(this);
			t.ralep(this);
			System.out.println("void<--");
		}
		
		//Elkezdi a karakter k�r�t.
		public void korkezd()
		{
			System.out.println("\t-->korkezd()");
			if(this.tabla.getatfordult())
				palya.gameover(this);
			this.endturn();
			System.out.println("\tvoid<--");
		}
		
		//A karakter befejezi a k�r�t.
		public void endturn()
		{
			System.out.println("\t\t-->endtrun()");
			
			System.out.println("\t\tvoid<--");
		}
		
		//Be�ll�tja a karakter t�bl�j�t.
		public void setTabla(Tabla erre) {
			System.out.println("\t-->setTabla()");
			System.out.println("\tvoid<--");
			this.tabla = erre;
		}
}
