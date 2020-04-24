package projgramozok;


//A sarkkutató megvalóítása
public class Sarkkutato extends Karakter{
	
	/**
	 * @param t a kezdõtábla
	 */
	public Sarkkutato(Tabla t) {
		super(t);		
	}

	/**Sarkkutató képessége, lekérdezi egy szomszédos tábla karakterbíró képességét.
	 *
	 */
	@Override
	public void kepesseg() {
		int birokepesseg = tabla.szomszed.get(0).getbirokepesseg();
		munkavegzes();
		System.out.println(birokepesseg);
	}

	/**A sarkkutató hõpontját növeli max 4-ig, vagy csökkenti.
	 *Ha nullára csökken a játék véget ér.
	 *@param i mennyivel nõjön a hõpontja (lehet negatív)
	 */
	@Override
	public void addhopont(int i) {		
		hopont += i;
		if(hopont > 4) hopont = 4;
		else if(hopont < 1)Palya.gameover(this);
		System.out.println(hopont);
	}

}
