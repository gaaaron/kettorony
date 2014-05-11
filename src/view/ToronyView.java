package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Torony;


//A Torony osztályhoz tartozó View osztály
public class ToronyView implements BaseView {
	
	private Torony torony;
	
//Az osztály publikus konstruktora, ahol beállítjuk a hozzá tartozó tornyot, és meghívjuk a notifyChanged függvényt.
	public ToronyView(Torony t) {
		torony = t;
		notifyChanged();
	}
	
//Ha az Torony állapotában változás történik, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}
	//Itt rajzoljuk ki a tornyot
	public void paint() {
		int x = torony.getSajatMezo().getCoord().x;
		int y = torony.getSajatMezo().getCoord().y;
		Image image = new ImageIcon("img/torony.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}

}
