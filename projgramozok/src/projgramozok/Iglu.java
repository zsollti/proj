package projgramozok;

//Az iglu oszt�ly megval�s�t�sa
public class Iglu extends Menedek{
	
	
	public Iglu (Tabla t) {
		super(t);
	}
	
	//Iglut nem lehet megsemmis�teni, ez�rt ez a f�ggv�ny �res.
	@Override
	public void destroy() {
		
	}
}
