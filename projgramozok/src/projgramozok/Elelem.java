package projgramozok;


//Az �lelem megval�s�t�sa
public class Elelem extends Targy{

	//Az �lelem haszn�lata, a param�terk�nt kapott karakter h�pontj�t n�veli eggyel.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.addhopont(1);
		k.munkavegzes();
		System.out.println("void<--");
	
	}

}
