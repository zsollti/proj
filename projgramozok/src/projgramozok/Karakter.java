package projgramozok;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
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
	
	/**
	 *Absztrakt f�ggv�ny, a karakterek k�pess�g�hez
	 *Minden karakternek m�sok a k�pess�gei
	 */
	public abstract void kepesseg();
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
		//this.targyak = new ArrayList<Targy>();
		targyak = new HashMap<String, ArrayList<Targy>>();
		this.munka = 4;
	}
	
	/**
	 * A karakter/ j�t�kos k�r�nek f�ggv�nye
	 * @param sc haszn�latban l�v� scanner
	 */
	@Override
	public void korkezd() {
		if(tabla.getatfordult()) {	//Ha a karakter v�zben kedi a k�r�t megvullad
			Palya.gameover(this);
			Kiiro.Kiir("Vizbe fulladt.");
			return;
		}
		munka = 4;	//Minden j�t�kos 4 "munk�val" kezdi a k�r�t
			int ij = (Palya.szereplok.indexOf(this) + 1);
			
	/*	while(munka > 0 && !Palya.gover) {	//Addig megy a j�t�kos k�re, m�g el nem fogy a munk�ja vagy  a k�re k�zben valami miatt az vagy a j�t�k v�get nem �r
			Kiiro.Kiir("A soron lev� j�t�kos: " + ij);
			String s = sc.nextLine();
			String[] ss = s.split(" ");
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
					Set<String> items = targyak.keySet();
					if(items.size() == 0) {
						Kiiro.Kiir("nincsen semmilyen t�rgyad!");
						break;
					}
					Kiiro.Kiir("Valaszd ki a kivant targyat [targy neve] vagy v�lassz m�sik tev�kenys�get - vissza.\n");
					for (String sets : items) {
						Kiiro.Kiir(sets);
					}
					s = sc.nextLine();
					if(s.equals("vissza")) {
						break;
					}
					while(!items.contains(s)) {
						Kiiro.Kiir("Nem megfelelo bemenet - nincs ilyen t�rgy. Pr�b�ld �jra!\n");
						s = sc.nextLine();
					}
					if(targyak.get(s).get(0) != null) {
						targyak.get(s).get(0).hasznal(this);
					}
					break;
				case "kepesseg":	//Karakter k�pess�g�nek haszn�lata
					kepesseg();
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
					munka = 0;
					break;
				case "kilep":		//Kil�p�s a j�t�kb�l
					Palya.gover = true;
					munka = 0;
					break;
				default:
					Kiiro.Kiir("Rossz bemenet. Adjon meg �jat");
					break;
			}
		}
		if(Palya.gover) return;		//Ha v�get �rt a j�t�k return
		Kiiro.Kiir("Nem v�gezhetsz t�bb munk�t");
		endTurn();*/
			return;
	}
	
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
				kepesseg();
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
				munka = 0;
				break;
			case "kilep":		//Kil�p�s a j�t�kb�l
				Palya.gover = true;
				munka = 0;
				break;
			default:
				Kiiro.Kiir("Rossz bemenet. Adjon meg �jat");
				break;
		}
		
		if(munka == 0)endTurn();
	}
	
	/**
	 * Karakter l�p�se
	 * @param t a t�bla, amire l�pni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomsz�dosak, akkor l�phet �t a m�sik t�bl�ra
			Tabla regi = tabla;
			tabla.lelep(this);
			int jat = Palya.szereplok.indexOf(this) + 1;
			Kiiro.Kiir(jat + ". jatekos lep " + 
					Palya.tablak.indexOf(regi) + "-r�l " +
					Palya.tablak.indexOf(t) + "-re");
			t.ralep(this);
			munkavegzes();
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
		//�res
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
