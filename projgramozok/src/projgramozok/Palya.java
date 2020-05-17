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
	/**
	 *vége van-e már a játéknak
	 */
	static boolean gover = false;
	
	/**
	 *a játékosok száma
	 */
	static int jatekosok;	
	
	/**
	 * a pályán lévõ táblák
	 */
	static List<Tabla> tablak = new ArrayList<Tabla>();		
	
	/**
	 * a pályán lévõ szereplõk
	 */
	static List<Szereplo> szereplok = new ArrayList<Szereplo>();		
	
	/**
	 * errõl a szkennerrõl várja a bemeneteket, lehet fájl vagy standard bemenet
	 */
	static Scanner sc = null;
	
	/**
	 * randomság be van-e kapcsolva, true: be van kapcsolva
	 */
	static boolean random = true;		
	
	static Vezerlo vezerlo;
	/**Új pálya létrehozása esetén visszaállítja a statikus
	 * változókat kezdõállapotba
	 */
	private void reset() {
		gover = false;
		tablak = new ArrayList<Tabla>();
		szereplok = new ArrayList<Szereplo>();
		random = true;
		sc = null;
	}
	
	
	/**A pálya konstruktora, amely új játékot kezd a paraméterként kapott pályán
	 * @param jatekosszam a játékosok száma, amennyit létrehoz az új pályán
	 * @param p a fájl neve, amelyben a pálya található.
	 */
	public Palya(int sark, int eszk, String p) { 
		reset();
		jatekosok = sark + eszk;
		BufferedReader br = null;
		try {
			String s = "Tesztek/"+p;
			br = new BufferedReader(new FileReader(s));
			String line;
			line = br.readLine();
			
			for(int i = 0; i < line.length(); i++) {		//A fájl elsõ sorában vannak felsorolva a táblák típusai
				if(line.charAt(i) == 't') {					//ezek alapján tölti fel a tablak-at
					tablak.add(new Tabla());				
				} else if(line.charAt(i) == 'i') {
					tablak.add(new Instabil_tabla());
				} else if(line.charAt(i) == 'l') {
					tablak.add(new Lyuk());
				}
			}
			
			int row = 0;
			while ((line = br.readLine()) != null) {			//A szomszédossági mátrix alapján beállítja
				for(int i = 0; i < line.length(); i++) {		//az összes tábla szomszédjait
					if(line.charAt(i) == '1') {
						tablak.get(row).szomszed.add(tablak.get(i));
					}
				}
				row ++;
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			Kiiro.Kiir("Nem létezik a fájl.");
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
		
	/*	for(int i = 0; i < jatekosok; i++) {							//A standard bemenetrõl bekéri az összes játékostól, hogy
			Kiiro.Kiir("Eszkimó(1) vagy sarkkutató(2) akarsz lenni?");	//milyen típusú karakter szeretne lenni, majd ezek alapján
			int ered = sc.nextInt();									//felveszi a megfelelõ karaktereket
			while(ered != 1 && ered != 2) {
				ered = sc.nextInt();
			}
			if(ered == 1) szereplok.add(new Eszkimo(tablak.get(0)));		//Az összes karakter ugyanarról a pályáról indul
			else if(ered == 2) szereplok.add(new Sarkkutato(tablak.get(0)));
		}*/
		
		for(int i = 0; i < sark; i++) {
			szereplok.add(new Sarkkutato(tablak.get(0)));
		}
		for(int i = 0; i < eszk; i++) {
			szereplok.add(new Eszkimo(tablak.get(0)));
		}
		
		
		int r = 0;
		while(r == 0) {
			r = new Random().nextInt(tablak.size());
			if(tablak.get(0).szomszede(tablak.get(r)))
				r = 0;
		}
		szereplok.add(new Medve(tablak.get(r)));				//A medvét pedig egy másik random táblára helyezi
		List<Targy> targyak = new ArrayList<Targy>();
		
		for(int i = 0; i < 3; i++) {					//Mindegy tárgyból hoz létre legalább egyet, hogy
			targyak.add(new Alkatresz());				//mindenféle tárgyat tudjanak használni
		}
		targyak.add(new Buvarruha());
		targyak.add(new Torekeny_aso());
		targyak.add(new Kotel());
		targyak.add(new Lapat());
		targyak.add(new Sator());
		for(int i = 0; i < 3; i++) {
			targyak.add(new Elelem());
		}
		
		for(int i = 0; i < targyak.size(); i++) {			//A tárgyakat elhelyezi a táblákon úgy, hogy lyukba nem tesz és
			r = new Random().nextInt(tablak.size());		//minden táblán maximum 1 tárgy lehet
			while(tablak.get(r).getbirokepesseg() == 0 || tablak.get(r).targy != null) {
				r = new Random().nextInt(tablak.size());
			}
			tablak.get(r).targy = targyak.get(i);
		}
	}
	
	/**Az adott fájlból teljesen felépít egy pályát karakterekkel táblákkal,
	 * hóval minden tulajdonsággal együtt
	 * @param filename a fájl neve, amelyikben a pálya található
	 */
	public Palya(String filename) {
		reset();
		jatekosok = 0;
		int ho = 0;
		boolean fordult = false;
		BufferedReader br = null;
		String pl = "Tesztek/"+filename;
		
		try {
			br = new BufferedReader(new FileReader(pl));
			String line;
			
			int row = 0;
			while ((line = br.readLine()) != null && line.charAt(0) != 'p') {
				
				String[] dolgok = line.split(",");
				String[] tablatulajdonsag = dolgok[1].split(" ");
				
				for(int k = 1; k < tablatulajdonsag.length; k++) {				//Elõször kiolvassa a fájlból a táblák adatait, hogy
					if(k == 1) {												//létrehozásukkor ezeket rögtön be tudja állítani
						ho = Integer.parseInt(tablatulajdonsag[k]);
					}
					else if(k == 2) {
						if(Integer.parseInt(tablatulajdonsag[k]) == 0)fordult = false;
						else fordult = true;
					}
				}
				
				for(int i = 0; i < dolgok.length; i++) {
									
					switch(i) {
					
						case 0:												//Itt veszi fel a megfelelõ típusú táblákat
							if(dolgok[i].charAt(0) == 't') {				//a megfelelõ tulajdonságokkal
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
							
						case 1:																//A soron következõ táblára elhelyezi a 
								if(tablatulajdonsag[0].charAt(0) == 'i') {					//megfelelõ menedéket
									tablak.get(row).setMenedek(new Iglu(tablak.get(row)));
								}
								else if(tablatulajdonsag[0].charAt(0) == 's') {
									tablak.get(row).setMenedek(new Felallitott_sator(tablak.get(row)));
								}
								
								switch(tablatulajdonsag[3]) {							//A táblába elhelyezi az ott található tárgyat
								
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
								for(int b = 0; b < karaktertul.length; b++) { 			//Az összes a soron következõ táblán lévõ megfelelõ típusú
									if(b == 0) {										//karaktelt elhelyezi a táblán, és jegyzi a játékosok számát
										if(karaktertul[b].charAt(0) == 'e') {
											szereplok.add(new Eszkimo(tablak.get(row)));
											jatekosok++;
										}
										else if(karaktertul[b].charAt(0) == 's') {
											szereplok.add(new Sarkkutato(tablak.get(row)));
											jatekosok++;
										}
										else if(karaktertul[b].charAt(0) == 'm') {
											szereplok.add(new Medve(tablak.get(row)));
											break;
										}
									}
									else if(b == 1) {										//A feltett karakterek hõpontjait és munkáját is beállítja
										szereplok.get(szereplok.size() - 1).setHopont(Integer.parseInt(karaktertul[b].substring(0)));
									}
									else if(b == 2) {
										szereplok.get(szereplok.size() - 1).setMunka(Integer.parseInt(karaktertul[b].substring(0)));
									}
									else{
										switch(karaktertul[b]) {						//Minden karakter esetében felveszi a rárgyai közé a 
																						//megfelelõ típusú tárgyakat, ha vannak neki
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
			while ((line = br.readLine()) != null) {			//Miután létrehozta a táblákat rajta a karakterekkel, a táblák
				for(int i = 0; i < line.length(); i++) {		//közötti kapcsolatokat is felépíti a szomszédossági mátrix alapján
					if(line.charAt(i) == '1') {
						tablak.get(row).szomszed.add(tablak.get(i));
					}
				}
				row ++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {					
			Kiiro.Kiir("Nem létezik a fájl.");
		} catch (IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException n) {
			Kiiro.Kiir("Nem jó a formátum");
		}catch(NullPointerException nu) {
			Kiiro.Kiir("Nem jó a formátum");
		}catch(ArrayIndexOutOfBoundsException ae) {
			Kiiro.Kiir("Nem jó a formátum");
		}catch(IndexOutOfBoundsException i) {
			Kiiro.Kiir("Nem jó a formátum");
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
	
	/**A játék végekor hívódik, ha össze próbálják szerelni a rakéta alkatrészeit
	 * vagy valaki meghalt, mert vízbe fulladt, megfagyott vagy találkozott a medvével
	 * @param k a karakter, aki meghalt, ha null azt jelenti, hogy megnyerték
	 */
	public static void gameover(Szereplo k){
		if(k == null) { 
			Kiiro.Kiir("Victory!!!!!");
			vezerlo.vege("Victory!!");
			}
		else {
			int i = szereplok.indexOf(k) + 1;
			Kiiro.Kiir("A " + i + ". játékos meghalt");
			vezerlo.vege("A " + i + ". játékos meghalt");
		}
		//gover = true;
	}
	
	
	/**Ez a függvény fut a játék során folyamatosan, az egyes
	 * körök elején vagy hív hóvihart vagy nem, majd
	 * sorba hívogatja a szereplõk korkezd-jét, amíg vége nincs a játéknak valamilyen okból
	 * @param sc a scanner, amirõl várja a bemenetet
	 */
	public void start() {
		/*Kiiro.Kiir("random: hóvihar és medve randomságának kikapcsolása");		//A játék kezdetekor tájékoztatja a játékost, hogy
		String s = sc.nextLine();												//milyen cselekvéseket végezhet a játék során
		if(s.equals("random")) random = false;
		Kiiro.Kiir("Valaszd ki a kivant cselekvest.\n");
		Kiiro.Kiir("lep [tábla indexe/ szama]");
		Kiiro.Kiir("targykias");
		Kiiro.Kiir("targyhasznal - nalad levo targyak kiirasa es onnan valasztas annak nevevel");
		Kiiro.Kiir("kepesseg");
		Kiiro.Kiir("hoasas - kezzel");
		Kiiro.Kiir("endTurn - kor befejezese");
		Kiiro.Kiir("kilep - jatek befejezese");*/
		
			int r = new Random().nextInt(3);
			if(!random) r = 1;
			if(r == 1) {
				Kiiro.Kiir("hovihar");
				hovihar();
			}
			for(Tabla t : tablak) {
				t.setMenedek(null);
			}
			
	//	Kiiro.Kiir("Jatek vege.");
	}

	/**Minden kör elején hívódhat, a randomságtól függõen
	 * vagy random táblákra vagy mindig a páratlan sorszámúkra
	 * tesz plusz egy réteg havat
	 */
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
	
	/**Ha megvan mindhárom rakéta alkatrész és össze próbálják szerelni,
	 * akkor ellenõrzi, hogy minden karakter ugyanazon a táblán van-e
	 * @param k a karakter, aki a függvény hívja, így csak az õ tábláját kell ellenõrizni
	 * @return true:ugyanazon a táblán vannak, false:nem
	 */
	public static boolean vizsgal(Karakter k){
		 if(k.getTabla().getSzereplok().size() == jatekosok) {
			 return true;
		 }
		 return false;
	}
	
}
