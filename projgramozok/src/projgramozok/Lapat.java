package projgramozok;

public class Lapat extends Targy{

	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.getTabla().addhomennyiseg(-2);
		System.out.println("void<--");
	}

}
