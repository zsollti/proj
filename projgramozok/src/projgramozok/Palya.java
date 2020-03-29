package projgramozok;


public class Palya {
	private int jatekosok;
	private Tabla[][] tablak;
	private Karakter[] karakterek;    //Mindhárom protected volt, de inkább private kéne, nem?
	
	
	//A Pálya osztály konstruktora
	//Jelenleg a pálya 1 táblából áll amin 1 eszkimó van
	
	public Palya(int jatekosok) {  
		this.jatekosok = jatekosok;
		tablak = new Tabla[1][1];
		tablak[0][0] = new Tabla();
		karakterek = new Karakter[1];
		karakterek[0] = new Eszkimo(tablak[0][0]);
		tablak[0][0].ralep(karakterek[0]);
		
	}
	
	public void gameover(Karakter k)
	{
		System.out.println("-->gameover(k)");
		
		System.out.println("void<--");
	}
	
	
	public void start(int jatekosok) {
		System.out.println("-->start(j)");
		karakterek[0].korkezd();
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
