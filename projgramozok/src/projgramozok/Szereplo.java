package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *Absztrakt oszt�ly, a szerep�k megval�s�t�s�ra. (Medve, Eszkim�, Sarkkutat�)
 */

public abstract class Szereplo implements Rajzolhato {
	
	/**
	 *A t�bla amin a szerepl� elhelyezkedik.
	 */
	protected Tabla tabla;
	
	/**
	 * Konstruktor
	 * @param t A kezd�t�bla
	 */
	public Szereplo(Tabla t) {
		this.tabla = t;
		t.szereplok.add(this);
	}
	
	/**
	 *Absztrakt f�ggv�ny.
	 *@param i-vel n�veli a szerepl� h�pontj�t.
	 */
	public abstract void addhopont(int i);
	
	/**
	 *Absztrakt f�ggv�ny.
	 *A szerepl� v�zbe esik.
	 */
	public abstract void beleesik();
	
	/**
	 *Absztrakt f�ggv�ny.
	 *Egy szerpl� olyan t�bl�ra l�p ahol m�r �ll m�sik.
	 */
	public abstract void utkozik(Szereplo sz);
	
	/**
	 *Absztrakt f�ggv�ny.
	 *T�rgyat ad a szerepl�nek.
	 *@param t a T�rgy amit a szerepl�nek ad.
	 */
	public abstract void addTargy(Targy t); 
	
	/**
	 *Absztrakt f�ggv�ny.
	 **Set f�ggv�ny a munka �rt�k�nek be�ll�t�s�ra. Max 4.
	 *@param i-re �ll�tja a munka pontj�t.
	 */
	public abstract void setMunka(int i); 
	
	/**
	 *Absztrakt f�ggv�ny.
	 *Set f�ggv�ny a h�pont �rt�k�nek be�ll�t�s�ra. Max 5.
	 *@param i-re �ll�tja a h�pontj�t.
	 */
	public abstract void setHopont(int i);
	
	/**
	 *Absztrakt f�ggv�ny.
	 *A szerepl� t�rgyainak list�j�val t�r vissza
	 */
	public abstract HashMap<String, ArrayList<Targy>> getInventory();
	
	/**
	 * Adott t�bl�ra l�pteti a szerepl�t.
	 * @param t A t�bla, amire l�pni fog
	 */
	public abstract void lep(Tabla t);
		
	/**
	 * Elkezdi a szerepl� k�r�t.
	 */
	public abstract void korkezd();
	
	/**
	 * A szerepl� befejezi a k�r�t.
	 */
	public void endTurn()
	{
		this.setMunka(0);
		Palya.vezerlo.players();
		//Kiiro.Kiir("K�r �tad�sa");
	}
		
	/**
	 * Be�ll�tja a szerepl� t�bl�j�t
	 * @param erre a szerpl� �j t�bl�ja
	 */
	public void setTabla(Tabla erre) {
		this.tabla = erre;
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	public abstract void rajzol(int xpos, int ypos);
	
}
