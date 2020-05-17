package projgramozok;

/**
 *Az eszkim� oszt�ly megval�s�t�sa
 */
public class Eszkimo extends Karakter{

	/**
	 * @param t A kezd�t�bla
	 */
	public Eszkimo(Tabla t) {
		super(t);		
		hopont = 5;
	}
	
	/**
	 *Eszkim� k�pess�g, iglut �p�t a t�bl�ra amin �ll.
	 */
	@Override
	public void kepesseg(Tabla t) {
		t.setMenedek(new Iglu(this.tabla));
		this.munkavegzes();
		Kiiro.Kiir("Iglu fel�p�tve");
	}

	/**Az eszkim� h�pontj�t n�veli max 5-ig, vagy cs�kkenti.
	 *Ha null�ra cs�kken a j�t�k v�get �r.
	 *@param i mennyivel n�j�n a h�pontja (lehet negat�v)
	 */
	@Override
	public void addhopont(int i) {	
		Kiiro.Kiir("A r�gi h�pont: " + hopont);
		hopont += i;
		if(hopont > 5)hopont = 5;
		if(hopont < 1) {
			Palya.gameover(this);
			Kiiro.Kiir("Megfagyott.");
		}
		else Kiiro.Kiir("Az aktu�lis h�pont: " + hopont);
	}
	
	/**
	 *Set f�ggv�ny a munka �rt�k�nek be�ll�t�s�ra. Max 4.
	 *@param i-re �ll�tja a munka pontj�t ha az kisebb mint 5.
	 */
	@Override
	public void setMunka(int i) {
		if (i > 4) i=4;
		munka = i;
	}

	/**
	 *Set f�ggv�ny a h�pont �rt�k�nek be�ll�t�s�ra. Max 5.
	 *@param i-re �ll�tja a h�pontj�t ha az kisebb mint 5.
	 */
	@Override
	public void setHopont(int i) {
		if (i>5) i = 5;
		hopont = i;
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		xpos = xpos + Palya.szereplok.indexOf(this)%3 * 40;
		ypos = ypos + Palya.szereplok.indexOf(this)/3 * 40;
		if(aktualis)
			Kepek.rajzol("aktualis_eszkimo", xpos, ypos);
		else Kepek.rajzol("eszkimo", xpos, ypos);
	}
	
}
