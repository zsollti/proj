package projgramozok;


//A k�t�l megval�s�t�sa
public class Kotel extends Targy{

	//A k�t�l haszn�lata, a haszn�l� t�bl�j�ra l�pteti egy szomsz�dos t�bla karaktereit.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.getTabla().getszomszed(Irany.Bal).getkarakterek()[0].lep(k.tabla);
		System.out.println("void<--");
		
	}

}
