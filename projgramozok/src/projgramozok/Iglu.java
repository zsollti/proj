package projgramozok;

/**Iglu mened�k, az eszkim� tudja l�trehozni. V�d a h�vihart�l �s a medv�t�l.
 *Egy t�bla mened�ke, ami nem semmis�l meg.
 */
public class Iglu extends Menedek{
	
	/**
	 *Konstruktor
	 *@param t A t�bla ahova fel�l�tjuk az iglut
	 */
	public Iglu (Tabla t) {
		super(t);
	}
	
	/**Nem lehet megsemmis�teni, �gy ez �res.
	 * 
	 */
	@Override
	public void destroy() {
		
	}
	
	/**
	 * Rajzol�f�ggv�ny
	 * @param xpos - az x poz�ci�ja az objektumnak
	 * @param ypos - az y poz�ci�
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("iglu", xpos, ypos-25);
	}
}
