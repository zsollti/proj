package projgramozok;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		new Vezerlo();
		
		
		
		
		//Palya p;
		
		//String s = "";
		/**
		 * Két beolvasó scanner, az egyik a konzolos, a másik fájlból történõ beolvasáshoz
		 */
		/*
		Scanner sc = new Scanner(System.in);
		Scanner fr = null;

		while(true) {	//addig fut a program, míg ki nem lépünk, vagy esetleges hibát nem kapunk
			Kiiro.Kiir("Válaszd ki a futtatni kívánt cselekvést.\n");
			Kiiro.Kiir("jatekBetolt [fajlnév]: Mentett játék betöltése");
			Kiiro.Kiir("jatekBetolt: Új játék kezdése");
			Kiiro.Kiir("testBeolvas [fájlnnév]: Teszteset beolvasása fájlból és futtatása");
			Kiiro.Kiir("kilep: Kilépés");
			
			s = sc.nextLine();
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
				case "jatekBetolt":	//pálya betöltése
					if(ss.length == 2) {	//meglévõ mentett játékállapot betöltése
						p = new Palya(ss[1]);
						p.start(sc);
					} else {	//egy új játék betöltése a megadott játékosszámmal
						Kiiro.Kiir("Hány játékos legyen?");
						int n = sc.nextInt();
						p = new Palya(n, "uj.txt");
						p.start(sc);
					}
					break;
				case "testBeolvas":	//teszt betöltése
				try {
					String string = "Tesztek/"+ss[1];
					fr = new Scanner(new FileReader(string));
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
				}finally {
					if(fr != null)
					fr.close();
				}
					break;
				case "kilep":	//kilépés
					sc.close();
					System.exit(0);
					break;
				default:  
					Kiiro.Kiir("Rossz bemenet. Adjon meg újat");
				break;
				
			}
		}*/
	}
}
