package projgramozok;

//Fel�ll�tott s�tor oszt�ly megval�s�t�sa.
public class Felallitott_sator extends Menedek{

	
	public Felallitott_sator(Tabla t) {
		super(t);
	}
	
	//Lerombolja a s�trat
	@Override
	public void destroy() {
		tabla.menedek = null;
	}

}
