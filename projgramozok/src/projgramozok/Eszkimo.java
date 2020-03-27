package projgramozok;

public class Eszkimo extends Karakter{

	public Eszkimo(Tabla t) {
		super(t);
		
	}
	
	@Override
	public void kepesseg() {
		System.out.println("-->kepesseg()");
		this.tabla.setiglu();
		System.out.println("void<--");
	}

	@Override
	public void addhopont(int i) {
		System.out.println("\t-->addhopont(i)");
		System.out.println("\tvoid<--");
		
	}

}
