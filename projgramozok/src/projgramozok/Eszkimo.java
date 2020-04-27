package projgramozok;


//Az eszkimók megvalósítása
public class Eszkimo extends Karakter{

	/**
	 * @param t A kezdõtábla
	 */
	public Eszkimo(Tabla t) {
		super(t);		
		hopont = 5;
	}
	
	/**Eszkimó képesség, iglut épít a táblára amin áll.
	 *
	 */
	@Override
	public void kepesseg() {
		this.tabla.setMenedek(new Iglu(this.tabla));
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

	@Override
	public void setMunka(int i) {
		if (i > 4) i=4;
		munka = i;
	}

	@Override
	public void setHopont(int i) {
		if (i>5) i = 5;
		hopont = i;
	}

}
