package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *A medve oszt�ly megval�s�t�sa
 */

public class Medve extends Szereplo{

	/**
	 *A medve randomiz�lt l�pked�s�t seg�ti.
	 */
	private Random random = new Random(); 
	
	/**
	 * @param t A kezd�t�bla
	 */
	public Medve(Tabla t) {
		super(t);
	}

	/**
	 *�res met�dus.
	 */
	@Override
	public void addhopont(int i) {
		//�res	
	}

	/**
	 *�res met�dus.
	 */
	@Override
	public void beleesik() {
		//�res
	}
	
	/**
	 *�res met�dus.
	 */
	public void addTargy(Targy t) {
		//�res
	}
	
	/**ha elkap valakit, az meghal
	 *@param sz a karakter, akit elkapott
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//� az egyetlen medve
		if (sz != null && sz != this) {
			Palya.gameover(sz);
			Kiiro.Kiir("Medve �ltali hal�l");
		}
	}
	
	/**
	 * Adott t�bl�ra l�pteti a medv�t.
	 * @param t A t�bla, amire l�pni fog
	 */
	@Override
	public void lep(Tabla t) {
		Tabla regi = tabla;
		tabla.lelep(this);
		Kiiro.Kiir( "medve lep " + 
				Palya.tablak.indexOf(regi) + "-r�l " +
				Palya.tablak.indexOf(t) + "-re");
		t.ralep(this);
		if(t.menedek != null)t.menedek.destroy();
		if(t.menedek == null) utkozik(t.szereplok.get(0));
	}
	
	/**
	 * Kiv�laszt egy random t�bl�t, majd arra l�p.
	 */
	@Override
	public void korkezd(Scanner sc) {
		int i = random.nextInt(tabla.szomszed.size());
		if(!Palya.random) i = 0;
		lep(tabla.szomszed.get(i));
		if(!Palya.gover) endTurn();
	}

	/**
	 *�res met�dus.
	 */
	@Override
	public void setMunka(int i) {
		//�res
	}

	/**
	 *�res met�dus.
	 */
	@Override
	public void setHopont(int i) {
		//�res
	}

	/**
	 *�res met�dus.
	 */
	@Override
	public HashMap<String, ArrayList<Targy>> getInventory() {
		return null;
	}
	
}
