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
		 * K�t beolvas� scanner, az egyik a konzolos, a m�sik f�jlb�l t�rt�n� beolvas�shoz
		 */
		/*
		Scanner sc = new Scanner(System.in);
		Scanner fr = null;

		while(true) {	//addig fut a program, m�g ki nem l�p�nk, vagy esetleges hib�t nem kapunk
			Kiiro.Kiir("V�laszd ki a futtatni k�v�nt cselekv�st.\n");
			Kiiro.Kiir("jatekBetolt [fajln�v]: Mentett j�t�k bet�lt�se");
			Kiiro.Kiir("jatekBetolt: �j j�t�k kezd�se");
			Kiiro.Kiir("testBeolvas [f�jlnn�v]: Teszteset beolvas�sa f�jlb�l �s futtat�sa");
			Kiiro.Kiir("kilep: Kil�p�s");
			
			s = sc.nextLine();
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
				case "jatekBetolt":	//p�lya bet�lt�se
					if(ss.length == 2) {	//megl�v� mentett j�t�k�llapot bet�lt�se
						p = new Palya(ss[1]);
						p.start(sc);
					} else {	//egy �j j�t�k bet�lt�se a megadott j�t�kossz�mmal
						Kiiro.Kiir("H�ny j�t�kos legyen?");
						int n = sc.nextInt();
						p = new Palya(n, "uj.txt");
						p.start(sc);
					}
					break;
				case "testBeolvas":	//teszt bet�lt�se
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
				case "kilep":	//kil�p�s
					sc.close();
					System.exit(0);
					break;
				default:  
					Kiiro.Kiir("Rossz bemenet. Adjon meg �jat");
				break;
				
			}
		}*/
	}
}
