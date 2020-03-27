package projgramozok;

public class Elelem extends Targy{

	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.addhopont(1);
		System.out.println("void<--");
	
	}

}
