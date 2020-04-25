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
			System.out.println("Válaszd ki a futtatni kívánt cselekvést.\n");
			System.out.println("jatekBetolt [fajlnév]: Mentett játék betöltése");
			System.out.println("jatekBetolt: Új játék kezdése");
			System.out.println("testBeolvas [fájlnnév]: Teszteset beolvasása fájlból és futtatása");
			System.out.println("kilep: Teszteset beolvasása fájlból és futtatása");
			
			s = sc.nextLine();
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
				case "jatekBetolt":
					if(ss.length == 2) {
						p = new Palya(ss[1]);
						p.start(sc);
					} else {
						System.out.println("Hány játékos legyen?");
						int n = sc.nextInt();
						p = new Palya(n, "uj.txt");
						p.start(sc);
					}
					break;
				case "testBeolvas":
				try {
					Scanner fr = new Scanner(new FileReader(ss[1]));
					String ts = fr.nextLine();
					String[] tss = ts.split(" ");
					p = new Palya(tss[1]);
					p.start(fr);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
					break;
				case "kilep":
					sc.close();
					System.exit(0);
					break;
				default:  
					System.out.println("Rossz bemenet. Adjon meg újat");
				break;
				
			}
		}
	}
}
