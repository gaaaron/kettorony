package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Torpe;

//Az Törpe osztályhoz tartozó View osztály
public class TorpeView implements BaseView {

	private Torpe torpe;
	
//Az osztály publikus konstruktora, ahol beállítjuk hogy melyik törpéhez tartozik ez a View osztály
	public TorpeView(Torpe t){
		torpe = t;
		Drawables.getInstance().add(this);
		}
		
	
//Ha a törpe állapotában változás történik, ez a függvény hívódik meg
		public void notifyChanged() {
			Drawables.getInstance().remove(this);
			if(torpe.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs sajátút, akkor csak törlünk (ellenség meghalt)
		}

//Itt rajzoljuk ki az törpét
		public void paint() {
			int x = torpe.getSajatUt().getCoord().x;
			int y = torpe.getSajatUt().getCoord().y;
			Image image = new ImageIcon("img/torp.png").getImage();
			Graphics g = Drawables.getInstance().getGraphics();
			g.drawImage(image, x*70, y*70, null);
		}
}
