package projgramozok;

public class Sator extends Targy{

	@Override
	public void hasznal(Karakter k) {
		k.getTabla().setMenedek(new Felallitott_sator(k.getTabla()));
		k.munkavegzes();
		
	}

}
