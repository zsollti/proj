package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Medve extends Szereplo{

	private Random random = new Random(); //csak hogy ne kelljen miding �jra l�trehozni
	
	public Medve(Tabla t) {
		super(t);
	}

	@Override
	public void addhopont(int i) {
		//�res	
	}

	@Override
	public void beleesik() {
		//�res
	}
	
	public void addTargy(Targy t) {}
	
	/**ha elkap valakit, az meghal
	 *@param sz a karakter, akit elkapott
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//� az egyetlen medve
		if (sz != null && sz != this) {
			Palya.gameover(sz);
		}
	}
	
	@Override
	public void lep(Tabla t) {
		Tabla regi = tabla;
		List<Szereplo> rajta = t.getSzereplok();
		for (Szereplo sz : rajta) { //minden rajta l�v�vel �tk�zik
			utkozik(sz);
		}
		tabla.lelep(this);
		t.ralep(this);
		Kiiro.Kiir( "medve lep " + 
				Palya.tablak.indexOf(regi) + "-r�l " +
				Palya.tablak.indexOf(tabla) + "-re");
	}
	
	/**Kiv�laszt egy random t�bl�t, majd arra l�p.
	 *
	 */
	@Override
	public void korkezd(Scanner sc) {
		int i = random.nextInt(tabla.szomszed.size());
		if(!Palya.random) i = 0;
		lep(tabla.szomszed.get(i));
		tabla.setMenedek(null); //elpuszt�tja, ha tudja
		endTurn();
	}

	@Override
	public void setMunka(int i) {
		//�res
	}

	@Override
	public void setHopont(int i) {
		//�res
	}

	@Override
	public HashMap<String, ArrayList<Targy>> getInventory() {
		// �res
		return null;
	}
}
