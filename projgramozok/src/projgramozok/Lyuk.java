package projgramozok;

import java.util.ArrayList;
import java.util.Random;

//Lyuk megval�s�t�sa
public class Lyuk extends Tabla{
	
	//Konstruktor
	public Lyuk() {
	}
	
	public Lyuk(int ho, boolean atfordult) {
		super(ho, atfordult);
	}
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ha t�bben vannak rajta mint amennyit elb�r akkor a t�bla �tfordul.
	@Override
	public void ralep(Szereplo k){
		szereplok.add(k);
		k.setTabla(this);
		Kiiro.Kiir("Lyukra leptel!.");
		k.beleesik();
		if(szereplok.size() > 0)
		  szereplok.get(0).utkozik(k);
	}
	
	//Megadja a t�bla karakterb�r� k�pess�g�t (Lyuk eset�n ez mindig 0).
	@Override
	public int getbirokepesseg(){
		return 0;
	}
}
