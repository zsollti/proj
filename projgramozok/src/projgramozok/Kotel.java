package projgramozok;

public class Kotel extends Targy{

	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.getTabla().getszomszed(Irany.Bal).getkarakterek()[0].lep(k.tabla);
		System.out.println("void<--");
		
	}

}
