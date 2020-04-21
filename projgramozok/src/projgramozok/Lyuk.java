package projgramozok;

import java.util.ArrayList;
import java.util.Random;

//Lyuk megval�s�t�sa
public class Lyuk extends Tabla{
	
	//Konstruktor
	public Lyuk(Tabla t) {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		atfordul = false;
		szomszed = new ArrayList<Tabla>();
		szomszed.add(t);
	}
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ha t�bben vannak rajta mint amennyit elb�r akkor a t�bla �tfordul.
	@Override
	public void ralep(Szereplo k)
	{
		System.out.println("\t-->ralep(k)");
		
		szereplok.add(k);
		k.setTabla(this);
		atfordul = true;
		k.beleesik();

		System.out.println("\tvoid<--");
	}
	
	//Megadja a t�bla karakterb�r� k�pess�g�t (Lyuk eset�n ez mindig 0).
	@Override
	public int getbirokepesseg()
	{
		return 0;
	}
}
