package projgramozok;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Palya {
	private static boolean gover = false;
	private static int jatekosok;
	private List<Tabla> tablak;
	private static List<Szereplo> szereplok;
	Scanner sc;
	
	
	//A Pálya osztály konstruktora
	//Jelenleg a pálya 1 táblából áll amin 1 eszkimó van
	
	public Palya(int jatekosok, String p) {  
		//táblák és hó
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(p));
			String line;
			line = br.readLine();
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == 't') {
					tablak.add(new Tabla(this));
				} else if(line.charAt(i) == 'i') {
					tablak.add(new Instabil_tabla(this));
				} else if(line.charAt(i) == 'l') {
					tablak.add(new Lyuk(this));
				}
			}
			int row = 0;
			while ((line = br.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					if(line.charAt(i) == '1') {
						tablak.get(row).szomszed.add(tablak.get(i));
					}
				}
				row ++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nem létezik a fájl.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		sc = new Scanner(System.in);
		szereplok = new ArrayList<Szereplo>();
		for(int i = 0; i < jatekosok; i++) {
			System.out.println("Eszkimó(1) vagy sarkkutató(2) akarsz lenni?");
			int ered = sc.nextInt();
			while(ered != 1 && ered != 2) {
				ered = sc.nextInt();
			}
			if(ered == 1) szereplok.add(new Eszkimo(tablak.get(0)));
			else if(ered == 2) szereplok.add(new Sarkkutato(tablak.get(0)));
		}
		int r = 0;
		while(r == 0) {
			r = new Random().nextInt(tablak.size());
		}
		szereplok.add(new Medve(tablak.get(r)));
		//tárgyak
		List<Targy> targyak = new ArrayList<Targy>();
		for(int i = 0; i < 3; i++) {
			targyak.add(new Alkatresz());
		}
		targyak.add(new Buvarruha());
		targyak.add(new Torekeny_aso());
		targyak.add(new Kotel());
		targyak.add(new Lapat());
		targyak.add(new Sator());
		for(int i = 0; i < 3; i++) {
			targyak.add(new Elelem());
		}
		for(int i = 0; i < targyak.size(); i++) {
			r = new Random().nextInt(tablak.size());
			while(tablak.get(r).getbirokepesseg() == 0 || tablak.get(r).targy != null) {
				r = new Random().nextInt(tablak.size());
			}
			tablak.get(r).targy = targyak.get(i);
		}
	}
	
	public Palya(String mentett) {
		
	}
	
	public static void gameover(Szereplo k){
		if(k == null) System.out.println("Victory!!!!!");
		else {
			int i = szereplok.indexOf(k);
			System.out.println("A " + i + ". játékos meghalt");
		}
		gover = true;
	}
	
	
	public void start(Scanner sc) {
		while(!gover) {
			int r = new Random().nextInt(3);
			if(r == 1) hovihar();
			for(int i = 0; i < jatekosok; i++) {
				szereplok.get(i).korkezd(sc);
				if(gover) break;
			}
		}
	}

	public void hovihar(){
		for(Tabla t: tablak) {
			int r = new Random().nextInt(3);
			if(r == 1) t.addhomennyiseg(1);
		}
	}
	
	public static boolean vizsgal(Karakter k){
		 if(k.getTabla().getSzereplok().size() == jatekosok) {
			 return true;
		 }
		 return false;
	}
	
}
