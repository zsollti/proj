package projgramozok;

/**Iglu mened�k, az eszkim� tudja l�trehozni. V�d a h�vihart�l �s a medv�t�l.
 *Egy t�bla mened�ke, ami nem semmis�l meg.
 */
public class Iglu extends Menedek{
	
	
	public Iglu (Tabla t) {
		super(t);
	}
	
	/**Nem lehet megsemmis�teni, �gy ez �res.
	 * 
	 */
	@Override
	public void destroy() {
		
	}
}
