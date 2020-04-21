package projgramozok;


//Az eszkkimók megvalósítása
public class Eszkimo extends Karakter{

	//Konstruktor
	public Eszkimo(Tabla t) {
		super(t);
		
	}
	
	//Eszkimó képesség, iglut épít a táblára amin áll.
	@Override
	public void kepesseg() {
		System.out.println("-->kepesseg()");
		this.tabla.setMenedek(new Iglu(this.tabla));
		this.munkavegzes();
		System.out.println("void<--");
	}

	//Az eszkimó hõpontját növeli max 5-ig, vagy csökkenti.
	//Ha nullára csökken a játék véget ér.
	@Override
	public void addhopont(int i) {
		System.out.println("\t-->addhopont(i)");
		System.out.println("\tvoid<--");
		
		hopont += i;
		
		if(hopont > 5)hopont = 5;
		else if(hopont < 1)palya.gameover(this);
		
	}

}
