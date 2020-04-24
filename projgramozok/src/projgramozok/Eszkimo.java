package projgramozok;


//Az eszkkim�k megval�s�t�sa
public class Eszkimo extends Karakter{

	/**
	 * @param t A kezd�t�bla
	 */
	public Eszkimo(Tabla t) {
		super(t);		
	}
	
	/**Eszkim� k�pess�g, iglut �p�t a t�bl�ra amin �ll.
	 *
	 */
	@Override
	public void kepesseg() {
		this.tabla.setMenedek(new Iglu(this.tabla));
		this.munkavegzes();
		System.out.println("Iglu fel�p�tve");
	}

	/**Az eszkim� h�pontj�t n�veli max 5-ig, vagy cs�kkenti.
	 *Ha null�ra cs�kken a j�t�k v�get �r.
	 *@param i mennyivel n�j�n a h�pontja (lehet negat�v)
	 */
	@Override
	public void addhopont(int i) {		
		hopont += i;
		if(hopont > 5)hopont = 5;
		else if(hopont < 1)Palya.gameover(this);
		System.out.println(hopont);
	}

}
