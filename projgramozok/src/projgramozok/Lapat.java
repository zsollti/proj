package projgramozok;


//A lap�t megval�s�t�sa
public class Lapat extends Targy{

	
	//A lap�t haszn�lata, egyszeri hazsn�lattal 2 havat lap�tol el.
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
