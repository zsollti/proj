package projgramozok;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Absztrakt oszt�ly a karakterek hazsn�lat�hoz
 */
public abstract class Karakter extends Szereplo{	//a Szereplo lesz�rmazottja
		
	/**
	 *A karakter h�pontjait t�rolja
	 */
	protected int hopont;
	
	/**
	 *A karakter munka pontjait t�rolja
	 */
	protected int munka;
	
	/**
	 *A karakter t�rgyait t�rolja
	 */
	protected HashMap<String, ArrayList<Targy>> targyak;
	
	protected boolean aktualis;
	/**
	 *Absztrakt f�ggv�ny, a karakterek k�pess�g�hez
	 *Minden karakternek m�sok a k�pess�gei
	 *@param t A t�bla amin a k�pess�get akarjuk haszn�lni
	 */
	public abstract void kepesseg(Tabla t);
	/**
	 * Absztrakt f�ggv�ny, a karakterek h�pontv�ltoz�s�hoz
	 * @param i a hozz�adand� h�pont
	 * Mindegyik karakternek m�s a maxim�lis h�pontja
	 */
	public abstract void addhopont(int i);
	
	/**
	 * A karakter konstruktora
	 * @param t a t�bla, ahol kezdeni fog
	 */
	public Karakter(Tabla t) {
		super(t);
		targyak = new HashMap<String, ArrayList<Targy>>();
		this.munka = 4;
		this.aktualis = false;
	}
	
	/**
	 * A karakter/ j�t�kos k�r�nek f�ggv�nye
	 * 
	 */
	@Override
	public void korkezd() {
		aktualis = true;
		if(tabla.getatfordult()) {	//Ha a karakter v�zben kedi a k�r�t megvullad
			Palya.gameover(this);
			Kiiro.Kiir("Vizbe fulladt.");
			return;
		}
		Vezerlo.hopont.setText("H�pont: " + hopont);
		munka = 4;	//Minden j�t�kos 4 "munk�val" kezdi a k�r�t
		return;
	}
	
	/**
	 * Az egyes tev�kenyse�gekre h�v�dik, amiket a j�t�kos a k�r�ben csin�lhat.
	 * @param tevekenyseg - maga a tev�kenys�g
	 */
	
	public void tevekenyseg(String tevekenyseg) {
		String[] ss = tevekenyseg.split(" ");
		switch(ss[0]) {
			case "lep":	//szomsz�dos t�bl�ra val� l�p�s
				if(ss.length == 2) {
					int i = Integer.parseInt(ss[1]);
					lep(Palya.tablak.get(i));
				} else Kiiro.Kiir("Nem megfelelo bemenet");
				break;
			case "targykias":	//t�rgy ki�s�sa a t�bl�b�l
				tabla.targykias(this);
				break;
			case "targyhasznal":	//t�rgyaid list�z�sa �s ha a j�t�kos szeretn� haszn�lata
				if(targyak.get(ss[1]).get(0) != null) {
					targyak.get(ss[1]).get(0).hasznal(this);
				}
				break;				
			case "kepesseg":	//Karakter k�pess�g�nek haszn�lata
				int i = Integer.parseInt(ss[1]);
				kepesseg(Palya.tablak.get(i));
				break;
			case "hoasas":		//H� eltakar�t�sa a t�bl�r�l k�zzel
				if(tabla.homennyiseg == 0) {
					Kiiro.Kiir("Nincs h�!");
					break;
				}
				tabla.addhomennyiseg(-1);
				munkavegzes();
				break;
			case "endTurn":		//K�r �tad�sa
				aktualis = false;
				munka = 0;
				break;
			default:
				Kiiro.Kiir("Rossz bemenet. Adjon meg �jat");
				break;
		}
		if(munka <= 0) {
			aktualis = false;
			endTurn();
		}
	}
	
	/**
	 * Karakter l�p�se
	 * @param t a t�bla, amire l�pni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomsz�dosak, akkor l�phet �t a m�sik t�bl�ra
			munkavegzes();
			Tabla regi = tabla;
			tabla.lelep(this);
			int jat = Palya.szereplok.indexOf(this) + 1;
			Kiiro.Kiir(jat + ". jatekos lep " + 
					Palya.tablak.indexOf(regi) + "-r�l " +
					Palya.tablak.indexOf(t) + "-re");
			t.ralep(this);			
		}
		else Kiiro.Kiir("A t�bla nem szomsz�dos!");
	}
	
	/**
	 * Ha a karakterrel tal�lkozik egy m�sik szerepl�
	 * @param sz a szerepl�, aki a akarakter t�bl�j�ra l�pett
	 * Nem t�rt�nik semmi - nem tudjuk milyen szerepl� tal�lkozott vele
	 */
	@Override
	public void utkozik(Szereplo sz) {
	}

	/**
	 * T�rgyat ad a karakterhez
	 * @param t a T�rgy amit a karakternek ad.
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
	 * Visszaadja a t�bl�t amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		return tabla;
	}
	
	/**
	 * A karakter beleesik a v�zbe
	 */
	public void beleesik()
	{
		munka = 0;	//v�get �r a k�re
		Kiiro.Kiir("Beleesett a vizbe.");
		if (targyak.get("Buvarruha") != null) {
			targyak.get("Buvarruha").get(0).hasznal(this);
		}
	}
	
	/**
	 * Cs�kkenti a karakter munk�j�t eggyel
	 */
	public void munkavegzes() {
		munka--;
	}
	
	/**
	 * Visszaadja a karaktern�l l�v� t�rgyakat
	 */
	@Override
	public HashMap<String, ArrayList<Targy>> getInventory(){
		return targyak;
	}
}