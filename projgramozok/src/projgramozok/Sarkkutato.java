package projgramozok;

public class Sarkkutato extends Karakter{

	
	
	public Sarkkutato(Tabla t) {
		super(t);
		
	}

	@Override
	public void kepesseg() {
		System.out.println("-->kepesseg()");
		this.tabla.getszomszed(Irany.Bal).getbirokepesseg();
		System.out.println("void<--");
	}

	@Override
	public void addhopont(int i) {
		System.out.println("\t-->addhopont(i)");
		System.out.println("\tvoid<--");
	}

}
