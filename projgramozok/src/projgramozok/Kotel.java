package projgramozok;

public class Kotel extends Targy{

	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		Karakter uj = k.getTabla().getszomszed(Irany.Bal).getkarakterek()[0];
		System.out.println("ssssssssssssssss");
		uj.lep(Irany.Bal);
		System.out.println("void<--");
		
	}

}
