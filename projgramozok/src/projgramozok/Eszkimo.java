package projgramozok;

public class Eszkimo extends Karakter{

	@Override
	public void kepesseg() {
		this.tabla.setiglu();
	}

	@Override
	public void addhopont(int i) {
		if(this.hopont + i > 5)
			return;
		
		this.hopont = this.hopont + i;
		
		//if(this.hopont <= 0 )
		//	palya.gameover(this);?????
	
	}

}
