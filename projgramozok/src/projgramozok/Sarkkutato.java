package projgramozok;


//A sarkkutató megvalóítása
public class Sarkkutato extends Karakter{
	
	/**
	 * @param t a kezdõtábla
	 */
	public Sarkkutato(Tabla t) {
		super(t);
		hopont = 4;
	}

	/**Sarkkutató képessége, lekérdezi egy szomszédos tábla karakterbíró képességét.
	 *
	 */
	@Override
	public void kepesseg() {
		int birokepesseg = tabla.szomszed.get(0).getbirokepesseg();
		munkavegzes();
		Kiiro.Kiir(birokepesseg);
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
		Kiiro.Kiir(hopont);
	}

	@Override
	public void setMunka(int i) {
		if (i > 4) i=4;
		munka = i;
	}

	@Override
	public void setHopont(int i) {
		if (i > 4) i=4;
		hopont = i;
	}

}
