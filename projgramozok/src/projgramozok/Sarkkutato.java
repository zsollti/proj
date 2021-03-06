package projgramozok;

/**
 *A sarkkutat� oszt�ly megval��t�sa
 */
public class Sarkkutato extends Karakter{
	
	/**
	 * Konstruktor
	 * @param t a kezd�t�bla
	 */
	public Sarkkutato(Tabla t) {
		super(t);
		hopont = 4;
	}

	/**
	 *Sarkkutat� k�pess�ge, lek�rdezi a param�terk�nt kapott t�bla karakterb�r� k�pess�g�t, ha az a t�bla szomsz�dja a saj�tj�nak.
	 *@param t A lek�rdezend� t�bla
	 */
	@Override
	public void kepesseg(Tabla t) {
		
		if(tabla.szomszede(t)) {
			int birokepesseg = t.getbirokepesseg();
			munkavegzes();
			if (birokepesseg >= 0)Kiiro.Kiir("A szomsz�dos t�bla b�r�k�pess�ge:" + birokepesseg);
			else Kiiro.Kiir("A szomsz�dos t�bla stabil");
		}
	}

	/**A sarkkutat� h�pontj�t n�veli max 4-ig, vagy cs�kkenti.
	 *Ha null�ra cs�kken a j�t�k v�get �r.
	 *@param i mennyivel n�j�n a h�pontja (lehet negat�v)
	 */
	@Override
	public void addhopont(int i) {	
		Kiiro.Kiir("A r�gi h�pont: " + hopont);
		hopont += i;
		if(hopont > 4) hopont = 4;
		if(hopont < 1) {
			Palya.gameover(this);
			Kiiro.Kiir("Megfagyott.");
		}
		else Kiiro.Kiir("Az aktu�lis h�pont: " + hopont);
		Vezerlo.hopont.setText("H�pont: " + hopont);

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
	 *Set f�ggv�ny a h�pont �rt�k�nek be�ll�t�s�ra. Max 4.
	 *@param i-re �ll�tja a h�pontj�t ha az kisebb mint 5.
	 */
	@Override
	public void setHopont(int i) {
		if (i > 4) i=4;
		hopont = i;
	}
	
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		xpos = xpos + Palya.szereplok.indexOf(this)%3 * 40;
		ypos = ypos + Palya.szereplok.indexOf(this)/3 * 40;
		if(aktualis)
			Kepek.rajzol("aktualis_sarkkutato", xpos, ypos);
		else Kepek.rajzol("sarkkutato", xpos, ypos);
	}
	
	
}
