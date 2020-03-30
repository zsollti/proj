package projgramozok;


//A kötél megvalósítása
public class Kotel extends Targy{

	//A kötél használata, a használó táblájára lépteti egy szomszédos tábla karaktereit.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.getTabla().getszomszed(Irany.Bal).getkarakterek()[0].lep(k.tabla);
		System.out.println("void<--");
		
	}

}
