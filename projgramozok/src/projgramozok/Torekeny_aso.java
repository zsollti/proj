package projgramozok;

public class Torekeny_aso extends Lapat{
	private int hasznalat;
	
	public Torekeny_aso() {
		this.hasznalat = 3;
	}
	@Override
	public void hasznal(Karakter k) {
		super.hasznal(k);
		hasznalat--;
	}
}
