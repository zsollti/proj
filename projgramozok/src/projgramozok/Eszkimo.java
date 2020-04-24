package projgramozok;


//Az eszkkimók megvalósítása
public class Eszkimo extends Karakter{

	/**
	 * @param t A kezdõtábla
	 */
	public Eszkimo(Tabla t) {
		super(t);		
	}
	
	/**Eszkimó képesség, iglut épít a táblára amin áll.
	 *
	 */
	@Override
	public void kepesseg() {
		this.tabla.setMenedek(new Iglu(this.tabla));
		this.munkavegzes();
		System.out.println("Iglu felépítve");
	}

	/**Az eszkimó hõpontját növeli max 5-ig, vagy csökkenti.
	 *Ha nullára csökken a játék véget ér.
	 *@param i mennyivel nõjön a hõpontja (lehet negatív)
	 */
	@Override
	public void addhopont(int i) {		
		hopont += i;
		if(hopont > 5)hopont = 5;
		else if(hopont < 1)Palya.gameover(this);
		System.out.println(hopont);
	}

}
