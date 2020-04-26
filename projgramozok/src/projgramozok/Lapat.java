package projgramozok;


//A lapát megvalósítása
public class Lapat extends Targy{

	
	//A lapát használata, egyszeri hazsnálattal 2 havat lapátol el.
	@Override
	public void hasznal(Karakter k) {
		Kiiro.Kiir(getName());
		k.getTabla().addhomennyiseg(-2);
		k.munkavegzes();
	}
	public  String getName() {
		return "Lapat";
	}
}
