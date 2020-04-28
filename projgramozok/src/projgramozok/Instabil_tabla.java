package projgramozok;

import java.util.Random;



/**
 *Instabil táblák megvalósítása.
 */
public class Instabil_tabla extends Tabla{
	
	/**
	 *A tábla karakterbíró képességét tárolja.
	 */
	private int birokepesseg;
	
	/**
	 * Paraméter nélküli konstruktor.
	 * Random bíróképességet állít be magának.(6 és 1 között)
	 */
	public Instabil_tabla() {
		super();
		birokepesseg = new Random().nextInt(5) +1;
	}
	
	/**
	 * Paraméteres konstruktor.
	 * @param ho: A táblán elhelyezkedõ hó ennyisége.
	 * @param fordult: A tábla átfordult állapota.
	 * @param bir: A tábla bíróképessége.
	 */
	public Instabil_tabla(int ho, boolean fordult, int bir) {
		super(ho, fordult);
		birokepesseg = bir;
	}
	
	/**
	 * A paraméterként kapott szereplõt a sajátjaihoz adja.
	 * @param k: A szereplõ aki rálép a táblára.
	 */
	@Override
	public void ralep(Szereplo k)
	{
		szereplok.add(k);
		k.setTabla(this);
		if(atfordul) k.beleesik();
		else if(szereplok.size() > birokepesseg) {
			atfordul = true;
			Kiiro.Kiir("Atfordult!");
			for(Szereplo sz : szereplok) {
				sz.beleesik();
			}
		}
		szereplok.get(0).utkozik(k);
	}
	
	/**
	 * Eltávolítja a paraméterként kapott szereplõt a sajátjai közül.
	 * @param k: A szereplõ aki lelép a tábláról.
	 */
	public void lelep(Szereplo k) {
		this.szereplok.remove(k);
		if(szereplok.size() == 0) {
			atfordul = false;
		}
	}
	
	/**
	 * Megadja a tábla karakterbíró képességét.
	 */
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
