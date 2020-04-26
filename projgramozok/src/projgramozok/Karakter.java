package projgramozok;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.HashMap;


//Absztrakt oszt�ly a karakterek hazsn�lat�hoz
public abstract class Karakter extends Szereplo{
		
	protected int hopont = 0;
	protected int munka;
	
	protected ArrayList<Targy> targyak;
	//protected HashMap<Targy, Targy> a;
	
	public abstract void kepesseg();
	public abstract void addhopont(int i);
	
	/**
	 * @param t A t�bla, ahol kezdeni fog.
	 */
	public Karakter(Tabla t) {
		super(t);
		this.targyak = new ArrayList<Targy>();
		this.addhopont(5); //abstract fv h�v�s????
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
			System.out.println("Valaszd ki a kivant cselekvest.\n");
			System.out.println("lep [t�bla indexe/ szama]");
			System.out.println("targykias");
			System.out.println("targyhasznal - nalad levo targyak kiirasa es onnan valasztas annak indexevel");
			System.out.println("kepesseg");
			System.out.println("hoasas - kezzel");
			System.out.println("endTurn - kor befejezese");
			String s = sc.nextLine();
			String[] ss = s.split(" ");
			switch(ss[0]) {
				case "lep":
					int i = Integer.parseInt(ss[1]);
					lep(Palya.gettabla(i));
					break;
				case "targykias":
					tabla.targykias(this);
					break;
				case "targyhasznal":
					System.out.println("Valaszd ki a kivant targyat [targy indexe].\n");
					for(int n = 0; n < targyak.size(); n++) {
						System.out.println(n + ". " + targyak.get(n).getName());
						s = sc.nextLine();
						targyak.get(Integer.parseInt(s)).hasznal(this);
					}
					break;
				case "kepesseg":
					kepesseg();
					break;
				case "hoasas":
					tabla.addhomennyiseg(-1);
					break;
				case "endTurn":
					munka = 0;
					break;
				default:
					System.out.println("Rossz bemenet. Adjon meg �jat");
					break;
		}
	}
		//this.endturn(); //??
	}
	
	/**Karakter l�p�se
	 *@param t a t�bla, amire l�pni fog
	 */
	@Override
	public void lep(Tabla t) {
		if(tabla.szomszede(t)) {  //csak ha szomsz�dosak, akkor l�phet �t a m�sik t�bl�ra
		tabla.lelep(this);
		t.ralep(this);
		munkavegzes();
		}
		//ezt elvileg a t�bla h�vja majd, nem kell ide
		/*for (Szereplo sz : t.getkarakterek()) {
			sz.utkozik(this);
		}*/
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
	public void addTargy(Targy t)
	{
		System.out.println("\t-->addTargy(t)");
		this.targyak.add(t);
		System.out.println("\tvoid<--");
		
	}
	
	/**
	 * @return a t�bla amin a karakter elhelyezkedik
	 */
	public Tabla getTabla() 
	{
		System.out.println("\t-->getTabla()");
		System.out.println("\tTabla<--");
		return tabla;
	}
	
	/**A karakter beleesik a v�zbe.
	 *
	 */
	public void beleesik()
	{
		System.out.println("-->beleesik()");
		munka = 0;
		//!!!!!!!!!!!!
		//targyak.get(0).hasznal(this);
		//!!!!!!!!!!!!
		endTurn();
		System.out.println("void<--");
		
	}
	
	/**Cs�kkenti a karakter munk�j�t eggyel.
	 * 
	 */
	public void munkavegzes() {
		munka--;
	}
}
