package projgramozok;

public class Buvarruha extends Targy{

	@Override
	public void hasznal(Karakter k) {
		System.out.println("\t-->hasznal(k)");
		k.lep(Irany.Bal);
		System.out.println("\tvoid<--");
		
	}

}
