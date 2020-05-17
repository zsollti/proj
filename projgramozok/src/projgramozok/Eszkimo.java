package projgramozok;

/**
 *Az eszkimó osztály megvalósítása
 */
public class Eszkimo extends Karakter{

	/**
	 * @param t A kezdõtábla
	 */
	public Eszkimo(Tabla t) {
		super(t);		
		hopont = 5;
	}
	
	/**
	 *Eszkimó képesség, iglut épít a táblára amin áll.
	 */
	@Override
	public void kepesseg(Tabla t) {
		t.setMenedek(new Iglu(this.tabla));
		this.munkavegzes();
		Kiiro.Kiir("Iglu felépítve");
	}

	/**Az eszkimó hõpontját növeli max 5-ig, vagy csökkenti.
	 *Ha nullára csökken a játék véget ér.
	 *@param i mennyivel nõjön a hõpontja (lehet negatív)
	 */
	@Override
	public void addhopont(int i) {	
		Kiiro.Kiir("A régi hõpont: " + hopont);
		hopont += i;
		if(hopont > 5)hopont = 5;
		if(hopont < 1) {
			Palya.gameover(this);
			Kiiro.Kiir("Megfagyott.");
		}
		else Kiiro.Kiir("Az aktuális hõpont: " + hopont);
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
	 *Set függvény a hõpont értékének beállítására. Max 5.
	 *@param i-re állítja a hõpontját ha az kisebb mint 5.
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
