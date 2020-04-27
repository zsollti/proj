package projgramozok;

import java.util.ArrayList;
import java.util.Random;

//Lyuk megvalósítása
public class Lyuk extends Tabla{
	
	//Konstruktor
	public Lyuk() {
	}
	
	public Lyuk(int ho, boolean atfordult) {
		super(ho, atfordult);
	}
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	@Override
	public void ralep(Szereplo k){
		szereplok.add(k);
		k.setTabla(this);
		Kiiro.Kiir("Lyukra leptel!.");
		k.beleesik();
		if(szereplok.size() > 0)
		  szereplok.get(0).utkozik(k);
	}
	
	//Megadja a tábla karakterbíró képességét (Lyuk esetén ez mindig 0).
	@Override
	public int getbirokepesseg(){
		return 0;
	}
}
