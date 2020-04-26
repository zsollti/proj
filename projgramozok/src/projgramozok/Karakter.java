package projgramozok;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;


//Absztrakt oszt�ly a karakterek hazsn�lat�hoz
public abstract class Karakter extends Szereplo{
		
	protected int hopont;
	protected int munka;
	
	protected HashMap<String, ArrayList<Targy>> targyak;
	
	public abstract void kepesseg();
	public abstract void addhopont(int i);
	
	/**
	 * @param t A t�bla, ahol kezdeni fog.
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
		if(tabla.getatfordult()) Palya.gameover(this);
		munka = 4;
		while(munka > 0) {
			Kiiro.Kiir("Valaszd ki a kivant cselekvest.\n");
			Kiiro.Kiir("lep [t�bla indexe/ szama]");
			Kiiro.Kiir("targykias");
			Kiiro.Kiir("targyhasznal - nalad levo targyak kiirasa es onnan valasztas annak indexevel");
			Kiiro.Kiir("kepesseg");
			Kiiro.Kiir("hoasas - kezzel");
			Kiiro.Kiir("endTurn - kor befejezese");
			Kiiro.Kiir("kilep - jatek befejezese");
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
						Kiiro.Kiir("nincsen semmilyen t�rgyad!");
						break;
					}
					Kiiro.Kiir("Valaszd ki a kivant targyat [targy neve].\n");
					for (String sets : items) {
						Kiiro.Kiir(sets);
					}
					s = sc.nextLine();
					while(!items.contains(s)) {
						Kiiro.Kiir("Nem megfelelo bemenet - nincs ilyen t�rgy. Pr�b�ld �jra!\n");
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
					tabla.addhomennyiseg(-1);
					break;
				case "endTurn":
					endTurn();
					break;
				case "kilep":
					Palya.gover = true;
					munka = 0;
					break;
				default:
					Kiiro.Kiir("Rossz bemenet. Adjon meg �jat");
					break;
			}
		}
	}
	
	/**Karakter l�p�se
	 *@param t a t�bla, amire l�pni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomsz�dosak, akkor l�phet �t a m�sik t�bl�ra
			Tabla regi = tabla;
			tabla.lelep(this);
			t.ralep(this);
			munkavegzes();
			Kiiro.Kiir(Palya.szereplok.indexOf(this) + "lep" + 
			Palya.tablak.indexOf(regi) + "-r�l" +
			Palya.tablak.indexOf(tabla) + "-re");
		}
	}
	
	/**
	 *
	 */
	@Override
	public void utkozik(Szereplo sz) {
		//�res
	}

	/**T�rgyat ad a karakterhez.
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
		Kiiro.Kiir(name + "get");
	}
	
	/**
	 * @return a t�bla amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		return tabla;
	}
	
	/**A karakter beleesik a v�zbe.
	 *
	 */
	public void beleesik()
	{
		munka = 0;
		if (targyak.get("Buvarruha") != null) {
			targyak.get("Buvarruha").get(0).hasznal(this);
		}
		endTurn();
	}
	
	/**Cs�kkenti a karakter munk�j�t eggyel.
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
