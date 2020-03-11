package projgramozok;

public class Sarkkutato extends Karakter{

	@Override
	public void kepesseg() {
		//irany?????
		Tabla szomszed = this.tabla.getszomszed(Irany.Bal);
		int birokepesseg = szomszed.getbirokepesseg();
	}

	@Override
	public void addhopont(int i) {
		if(this.hopont + i > 4)
			return;
		
		this.hopont = this.hopont + i;
		
		//if(this.hopont <= 0 )
		//	palya.gameover(this);?????
		
	}

}
