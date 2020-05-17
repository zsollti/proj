package projgramozok;

/**Sátor osztály, ebbõl lehet felállított sátor objektumot létrehozni.
 *
 */
public class Sator extends Targy{

	/**Sátor használata
	 *@param k Az õ tábláján fog megépülni a felállított sátor
	 *egy munkavégzésbe kerül
	 */
	@Override
	public void hasznal(Karakter k) {
		k.getTabla().setMenedek(new Felallitott_sator(k.getTabla()));
		k.munkavegzes();
		k.targyak.get(getName()).remove(this);
		Kiiro.Kiir(getName() + " felépítve");
	}
	
	/**
	 *Visszatér az osztály nevével.
	 */
	public  String getName() {
		return "Sator";
	}
	
	/**
	 *Kirajzolja az objektumot
	 */
	@Override
	public void rajzol(int xpos, int ypos) {
		Kepek.rajzol("sator", xpos+75, ypos+75);
	}
}
