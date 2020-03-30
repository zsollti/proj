package projgramozok;


//A sarkkutató megvalóítása
public class Sarkkutato extends Karakter{

	
	//Konstruktor
	public Sarkkutato(Tabla t) {
		super(t);
		
	}

	//Sarkkutató képessége, lekérdezi egy szomszédos tábla karakterbíró képességét.
	@Override
	public void kepesseg() {
		System.out.println("-->kepesseg()");
		this.tabla.getszomszed(Irany.Bal).getbirokepesseg();
		System.out.println("void<--");
	}

	//A sarkkutató hõpontját növeli max 4-ig, vagy csökkenti.
	//Ha nullára csökken a játék véget ér.
	@Override
	public void addhopont(int i) {
		System.out.println("\t-->addhopont(i)");
		System.out.println("\tvoid<--");
	}

}
