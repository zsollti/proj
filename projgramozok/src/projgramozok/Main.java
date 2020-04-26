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
			Kiiro.Kiir("V�laszd ki a futtatni k�v�nt cselekv�st.\n");
			Kiiro.Kiir("jatekBetolt [fajln�v]: Mentett j�t�k bet�lt�se");
			Kiiro.Kiir("jatekBetolt: �j j�t�k kezd�se");
			Kiiro.Kiir("testBeolvas [f�jlnn�v]: Teszteset beolvas�sa f�jlb�l �s futtat�sa");
			Kiiro.Kiir("kilep: Kil�p�s");
			
			s = sc.nextLine();
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
				case "jatekBetolt":
					if(ss.length == 2) {
						p = new Palya(ss[1]);
						p.start(sc);
					} else {
						Kiiro.Kiir("H�ny j�t�kos legyen?");
						int n = sc.nextInt();
						p = new Palya(n, "uj.txt");
						p.start(sc);
					}
					break;
				case "testBeolvas":
				try {
					String string = "Tesztek/"+ss[1];
					Scanner fr = new Scanner(new FileReader(string));
					Kiiro.setFile(string + "_kimenet.txt"); //test ki�r�sa f�ljba
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
					Kiiro.Kiir("Rossz bemenet. Adjon meg �jat");
				break;
				
			}
		}
	}
}
