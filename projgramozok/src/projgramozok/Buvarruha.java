package projgramozok;


//A b�v�rruha megval�s�t�sa
public class Buvarruha extends Targy{

	//A b�v�rruha haszn�lata, a param�terk�nt kapott karaktert eg m�sik t�bl�ra l�pteti.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("\t-->hasznal(k)");
		//k.lep(Irany.Bal);
		System.out.println("\tvoid<--");
		
	}

}
