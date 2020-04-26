package projgramozok;

public class Kiiro {
	private static boolean Konzolra = true;
	private static boolean Fileba = false;
	
	public static void Kiir(String s) {
		if(Konzolra) {
			System.out.println(s + "\n");
		}
		if(Fileba) {
			
		}
	}
	public static void Kiir(int i) {
		Kiir(Integer.toString(i));
	}
}
