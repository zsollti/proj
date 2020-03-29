package projgramozok;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String s = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Válaszd ki a futtatni kívánt cselekvést.\n");
		System.out.println("1.: Játékos körei egymás után");
		System.out.println("2.: Hóvihar");
		System.out.println("3.: Lépés");
		System.out.println("4.: Sarkkutató képessége");
		System.out.println("5.: Eszkimó képessége");
		System.out.println("6.: Tárgy felvétel");
		System.out.println("7.: Evés");
		System.out.println("8.: Lapátolás");
		System.out.println("9.: Társ kimentése");
		System.out.println("10.: Búvárruha használata");
		
		while(true) {
			
			s = sc.next();
			
			switch(s) {
				case "1":	//Játékos körei egyás után
					System.out.println("1.: Játékosok körei egymás után két körön keresztül, majd game over\n");
					Palya palya1 = new Palya(2);
					palya1.start(2);
					break;
					
				case "2":	//Hóvihar
					System.out.println("2.: Hóvihar\n");
					Palya palya2 = new Palya(1);
					palya2.hovihar();
					break;
					
				case "3":	//Lépés
					System.out.println("3.: Lépés\n");
					System.out.println("A játékost elbírja a tábla amire lép? (Igen-> i, Nem-> n)");
					
					if(sc.next().equals("n")) {
						Tabla idelep = new Tabla();
						Lyuk lyuk3 = new Lyuk(idelep);
						Tabla tabla3_1 = new Tabla(lyuk3);
						Eszkimo eszkimo3 = new Eszkimo(tabla3_1);
						eszkimo3.lep(Irany.Bal);
					}
					else {
						Tabla tabla3_2 = new Tabla();
						Tabla tabla3_3 = new Tabla(tabla3_2);
						Eszkimo eszkimo3 = new Eszkimo(tabla3_3);
						eszkimo3.lep(Irany.Bal);
					}
					break;
					
				case "4":	//Sarkkutató képessége
					System.out.println("4.: Sarkkutató képessége\n");
					Tabla tabla4_1 = new Tabla();
					Tabla tabla4_2 = new Tabla(tabla4_1);
					Sarkkutato sarkkutato4 = new Sarkkutato(tabla4_2);
					sarkkutato4.kepesseg();
					break;
					
				case "5":	//Eszkimó képessége
					System.out.println("5.: Eszkimó képessége\n");
					Tabla tabla5 = new Tabla();
					Eszkimo eszkimo5 = new Eszkimo(tabla5);
					eszkimo5.kepesseg();
					break;
					
				case "6":	//Tárgy felvétele
					System.out.println("6.: Tárgy felvétel\n");
					Tabla tabla6 = new Tabla();
					Eszkimo eszkimo6 = new Eszkimo(tabla6);
					tabla6.targykias(eszkimo6);
					break;
					
				case "7":	//Evés
					System.out.println("7.: Evés\n");
					Elelem elelem7 = new Elelem();
					Tabla tabla7 = new Tabla();
					Eszkimo eszkimo7 = new Eszkimo(tabla7);
					elelem7.hasznal(eszkimo7);
					break;
					
				case "8":	//Lapátolás
					System.out.println("8.: Lapátolás\n");
					Lapat lapat8 = new Lapat();
					Tabla tabla8 = new Tabla();
					Eszkimo eszkimo8 = new Eszkimo(tabla8);
					lapat8.hasznal(eszkimo8);
					break;
					
				case "9":	//Társ kimentése
					System.out.println("9.: Társ kimentése\n");
					Kotel kotel9 = new Kotel();
					Tabla tabla9_1 = new Tabla();
					Tabla tabla9_2 = new Tabla(tabla9_1);
					Sarkkutato sarkkutato9 = new Sarkkutato(tabla9_2);
					Eszkimo eszkimo9 = new Eszkimo(tabla9_1);
					tabla9_1.ralep(eszkimo9);
					kotel9.hasznal(sarkkutato9);
					break;
					
				case "10":	//Búvárruha használata
					System.out.println("10.: Búvárruha használata\n");
					Tabla tabla10 = new Tabla();
					Tabla tabla10_2 = new Tabla(tabla10);
					Eszkimo eszkimo10 = new Eszkimo(tabla10_2);
					eszkimo10.beleesik();
					break;
				
				default:  
					System.out.println("A tesztelés befejezõdöt.");
					sc.close(); 
					System.exit(0);
				break;
				
			}
		}
	}
}
