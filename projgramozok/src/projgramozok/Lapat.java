package projgramozok;


//A lapát megvalósítása
public class Lapat extends Targy{

	
	//A lapát használata, egyszeri hazsnálattal 2 havat lapátol el.
	@Override
	public void hasznal(Karakter k) {
		System.out.println("-->hasznal(k)");
		k.getTabla().addhomennyiseg(-2);
		k.munkavegzes();
		System.out.println("void<--");
	}
	public  String getName() {
		return "Lapat";
	}
}
