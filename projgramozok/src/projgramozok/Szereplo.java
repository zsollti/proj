package projgramozok;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Szereplo {
	protected Tabla tabla;
	
	public Szereplo(Tabla t) {
		this.tabla = t;
		t.szereplok.add(this);
	}
	public abstract void addhopont(int i);
	public abstract void beleesik();
	public abstract void utkozik(Szereplo sz);
	public abstract void addTargy(Targy t);
	public abstract void setMunka(int i);
	public abstract void setHopont(int i);
	public abstract HashMap<String, ArrayList<Targy>> getInventory();
	
	/**Adott táblára lépteti a karaktert.
	 * @param t A tábla, amire lépni fog
	 */
	public abstract void lep(Tabla t);
		
	/**Elkezdi a szereplõ körét.
	 * 
	 */
	public abstract void korkezd(Scanner sc);
	
	/**A szereplõ befejezi a körét.
	 * 
	 */
	public void endTurn()
	{
		this.setMunka(0);
		Kiiro.Kiir("Kör átadása");
	}
		
	/**Beállítja a szereplõ tábláját
	 * @param erre a szerplõ új táblája
	 */
	public void setTabla(Tabla erre) {
		this.tabla = erre;
	}
}
