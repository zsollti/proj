package projgramozok;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;


/**
 * Absztrakt osztály a karakterek hazsnálatához
 */
public abstract class Karakter extends Szereplo{	//a Szereplo leszármazottja
		
	/**
	 *A karakter hõpontjait tárolja
	 */
	protected int hopont;
	
	/**
	 *A karakter munka pontjait tárolja
	 */
	protected int munka;
	
	/**
	 *A karakter tárgyait tárolja
	 */
	protected HashMap<String, ArrayList<Targy>> targyak;
	
	/**
	 *Absztrakt függvény, a karakterek képességéhez
	 *Minden karakternek mások a képességei
	 */
	public abstract void kepesseg();
	/**
	 * Absztrakt függvény, a karakterek hõpontváltozásához
	 * @param i a hozzáadandó hõpont
	 * Mindegyik karakternek más a maximális hõpontja
	 */
	public abstract void addhopont(int i);
	
	/**
	 * A karakter konstruktora
	 * @param t a tábla, ahol kezdeni fog
	 */
	public Karakter(Tabla t) {
		super(t);
		//this.targyak = new ArrayList<Targy>();
		targyak = new HashMap<String, ArrayList<Targy>>();
		this.munka = 4;
	}
	
	/**
	 * A karakter/ játékos körének függvénye
	 * @param sc használatban lévõ scanner
	 */
	@Override
	public void korkezd() {
		if(tabla.getatfordult()) {	//Ha a karakter vízben kedi a körét megvullad
			Palya.gameover(this);
			Kiiro.Kiir("Vizbe fulladt.");
			return;
		}
		munka = 4;	//Minden játékos 4 "munkával" kezdi a körét
			int ij = (Palya.szereplok.indexOf(this) + 1);
			
	/*	while(munka > 0 && !Palya.gover) {	//Addig megy a játékos köre, míg el nem fogy a munkája vagy  a köre közben valami miatt az vagy a játék véget nem ér
			Kiiro.Kiir("A soron levõ játékos: " + ij);
			String s = sc.nextLine();
			String[] ss = s.split(" ");
			switch(ss[0]) {
				case "lep":	//szomszédos táblára való lépés
					if(ss.length == 2) {
						int i = Integer.parseInt(ss[1]);
						lep(Palya.tablak.get(i));
					} else Kiiro.Kiir("Nem megfelelo bemenet");
					break;
				case "targykias":	//tárgy kiásása a táblából
					tabla.targykias(this);
					break;
				case "targyhasznal":	//tárgyaid listázása és ha a játékos szeretné használata
					Set<String> items = targyak.keySet();
					if(items.size() == 0) {
						Kiiro.Kiir("nincsen semmilyen tárgyad!");
						break;
					}
					Kiiro.Kiir("Valaszd ki a kivant targyat [targy neve] vagy válassz másik tevékenységet - vissza.\n");
					for (String sets : items) {
						Kiiro.Kiir(sets);
					}
					s = sc.nextLine();
					if(s.equals("vissza")) {
						break;
					}
					while(!items.contains(s)) {
						Kiiro.Kiir("Nem megfelelo bemenet - nincs ilyen tárgy. Próbáld újra!\n");
						s = sc.nextLine();
					}
					if(targyak.get(s).get(0) != null) {
						targyak.get(s).get(0).hasznal(this);
					}
					break;
				case "kepesseg":	//Karakter képességének használata
					kepesseg();
					break;
				case "hoasas":		//Hó eltakarítása a tábláról kézzel
					if(tabla.homennyiseg == 0) {
						Kiiro.Kiir("Nincs hó!");
						break;
					}
					tabla.addhomennyiseg(-1);
					munkavegzes();
					break;
				case "endTurn":		//Kör átadása
					munka = 0;
					break;
				case "kilep":		//Kilépés a játékból
					Palya.gover = true;
					munka = 0;
					break;
				default:
					Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
					break;
			}
		}
		if(Palya.gover) return;		//Ha véget ért a játék return
		Kiiro.Kiir("Nem végezhetsz több munkát");
		endTurn();*/
			return;
	}
	
	public void tevekenyseg(String tevekenyseg) {
		String[] ss = tevekenyseg.split(" ");
		switch(ss[0]) {
			case "lep":	//szomszédos táblára való lépés
				if(ss.length == 2) {
					int i = Integer.parseInt(ss[1]);
					lep(Palya.tablak.get(i));
				} else Kiiro.Kiir("Nem megfelelo bemenet");
				break;
			case "targykias":	//tárgy kiásása a táblából
				tabla.targykias(this);
				break;
			case "targyhasznal":	//tárgyaid listázása és ha a játékos szeretné használata
				if(targyak.get(ss[1]).get(0) != null) {
					targyak.get(ss[1]).get(0).hasznal(this);
				}
				break;				
			case "kepesseg":	//Karakter képességének használata
				kepesseg();
				break;
			case "hoasas":		//Hó eltakarítása a tábláról kézzel
				if(tabla.homennyiseg == 0) {
					Kiiro.Kiir("Nincs hó!");
					break;
				}
				tabla.addhomennyiseg(-1);
				munkavegzes();
				break;
			case "endTurn":		//Kör átadása
				munka = 0;
				break;
			case "kilep":		//Kilépés a játékból
				Palya.gover = true;
				munka = 0;
				break;
			default:
				Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
				break;
		}
		
		if(munka == 0)endTurn();
	}
	
	/**
	 * Karakter lépése
	 * @param t a tábla, amire lépni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomszédosak, akkor léphet át a másik táblára
			Tabla regi = tabla;
			tabla.lelep(this);
			int jat = Palya.szereplok.indexOf(this) + 1;
			Kiiro.Kiir(jat + ". jatekos lep " + 
					Palya.tablak.indexOf(regi) + "-rõl " +
					Palya.tablak.indexOf(t) + "-re");
			t.ralep(this);
			munkavegzes();
		}
		else Kiiro.Kiir("A tábla nem szomszédos!");
	}
	
	/**
	 * Ha a karakterrel találkozik egy másik szereplõ
	 * @param sz a szereplõ, aki a akarakter táblájára lépett
	 * Nem történik semmi - nem tudjuk milyen szereplõ találkozott vele
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//üres
	}

	/**
	 * Tárgyat ad a karakterhez
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
	 * Visszaadja a táblát amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		return tabla;
	}
	
	/**
	 * A karakter beleesik a vízbe
	 */
	public void beleesik()
	{
		munka = 0;	//véget ér a köre
		Kiiro.Kiir("Beleesett a vizbe.");
		if (targyak.get("Buvarruha") != null) {
			targyak.get("Buvarruha").get(0).hasznal(this);
		}
	}
	
	/**
	 * Csökkenti a karakter munkáját eggyel
	 */
	public void munkavegzes() {
		munka--;
	}
	
	/**
	 * Visszaadja a karakternél lévõ tárgyakat
	 */
	@Override
	public HashMap<String, ArrayList<Targy>> getInventory(){
		return targyak;
	}
}
