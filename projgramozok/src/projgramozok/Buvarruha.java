package projgramozok;


//A búvárruha megvalósítása
public class Buvarruha extends Targy{

	//A búvárruha használata, a paraméterként kapott karaktert eg másik táblára lépteti.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("\t-->hasznal(k)");
		//k.lep(Irany.Bal);
		System.out.println("\tvoid<--");
		
	}

}
