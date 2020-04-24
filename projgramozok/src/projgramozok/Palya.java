package projgramozok;

import java.util.List;
import java.util.Random;

public class Palya {
	private boolean gover = false;
	private int jatekosok;
	private List<Tabla> tablak;
	private List<Szereplo> szereplok;    
	
	
	//A P�lya oszt�ly konstruktora
	//Jelenleg a p�lya 1 t�bl�b�l �ll amin 1 eszkim� van
	
	public Palya(int jatekosok) {  
		
	}
	
	public void gameover(Szereplo k){
		if(k == null) System.out.println("Victory!!!!!");
		else {
			int i = szereplok.indexOf(k);
			System.out.println("A " + i + ". j�t�kos meghalt");
		}
		gover = true;
	}
	
	
	public void start() {
		while(!gover) {
			int r = new Random().nextInt(3);
			if(r == 1) hovihar();
			for(int i = 0; i < jatekosok; i++) {
				szereplok.get(i).korkezd();
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
	
	public boolean vizsgal(Karakter k){
		 if(k.getTabla().getSzereplok().size() == jatekosok) {
			 return true;
		 }
		 return false;
	}
	
}
