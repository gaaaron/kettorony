package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Kod;

//A ködhöz tartozó View osztály
public class KodView implements BaseView {

	private Kod kod;
	
//Az osztály publikus konstruktora. Beállítjuk hogy melyik ködhöz tartozunk, és meghívjuk a notifyChanged metódust.
	public KodView(Kod k){
		kod = k;
		notifyChanged();
	}
	
//Ha az út állapotában változás történik, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		
		if (kod.getTorony() != null) Drawables.getInstance().add(this);	
		
		
	}

//Itt rajzoljuk ki az ködöt
	public void paint() {
		int x = kod.getTorony().getSajatMezo().getCoord().x;
		int y = kod.getTorony().getSajatMezo().getCoord().y;
		Image image = new ImageIcon("img/kod.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);

		
	}
	

}
