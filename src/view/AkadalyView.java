package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Akadaly;


//Az akadály osztályhoz tartozó View osztály, ami a kirajzolásáért felel.
public class AkadalyView implements BaseView {

	private Akadaly akadaly;

//Az osztály publikus konstruktora
	public AkadalyView(Akadaly a) {
		akadaly = a;
		notifyChanged();
	}
	
//Ez a függvény hívódik akkor, hogyha az akadály objektum állapotában változás történik
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}

//Az akadály kirajzolását megvalósító függvény
//Megnézi, hogy milyen koordinátákra kell rajzolnia, és betölti, majd kirajzolja az akadály képét
	public void paint() {
		int x = akadaly.getSajatUt().getCoord().x;
		int y = akadaly.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/akadaly.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}

}
