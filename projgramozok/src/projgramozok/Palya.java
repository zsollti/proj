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
	private static List<Tabla> tablak = new ArrayList<Tabla>();
	private static List<Szereplo> szereplok = new ArrayList<Szereplo>();
	Scanner sc;
	static boolean random = true;
	
	//A Pálya osztály konstruktora
	
	public Palya(int jatekosok, String p) {  
		//táblák és hó
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(p));
			String line;
			line = br.readLine();
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == 't') {
					tablak.add(new Tabla());
				} else if(line.charAt(i) == 'i') {
					tablak.add(new Instabil_tabla());
				} else if(line.charAt(i) == 'l') {
					tablak.add(new Lyuk());
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
		//tÃ¡rgyak
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
	
	public Palya(String filename) {
		int ho = 0;
		boolean fordult = false;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filename));
			String line;
			
			int row = 0;
			while ((line = br.readLine()) != null && line.charAt(0) != 'p') {
				
				String[] dolgok = line.split(",");
				String[] tul = dolgok[1].split(" ");
				
				for(int k = 1; k < tul.length; k++) {
					if(k == 1) {
						ho = Integer.parseInt(tul[k]);
					}
					else if(k == 2) {
						if(Integer.parseInt(tul[k]) == 0)fordult = false;
						else fordult = true;
					}
				}
				
				for(int i = 0; i < dolgok.length; i++) {
									
					switch(i) {
					
						case 0:
							if(dolgok[i].charAt(0) == 't') {
								tablak.add(new Tabla(ho, fordult));
							}
							else if(dolgok[i].charAt(0) == 'i') {
								int bir = Integer.parseInt(dolgok[i].substring(2));
								tablak.add(new Instabil_tabla(ho, fordult, bir));
							}
							else {
								tablak.add(new Lyuk(ho, fordult));
							}
							break;
							
						case 1:
								if(tul[0].charAt(0) == 'i') {
									tablak.get(row).setMenedek(new Iglu(tablak.get(row)));
								}
								else if(tul[0].charAt(0) == 's') {
									tablak.get(row).setMenedek(new Felallitott_sator(tablak.get(row)));
								}
								
								switch(tul[3]) {
								
									case "alkatresz":
										tablak.get(row).targy = new Alkatresz();
										break;
										
						        	case "elelem":
						        		tablak.get(row).targy = new Elelem();
						        		break;
						        		
						        	case "sator":
						        		tablak.get(row).targy = new Sator();
						        		break;
						        		
						        	case "lapat":
						        		tablak.get(row).targy = new Lapat();
						        		break;
						        		
						        	case "kotel":
						        		tablak.get(row).targy = new Kotel();
						        		break;
						        		
						        	case "torekeny_aso":
						        		tablak.get(row).targy = new Torekeny_aso();
						        		break;
						        		
						        	case "buvarruha":
						        		tablak.get(row).targy = new Buvarruha();
						        		break;
						        	default:
						        		tablak.get(row).targy = null;
						        		break;
						        	}
						break;
						
						case 2:
							String[] k = dolgok[2].split(";");
							for(int a = 0; a < k.length; a++) {
								
								String[] karaktertul = k[a].split(" ");
								for(int b = 0; b < karaktertul.length; b++) {
									if(b == 0) {
										if(karaktertul[b].charAt(0) == 'e')szereplok.add(new Eszkimo(tablak.get(row)));
										else if(karaktertul[b].charAt(0) == 's')szereplok.add(new Sarkkutato(tablak.get(row)));
										else if(karaktertul[b].charAt(0) == 'm') {
											szereplok.add(new Medve(tablak.get(row)));
											break;
										}
									}
									else{
										switch(karaktertul[b]) {
										
										case "alkatresz":
											szereplok.get(a).addTargy(new Alkatresz());
											break;
											
							        	case "elelem":
							        		szereplok.get(a).addTargy(new Elelem());
							        		break;
							        		
							        	case "sator":
							        		szereplok.get(a).addTargy(new Sator());
							        		break;
							        		
							        	case "lapat":
							        		szereplok.get(a).addTargy(new Lapat());
							        		break;
							        		
							        	case "kotel":
							        		szereplok.get(a).addTargy(new Kotel());
							        		break;
							        		
							        	case "torekeny_aso":
							        		szereplok.get(a).addTargy(new Torekeny_aso());
							        		break;
							        		
							        	case "buvarruha":
							        		szereplok.get(a).addTargy(new Buvarruha());
							        		break;
							        	default: break;
							        	}	
									}
								}
							}
				}		
			}
				row++;
					
		}
			row = 0;
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
		}catch(NumberFormatException n) {
			System.out.println("Nem jó a formátum");
		}catch(NullPointerException nu) {
			System.out.println("Nem jó a formátum");
		}
		finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}
	
	public static void gameover(Szereplo k){
		if(k == null) System.out.println("Victory!!!!!");
		else {
			int i = szereplok.indexOf(k);
			System.out.println("A " + i + ". jÃ¡tÃ©kos meghalt");
		}
		gover = true;
	}
	
	
	public void start(Scanner sc) {
		int i = 0;
		System.out.println("random: hóvihar és medve randomságának kikapcsolása");
		String s = sc.nextLine();
		if(s.equals("random")) random = false;
		while(!gover) {
			int r = new Random().nextInt(3);
			if(!random) r = 1;
			if(r == 1) hovihar();
			for(Tabla t : tablak) {
				t.setMenedek(null);
			}
			while(i < szereplok.size()) {
				szereplok.get(i).korkezd(sc);
				if(gover) break;
				i++;
			}
			i = 0;
		}
	}

	public void hovihar(){
		if(random) {
			for(Tabla t: tablak) {
				int r = new Random().nextInt(3);
				if(r == 1) t.addhomennyiseg(1);
			}
		}
		else {
			for(Tabla t : tablak) {
				if(tablak.indexOf(t) % 2 == 1) t.addhomennyiseg(1);
			}
		}
	}
	
	public static boolean vizsgal(Karakter k){
		 if(k.getTabla().getSzereplok().size() == jatekosok) {
			 return true;
		 }
		 return false;
	}
	
	public static Tabla gettabla(int i){
		return tablak.get(i);
	}
	
}
