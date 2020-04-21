package projgramozok;


//A kötél megvalósítása
public class Kotel extends Targy{

	//A kötél használata, a használó táblájára lépteti egy szomszédos tábla karaktereit.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		for(Szereplo sz : k.getTabla().getszomszed(Irany.Bal).getkarakterek()) {
			sz.lep(k.getTabla());
		}
		
		System.out.println("void<--");
		
	}

}
