package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *Absztrakt osztály, a szerepõk megvalósítására. (Medve, Eszkimó, Sarkkutató)
 */

public abstract class Szereplo implements Rajzolhato {
	
	/**
	 *A tábla amin a szereplõ elhelyezkedik.
	 */
	protected Tabla tabla;
	
	/**
	 * Konstruktor
	 * @param t A kezdõtábla
	 */
	public Szereplo(Tabla t) {
		this.tabla = t;
		t.szereplok.add(this);
	}
	
	/**
	 *Absztrakt függvény.
	 *@param i-vel növeli a szereplõ hõpontját.
	 */
	public abstract void addhopont(int i);
	
	/**
	 *Absztrakt függvény.
	 *A szereplõ vízbe esik.
	 */
	public abstract void beleesik();
	
	/**
	 *Absztrakt függvény.
	 *Egy szerplõ olyan táblára lép ahol már áll másik.
	 */
	public abstract void utkozik(Szereplo sz);
	
	/**
	 *Absztrakt függvény.
	 *Tárgyat ad a szereplõnek.
	 *@param t a Tárgy amit a szereplõnek ad.
	 */
	public abstract void addTargy(Targy t); 
	
	/**
	 *Absztrakt függvény.
	 **Set függvény a munka értékének beállítására. Max 4.
	 *@param i-re állítja a munka pontját.
	 */
	public abstract void setMunka(int i); 
	
	/**
	 *Absztrakt függvény.
	 *Set függvény a hõpont értékének beállítására. Max 5.
	 *@param i-re állítja a hõpontját.
	 */
	public abstract void setHopont(int i);
	
	/**
	 *Absztrakt függvény.
	 *A szereplõ tárgyainak listájával tér vissza
	 */
	public abstract HashMap<String, ArrayList<Targy>> getInventory();
	
	/**
	 * Adott táblára lépteti a szereplõt.
	 * @param t A tábla, amire lépni fog
	 */
	public abstract void lep(Tabla t);
		
	/**
	 * Elkezdi a szereplõ körét.
	 */
	public abstract void korkezd();
	
	/**
	 * A szereplõ befejezi a körét.
	 */
	public void endTurn()
	{
		this.setMunka(0);
		Palya.vezerlo.players();
		//Kiiro.Kiir("Kör átadása");
	}
		
	/**
	 * Beállítja a szereplõ tábláját
	 * @param erre a szerplõ új táblája
	 */
	public void setTabla(Tabla erre) {
		this.tabla = erre;
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	public abstract void rajzol(int xpos, int ypos);
	
}
