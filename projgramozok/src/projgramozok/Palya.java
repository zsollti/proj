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
	 *v�ge van-e m�r a j�t�knak
	 */
	static boolean gover = false;
	
	/**
	 *a j�t�kosok sz�ma
	 */
	static int jatekosok;	
	
	/**
	 * a p�ly�n l�v� t�bl�k
	 */
	static List<Tabla> tablak = new ArrayList<Tabla>();		
	
	/**
	 * a p�ly�n l�v� szerepl�k
	 */
	static List<Szereplo> szereplok = new ArrayList<Szereplo>();		
	
	/**
	 * err�l a szkennerr�l v�rja a bemeneteket, lehet f�jl vagy standard bemenet
	 */
	static Scanner sc = null;
	
	/**
	 * randoms�g be van-e kapcsolva, true: be van kapcsolva
	 */
	static boolean random = true;		
	
	static Vezerlo vezerlo;
	/**�j p�lya l�trehoz�sa eset�n vissza�ll�tja a statikus
	 * v�ltoz�kat kezd��llapotba
	 */
	private void reset() {
		gover = false;
		tablak = new ArrayList<Tabla>();
		szereplok = new ArrayList<Szereplo>();
		random = true;
		sc = null;
	}
	
	
	/**A p�lya konstruktora, amely �j j�t�kot kezd a param�terk�nt kapott p�ly�n
	 * @param jatekosszam a j�t�kosok sz�ma, amennyit l�trehoz az �j p�ly�n
	 * @param p a f�jl neve, amelyben a p�lya tal�lhat�.
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
			
			for(int i = 0; i < line.length(); i++) {		//A f�jl els� sor�ban vannak felsorolva a t�bl�k t�pusai
				if(line.charAt(i) == 't') {					//ezek alapj�n t�lti fel a tablak-at
					tablak.add(new Tabla());				
				} else if(line.charAt(i) == 'i') {
					tablak.add(new Instabil_tabla());
				} else if(line.charAt(i) == 'l') {
					tablak.add(new Lyuk());
				}
			}
			
			int row = 0;
			while ((line = br.readLine()) != null) {			//A szomsz�doss�gi m�trix alapj�n be�ll�tja
				for(int i = 0; i < line.length(); i++) {		//az �sszes t�bla szomsz�djait
					if(line.charAt(i) == '1') {
						tablak.get(row).szomszed.add(tablak.get(i));
					}
				}
				row ++;
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			Kiiro.Kiir("Nem l�tezik a f�jl.");
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
		
	/*	for(int i = 0; i < jatekosok; i++) {							//A standard bemenetr�l bek�ri az �sszes j�t�kost�l, hogy
			Kiiro.Kiir("Eszkim�(1) vagy sarkkutat�(2) akarsz lenni?");	//milyen t�pus� karakter szeretne lenni, majd ezek alapj�n
			int ered = sc.nextInt();									//felveszi a megfelel� karaktereket
			while(ered != 1 && ered != 2) {
				ered = sc.nextInt();
			}
			if(ered == 1) szereplok.add(new Eszkimo(tablak.get(0)));		//Az �sszes karakter ugyanarr�l a p�ly�r�l indul
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
		szereplok.add(new Medve(tablak.get(r)));				//A medv�t pedig egy m�sik random t�bl�ra helyezi
		List<Targy> targyak = new ArrayList<Targy>();
		
		for(int i = 0; i < 3; i++) {					//Mindegy t�rgyb�l hoz l�tre legal�bb egyet, hogy
			targyak.add(new Alkatresz());				//mindenf�le t�rgyat tudjanak haszn�lni
		}
		targyak.add(new Buvarruha());
		targyak.add(new Torekeny_aso());
		targyak.add(new Kotel());
		targyak.add(new Lapat());
		targyak.add(new Sator());
		for(int i = 0; i < 3; i++) {
			targyak.add(new Elelem());
		}
		
		for(int i = 0; i < targyak.size(); i++) {			//A t�rgyakat elhelyezi a t�bl�kon �gy, hogy lyukba nem tesz �s
			r = new Random().nextInt(tablak.size());		//minden t�bl�n maximum 1 t�rgy lehet
			while(tablak.get(r).getbirokepesseg() == 0 || tablak.get(r).targy != null) {
				r = new Random().nextInt(tablak.size());
			}
			tablak.get(r).targy = targyak.get(i);
		}
	}
	
	/**Az adott f�jlb�l teljesen fel�p�t egy p�ly�t karakterekkel t�bl�kkal,
	 * h�val minden tulajdons�ggal egy�tt
	 * @param filename a f�jl neve, amelyikben a p�lya tal�lhat�
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
				
				for(int k = 1; k < tablatulajdonsag.length; k++) {				//El�sz�r kiolvassa a f�jlb�l a t�bl�k adatait, hogy
					if(k == 1) {												//l�trehoz�sukkor ezeket r�gt�n be tudja �ll�tani
						ho = Integer.parseInt(tablatulajdonsag[k]);
					}
					else if(k == 2) {
						if(Integer.parseInt(tablatulajdonsag[k]) == 0)fordult = false;
						else fordult = true;
					}
				}
				
				for(int i = 0; i < dolgok.length; i++) {
									
					switch(i) {
					
						case 0:												//Itt veszi fel a megfelel� t�pus� t�bl�kat
							if(dolgok[i].charAt(0) == 't') {				//a megfelel� tulajdons�gokkal
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
							
						case 1:																//A soron k�vetkez� t�bl�ra elhelyezi a 
								if(tablatulajdonsag[0].charAt(0) == 'i') {					//megfelel� mened�ket
									tablak.get(row).setMenedek(new Iglu(tablak.get(row)));
								}
								else if(tablatulajdonsag[0].charAt(0) == 's') {
									tablak.get(row).setMenedek(new Felallitott_sator(tablak.get(row)));
								}
								
								switch(tablatulajdonsag[3]) {							//A t�bl�ba elhelyezi az ott tal�lhat� t�rgyat
								
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
								for(int b = 0; b < karaktertul.length; b++) { 			//Az �sszes a soron k�vetkez� t�bl�n l�v� megfelel� t�pus�
									if(b == 0) {										//karaktelt elhelyezi a t�bl�n, �s jegyzi a j�t�kosok sz�m�t
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
									else if(b == 1) {										//A feltett karakterek h�pontjait �s munk�j�t is be�ll�tja
										szereplok.get(szereplok.size() - 1).setHopont(Integer.parseInt(karaktertul[b].substring(0)));
									}
									else if(b == 2) {
										szereplok.get(szereplok.size() - 1).setMunka(Integer.parseInt(karaktertul[b].substring(0)));
									}
									else{
										switch(karaktertul[b]) {						//Minden karakter eset�ben felveszi a r�rgyai k�z� a 
																						//megfelel� t�pus� t�rgyakat, ha vannak neki
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
			while ((line = br.readLine()) != null) {			//Miut�n l�trehozta a t�bl�kat rajta a karakterekkel, a t�bl�k
				for(int i = 0; i < line.length(); i++) {		//k�z�tti kapcsolatokat is fel�p�ti a szomsz�doss�gi m�trix alapj�n
					if(line.charAt(i) == '1') {
						tablak.get(row).szomszed.add(tablak.get(i));
					}
				}
				row ++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {					
			Kiiro.Kiir("Nem l�tezik a f�jl.");
		} catch (IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException n) {
			Kiiro.Kiir("Nem j� a form�tum");
		}catch(NullPointerException nu) {
			Kiiro.Kiir("Nem j� a form�tum");
		}catch(ArrayIndexOutOfBoundsException ae) {
			Kiiro.Kiir("Nem j� a form�tum");
		}catch(IndexOutOfBoundsException i) {
			Kiiro.Kiir("Nem j� a form�tum");
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
	
	/**A j�t�k v�gekor h�v�dik, ha �ssze pr�b�lj�k szerelni a rak�ta alkatr�szeit
	 * vagy valaki meghalt, mert v�zbe fulladt, megfagyott vagy tal�lkozott a medv�vel
	 * @param k a karakter, aki meghalt, ha null azt jelenti, hogy megnyert�k
	 */
	public static void gameover(Szereplo k){
		if(k == null) { 
			Kiiro.Kiir("Victory!!!!!");
			vezerlo.vege("Victory!!");
			}
		else {
			int i = szereplok.indexOf(k) + 1;
			Kiiro.Kiir("A " + i + ". j�t�kos meghalt");
			vezerlo.vege("A " + i + ". j�t�kos meghalt");
		}
		//gover = true;
	}
	
	
	/**Ez a f�ggv�ny fut a j�t�k sor�n folyamatosan, az egyes
	 * k�r�k elej�n vagy h�v h�vihart vagy nem, majd
	 * sorba h�vogatja a szerepl�k korkezd-j�t, am�g v�ge nincs a j�t�knak valamilyen okb�l
	 * @param sc a scanner, amir�l v�rja a bemenetet
	 */
	public void start() {
		/*Kiiro.Kiir("random: h�vihar �s medve randoms�g�nak kikapcsol�sa");		//A j�t�k kezdetekor t�j�koztatja a j�t�kost, hogy
		String s = sc.nextLine();												//milyen cselekv�seket v�gezhet a j�t�k sor�n
		if(s.equals("random")) random = false;
		Kiiro.Kiir("Valaszd ki a kivant cselekvest.\n");
		Kiiro.Kiir("lep [t�bla indexe/ szama]");
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

	/**Minden k�r elej�n h�v�dhat, a randoms�gt�l f�gg�en
	 * vagy random t�bl�kra vagy mindig a p�ratlan sorsz�m�kra
	 * tesz plusz egy r�teg havat
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
	
	/**Ha megvan mindh�rom rak�ta alkatr�sz �s �ssze pr�b�lj�k szerelni,
	 * akkor ellen�rzi, hogy minden karakter ugyanazon a t�bl�n van-e
	 * @param k a karakter, aki a f�ggv�ny h�vja, �gy csak az � t�bl�j�t kell ellen�rizni
	 * @return true:ugyanazon a t�bl�n vannak, false:nem
	 */
	public static boolean vizsgal(Karakter k){
		 if(k.getTabla().getSzereplok().size() == jatekosok) {
			 return true;
		 }
		 return false;
	}
	
}
