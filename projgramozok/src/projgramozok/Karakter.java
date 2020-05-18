package projgramozok;

import java.util.ArrayList;
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
	
	protected boolean aktualis;
	/**
	 *Absztrakt függvény, a karakterek képességéhez
	 *Minden karakternek mások a képességei
	 *@param t A tábla amin a képességet akarjuk használni
	 */
	public abstract void kepesseg(Tabla t);
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
		targyak = new HashMap<String, ArrayList<Targy>>();
		this.munka = 4;
		this.aktualis = false;
	}
	
	/**
	 * A karakter/ játékos körének függvénye
	 * 
	 */
	@Override
	public void korkezd() {
		aktualis = true;
		if(tabla.getatfordult()) {	//Ha a karakter vízben kedi a körét megvullad
			Palya.gameover(this);
			Kiiro.Kiir("Vizbe fulladt.");
			return;
		}
		Vezerlo.hopont.setText("Hõpont: " + hopont);
		munka = 4;	//Minden játékos 4 "munkával" kezdi a körét
		return;
	}
	
	/**
	 * Az egyes tevékenyseégekre hívódik, amiket a játékos a körében csinálhat.
	 * @param tevekenyseg - maga a tevékenység
	 */
	
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
				int i = Integer.parseInt(ss[1]);
				kepesseg(Palya.tablak.get(i));
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
				aktualis = false;
				munka = 0;
				break;
			default:
				Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
				break;
		}
		if(munka <= 0) {
			aktualis = false;
			endTurn();
		}
	}
	
	/**
	 * Karakter lépése
	 * @param t a tábla, amire lépni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomszédosak, akkor léphet át a másik táblára
			munkavegzes();
			Tabla regi = tabla;
			tabla.lelep(this);
			int jat = Palya.szereplok.indexOf(this) + 1;
			Kiiro.Kiir(jat + ". jatekos lep " + 
					Palya.tablak.indexOf(regi) + "-rõl " +
					Palya.tablak.indexOf(t) + "-re");
			t.ralep(this);			
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