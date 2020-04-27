package projgramozok;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;


//Absztrakt osztály a karakterek hazsnálatához
public abstract class Karakter extends Szereplo{
		
	protected int hopont;
	protected int munka;
	
	protected HashMap<String, ArrayList<Targy>> targyak;
	
	public abstract void kepesseg();
	public abstract void addhopont(int i);
	
	/**
	 * @param t A tábla, ahol kezdeni fog.
	 */
	public Karakter(Tabla t) {
		super(t);
		//this.targyak = new ArrayList<Targy>();
		targyak = new HashMap<String, ArrayList<Targy>>();
		this.munka = 4;
	}
	
	/**
	 *
	 */
	@Override
	public void korkezd(Scanner sc) {
		if(tabla.getatfordult()) {
			Palya.gameover(this);
			return;
		}
		munka = 4;
			int ij = (Palya.szereplok.indexOf(this) + 1);
			
		while(munka > 0) {
			Kiiro.Kiir("A soron levõ játékos: " + ij);
			String s = sc.nextLine();
			String[] ss = s.split(" ");
			switch(ss[0]) {
				case "lep":
					if(ss.length == 2) {
						int i = Integer.parseInt(ss[1]);
						lep(Palya.gettabla(i));
					} else Kiiro.Kiir("Nem megfelelo bemenet");
					break;
				case "targykias":
					tabla.targykias(this);
					break;
				case "targyhasznal":
					Set<String> items = targyak.keySet();
					if(items.size() == 0) {
						Kiiro.Kiir("nincsen semmilyen tárgyad!");
						break;
					}
					Kiiro.Kiir("Valaszd ki a kivant targyat [targy neve].\n");
					for (String sets : items) {
						Kiiro.Kiir(sets);
					}
					s = sc.nextLine();
					while(!items.contains(s)) {
						Kiiro.Kiir("Nem megfelelo bemenet - nincs ilyen tárgy. Próbáld újra!\n");
						s = sc.nextLine();
					}
					if(targyak.get(s).get(0) != null) {
						targyak.get(s).get(0).hasznal(this);
					}
					break;
				case "kepesseg":
					kepesseg();
					break;
				case "hoasas":
					if(tabla.homennyiseg == 0) {
						Kiiro.Kiir("Nincs hó!");
						break;
					}
					tabla.addhomennyiseg(-1);
					break;
				case "endTurn":
					munka = 0;
					break;
				case "kilep":
					Palya.gover = true;
					munka = 0;
					break;
				default:
					Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
					break;
			}
		}
		if(Palya.gover) return;
		Kiiro.Kiir("Nem végezhetsz több munkát");
		endTurn();
	}
	
	/**Karakter lépése
	 *@param t a tábla, amire lépni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomszédosak, akkor léphet át a másik táblára
			Tabla regi = tabla;
			tabla.lelep(this);
			t.ralep(this);
			munkavegzes();
			int jat = Palya.szereplok.indexOf(this) + 1;
			Kiiro.Kiir(jat + ". jatekos lep " + 
			Palya.tablak.indexOf(regi) + "-rõl " +
			Palya.tablak.indexOf(tabla) + "-re");
		}
		else Kiiro.Kiir("A tábla nem szomszédos!");
	}
	
	/**
	 *
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//üres
	}

	/**Tárgyat ad a karakterhez.
	 * @param t a Tárgy amit a karakternek ad.
	 */
	public void addTargy(Targy t) {
		String name = t.getName();
		if(targyak.containsKey(name)) {
			targyak.get(name).add(t);
		}
		else {
			targyak.put(name, new ArrayList<Targy>());
			targyak.get(name).add(t);
		}
	}
	
	/**
	 * @return a tábla amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		return tabla;
	}
	
	/**A karakter beleesik a vízbe.
	 *
	 */
	public void beleesik()
	{
		munka = 0;
		Kiiro.Kiir("Beleesett a vizbe.");
		if (targyak.get("Buvarruha") != null) {
			targyak.get("Buvarruha").get(0).hasznal(this);
		}
	}
	
	/**Csökkenti a karakter munkáját eggyel.
	 * 
	 */
	public void munkavegzes() {
		munka--;
	}
	
	@Override
	public HashMap<String, ArrayList<Targy>> getInventory(){
		return targyak;
	}
}
