package projgramozok;


public class Palya {
	protected int jatekosok;
	protected Tabla[][] tablak;
	protected Karakter[] karakterek;
	
	
	//A P�lya oszt�ly konstruktora
	//Jelenleg a p�lya 1 t�bl�b�l �ll amin 1 eszkim� van
	
	public Palya(int jatekosok) {  
		this.jatekosok = jatekosok;
		tablak = new Tabla[0][0];
		tablak[0][0] = new Tabla();
		karakterek = new Karakter[1];
		karakterek[0] = new Eszkimo(tablak[0][0]);
		tablak[0][0].ralep(karakterek[0]);
		
	}
	
	public void gameover(Karakter k)
	{
		
	}
	
	
	public void start(int jatekosok) {
		
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
