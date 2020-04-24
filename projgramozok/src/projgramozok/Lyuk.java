package projgramozok;

import java.util.ArrayList;
import java.util.Random;

//Lyuk megvalósítása
public class Lyuk extends Tabla{
	
	//Konstruktor
	public Lyuk(Tabla t) {
		szereplok = new ArrayList<Szereplo>();
		Random n = new Random();
		homennyiseg = n.nextInt(5);
		atfordul = true;
		szomszed = new ArrayList<Tabla>();
		szomszed.add(t);
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
