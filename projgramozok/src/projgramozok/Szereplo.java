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
	
	/**Adott t�bl�ra l�pteti a karaktert.
	 * @param t A t�bla, amire l�pni fog
	 */
	public abstract void lep(Tabla t);
		
	/**Elkezdi a szerepl� k�r�t.
	 * 
	 */
	public abstract void korkezd(Scanner sc);
	
	/**A szerepl� befejezi a k�r�t.
	 * 
	 */
	public void endTurn()
	{
		this.setMunka(0);
		Kiiro.Kiir("K�r �tad�sa");
	}
		
	/**Be�ll�tja a szerepl� t�bl�j�t
	 * @param erre a szerpl� �j t�bl�ja
	 */
	public void setTabla(Tabla erre) {
		this.tabla = erre;
	}
}
