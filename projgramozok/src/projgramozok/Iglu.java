package projgramozok;

//Az iglu osztály megvalósítása
public class Iglu extends Menedek{
	
	
	public Iglu (Tabla t) {
		super(t);
	}
	
	//Iglut nem lehet megsemmisíteni, ezért ez a függvény üres.
	@Override
	public void destroy() {
		
	}
}
