package projgramozok;


//A lapát megvalósítása
public class Lapat extends Targy{

	
	//A lapát használata, egyszeri hazsnálattal 2 havat lapátol el.
	@Override
	public void hasznal(Karakter k) {
		k.getTabla().addhomennyiseg(-2);
		k.munkavegzes();
		Kiiro.Kiir(getName());
	}
	public  String getName() {
		return "Lapat";
	}
}
