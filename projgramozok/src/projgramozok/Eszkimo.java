package projgramozok;


//Az eszkkim�k megval�s�t�sa
public class Eszkimo extends Karakter{

	//Konstruktor
	public Eszkimo(Tabla t) {
		super(t);
		
	}
	
	//Eszkim� k�pess�g, iglut �p�t a t�bl�ra amin �ll.
	@Override
	public void kepesseg() {
		System.out.println("-->kepesseg()");
		this.tabla.setiglu();
		System.out.println("void<--");
	}

	//Az eszkim� h�pontj�t n�veli max 5-ig, vagy cs�kkenti.
	//Ha null�ra cs�kken a j�t�k v�get �r.
	@Override
	public void addhopont(int i) {
		System.out.println("\t-->addhopont(i)");
		System.out.println("\tvoid<--");
		
	}

}
