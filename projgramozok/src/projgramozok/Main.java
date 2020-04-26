package projgramozok;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Palya p;
		
		String s = "";
		Scanner sc = new Scanner(System.in);

		
		while(true) {
			Kiiro.Kiir("Válaszd ki a futtatni kívánt cselekvést.\n");
			Kiiro.Kiir("jatekBetolt [fajlnév]: Mentett játék betöltése");
			Kiiro.Kiir("jatekBetolt: Új játék kezdése");
			Kiiro.Kiir("testBeolvas [fájlnnév]: Teszteset beolvasása fájlból és futtatása");
			Kiiro.Kiir("kilep: Kilépés");
			
			s = sc.nextLine();
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
				case "jatekBetolt":
					if(ss.length == 2) {
						p = new Palya(ss[1]);
						p.start(sc);
					} else {
						Kiiro.Kiir("Hány játékos legyen?");
						int n = sc.nextInt();
						p = new Palya(n, "uj.txt");
						p.start(sc);
					}
					break;
				case "testBeolvas":
				try {
					String string = "Tesztek/"+ss[1];
					Scanner fr = new Scanner(new FileReader(string));
					Kiiro.setFile(string + "_kimenet.txt"); //test kiírása fáljba
					String ts = fr.nextLine();
					String[] tss = ts.split(" ");
					p = new Palya(tss[1]);
					p.start(fr);
				} catch (FileNotFoundException e) {
					Kiiro.Kiir("A fajl nem talalhato");
					break;
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
					break;
				case "kilep":
					sc.close();
					System.exit(0);
					break;
				default:  
					Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
				break;
				
			}
		}
	}
}
