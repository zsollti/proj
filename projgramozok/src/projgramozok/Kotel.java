package projgramozok;


//A k�t�l megval�s�t�sa
public class Kotel extends Targy{

	//A k�t�l haszn�lata, a haszn�l� t�bl�j�ra l�pteti egy szomsz�dos t�bla karaktereit.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		for(Szereplo sz : k.getTabla().getszomszed(Irany.Bal).getkarakterek()) {
			sz.lep(k.getTabla());
		}
		
		System.out.println("void<--");
		
	}

}
