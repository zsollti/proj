package projgramozok;

import java.io.FileWriter;
import java.io.IOException;

public class Kiiro {
	private static boolean Konzolra = true;
	private static FileWriter file = null;
	
	public static void Kiir(String s) {
		if(Konzolra) {
			System.out.println(s);
		}
		if(file != null) {
			try {
				file.write(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void Kiir(int i) {
		Kiir(Integer.toString(i));
	}
	
	public static void setFile(String s) {
		try {
			file = new FileWriter(s);
		} catch (IOException e) {
			System.out.println("a fájl nem található (kiiró)");
		}
	}
}
