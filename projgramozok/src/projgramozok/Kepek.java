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
		Image i = null;
		File f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\alkatresz.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i.getScaledInstance(30, 30, Image.SCALE_FAST);
		kepek.put("alkatresz", i);
		
		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\atfordult_tabla.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("atfordult_tabla", i);
		
		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\buvarruha.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("buvarruha", i);
		
		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\elelem.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("elelem", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\eszkimo.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i = i.getScaledInstance(33, 33, Image.SCALE_FAST);
		kepek.put("eszkimo", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\felallitott_sator.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("felallitott_sator", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\iglu.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("iglu", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\kotel.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("kotel", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\lapat.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("lapat", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\lyuk.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("lyuk", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\medve.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("medve", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\sarkkutato.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("sarkkutato", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\sator.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("sator", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\tabla.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("tabla", i);

		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\tablahoval.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("tablahoval", i);
		
		i = null;
		f = new File("");
		f = new File(f.getAbsolutePath() + "\\Kepek\\torekeny_lapat.png");
		try {
			i = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kepek.put("torekeny_lapat", i);
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
