package projgramozok;


//Az élelem megvalósítása
public class Elelem extends Targy{

	//Az élelem használata, a paraméterként kapott karakter hõpontját növeli eggyel.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.addhopont(1);
		System.out.println("void<--");
	
	}

}
