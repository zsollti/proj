package projgramozok;

//Felállított sátor osztály megvalósítása.
public class Felallitott_sator extends Menedek{

	
	public Felallitott_sator(Tabla t) {
		super(t);
	}
	
	//Lerombolja a sátrat
	@Override
	public void destroy() {
		tabla.menedek = null;
	}

}
