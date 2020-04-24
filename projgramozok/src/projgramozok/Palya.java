package projgramozok;

import java.util.List;

public class Palya {
	private int jatekosok;
	private List<Tabla> tablak;
	private Szereplo[] szereplok;    
	
	
	//A Pálya osztály konstruktora
	//Jelenleg a pálya 1 táblából áll amin 1 eszkimó van
	
	public Palya(int jatekosok) {  
		
	}
	
	public void gameover(Szereplo k)
	{
		System.out.println("-->gameover(k)");
		
		System.out.println("void<--");
	}
	
	
	public void start(int jatekosok) {
		szereplok[1] = new Eszkimo(tablak[0][0]);
		tablak[0][0].ralep(szereplok[1]);
		int kor=0;
		System.out.println("-->start(j)");
		for(int i = 0; i < jatekosok; i++) {
			szereplok[i].korkezd();
			if(i == (jatekosok-1)) {i = 0; kor++;}
			if(kor > 2) {gameover(null); i = 2;}
		}
		System.out.println("void<..");
	}
	
	public void hovihar()
	{
		System.out.println("-->hovihar()");
		tablak[0][0].addhomennyiseg(1);
		System.out.println("void<--");
		
	}
	
	public void vizsgal(Karakter[] karakterek)
	{
		
	}
	
}
