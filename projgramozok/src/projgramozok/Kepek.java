package projgramozok;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Kepek {
	
	private static HashMap<String, Image> kepek = new HashMap<String, Image>();
	
	
	public static void create(){
		String[] fileok = {"aktualis_eszkimo","aktualis_sarkkutato","alkatresz","atfordult_tabla",
							"buvarruha","elelem","eszkimo","felallitott_sator","iglu","kotel","lapat",
							"lyuk","medve","sarkkutato","sator","tabla","tablahoval","torekeny_lapat"};
		Image i = null;
		File f = new File("");
		
		for(int j = 0; j < fileok.length; j++) {
			i = null;
			f = new File("");
			f = new File(f.getAbsolutePath() + "\\Kepek\\" + fileok[j] + ".png");
			try {
				i = ImageIO.read(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			kepek.put(fileok[j], i);
		}
		
	}
	
	public static Image getImage(String s) {
		return kepek.get(s);
	}
	
	public static void rajzol(String s, int x, int y) {
		Graphics g = Vezerlo.nezet.bi.getGraphics();
		g.drawImage(Kepek.getImage(s), x, y, null);
		ImageIcon icon = new ImageIcon(Vezerlo.nezet.bi);
		Vezerlo.nezet.label.setIcon(icon);
	}
}
