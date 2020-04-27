package projgramozok;

import java.util.Random;

//Instabil t�bl�k egval�s�t�sa.
public class Instabil_tabla extends Tabla{
	
	private int birokepesseg;
	
	//Param�terk�nt kapott karaktert elt�rolja a saj�tjai k�zt.
	//Ha t�bben vannak rajta mint amennyit elb�r akkor a t�bla �tfordul.
	public Instabil_tabla() {
		super();
		birokepesseg = new Random().nextInt(5) +1;
	}
	
	public Instabil_tabla(int ho, boolean fordult, int bir) {
		super(ho, fordult);
		birokepesseg = bir;
	}
	
	//A param�terk�nt kapott szerepl�t a sj�tjaihoz adja.
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
	
	//Elt�vol�tja a param�terk�nt kapott karaktert a saj�tjai k�z�l.
		public void lelep(Szereplo k) {
			this.szereplok.remove(k);
			if(szereplok.size() == 0) {
				atfordul = false;
			}
		}
	
	//Megadja a t�bla karakter b�r� k�pess�g�t.
	@Override
	public int getbirokepesseg()
	{
		return birokepesseg;
	}
}
