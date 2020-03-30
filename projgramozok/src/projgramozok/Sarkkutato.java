package projgramozok;


//A sarkkutat� megval��t�sa
public class Sarkkutato extends Karakter{

	
	//Konstruktor
	public Sarkkutato(Tabla t) {
		super(t);
		
	}

	//Sarkkutat� k�pess�ge, lek�rdezi egy szomsz�dos t�bla karakterb�r� k�pess�g�t.
	@Override
	public void kepesseg() {
		System.out.println("-->kepesseg()");
		this.tabla.getszomszed(Irany.Bal).getbirokepesseg();
		System.out.println("void<--");
	}

	//A sarkkutat� h�pontj�t n�veli max 4-ig, vagy cs�kkenti.
	//Ha null�ra cs�kken a j�t�k v�get �r.
	@Override
	public void addhopont(int i) {
		System.out.println("\t-->addhopont(i)");
		System.out.println("\tvoid<--");
	}

}
