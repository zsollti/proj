package projgramozok;

import java.util.ArrayList;
import java.util.Random;

//Lyuk megvalósítása
public class Lyuk extends Tabla{
	
	//Konstruktor
	public Lyuk(Palya p) {
		super(p);
	}
	
	//Paraméterként kapott karaktert eltárolja a sajátjai közt.
	//Ha többen vannak rajta mint amennyit elbír akkor a tábla átfordul.
	@Override
	public void ralep(Szereplo k){
		szereplok.add(k);
		k.setTabla(this);
		k.beleesik();
		szereplok.get(0).utkozik(k);
	}
	
	//Megadja a tábla karakterbíró képességét (Lyuk esetén ez mindig 0).
	@Override
	public int getbirokepesseg(){
		return 0;
	}
}
