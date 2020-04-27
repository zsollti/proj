package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Medve extends Szereplo{

	private Random random = new Random(); //csak hogy ne kelljen miding újra létrehozni
	
	public Medve(Tabla t) {
		super(t);
	}

	@Override
	public void addhopont(int i) {
		//üres	
	}

	@Override
	public void beleesik() {
		//üres
	}
	
	public void addTargy(Targy t) {}
	
	/**ha elkap valakit, az meghal
	 *@param sz a karakter, akit elkapott
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//õ az egyetlen medve
		if (sz != null && sz != this) {
			Palya.gameover(sz);
			Kiiro.Kiir("Medve általi halál");
		}
	}
	
	@Override
	public void lep(Tabla t) {
		Tabla regi = tabla;
		tabla.lelep(this);
		Kiiro.Kiir( "medve lep " + 
				Palya.tablak.indexOf(regi) + "-rõl " +
				Palya.tablak.indexOf(t) + "-re");
		t.ralep(this);
		if(t.menedek != null)t.menedek.destroy();
		if(t.menedek == null) utkozik(t.szereplok.get(0));
	}
	
	/**Kiválaszt egy random táblát, majd arra lép.
	 *
	 */
	@Override
	public void korkezd(Scanner sc) {
		int i = random.nextInt(tabla.szomszed.size());
		if(!Palya.random) i = 0;
		lep(tabla.szomszed.get(i));
		if(!Palya.gover) endTurn();
	}

	@Override
	public void setMunka(int i) {
		//üres
	}

	@Override
	public void setHopont(int i) {
		//üres
	}

	@Override
	public HashMap<String, ArrayList<Targy>> getInventory() {
		// üres
		return null;
	}
}
