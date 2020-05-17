package projgramozok;

/**
 *A sarkkutató osztály megvalóítása
 */
public class Sarkkutato extends Karakter{
	
	/**
	 * Konstruktor
	 * @param t a kezdõtábla
	 */
	public Sarkkutato(Tabla t) {
		super(t);
		hopont = 4;
	}

	/**
	 *Sarkkutató képessége, lekérdezi egy szomszédos tábla karakterbíró képességét.
	 */
	@Override
	public void kepesseg(Tabla t) {
		
		if(tabla.szomszede(t)) {
			int birokepesseg = t.getbirokepesseg();
			munkavegzes();
			if (birokepesseg >= 0)Kiiro.Kiir("A szomszédos tábla bíróképessége:" + birokepesseg);
			else Kiiro.Kiir("A szomszédos tábla stabil");
		}
	}

	/**A sarkkutató hõpontját növeli max 4-ig, vagy csökkenti.
	 *Ha nullára csökken a játék véget ér.
	 *@param i mennyivel nõjön a hõpontja (lehet negatív)
	 */
	@Override
	public void addhopont(int i) {	
		Kiiro.Kiir("A régi hõpont: " + hopont);
		hopont += i;
		if(hopont > 4) hopont = 4;
		if(hopont < 1) {
			Palya.gameover(this);
			Kiiro.Kiir("Megfagyott.");
		}
		else Kiiro.Kiir("Az aktuális hõpont: " + hopont);
		Vezerlo.hopont.setText("Hõpont: " + hopont);

	}
	
	/**
	 *Set függvény a munka értékének beállítására. Max 4.
	 *@param i-re állítja a munka pontját ha az kisebb mint 5.
	 */
	@Override
	public void setMunka(int i) {
		if (i > 4) i=4;
		munka = i;
	}

	/**
	 *Set függvény a hõpont értékének beállítására. Max 4.
	 *@param i-re állítja a hõpontját ha az kisebb mint 5.
	 */
	@Override
	public void setHopont(int i) {
		if (i > 4) i=4;
		hopont = i;
	}
	
	/**
	 * Rajzolófüggvény
	 * @param xpos - az x pozíciója az objektumnak
	 * @param ypos - az y pozíció
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
