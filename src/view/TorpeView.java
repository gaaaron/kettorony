package view;

import java.awt.Color;
import java.awt.Font;
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
			g.setFont(new Font("Arial", Font.BOLD, 9));
			g.drawString(String.format("%4d", torpe.elet), x*70, y*70+12);
			
			// life-bar a törpének
			g.setColor(Color.white);
			g.fillRect(x*70+0, y*70, 50, 5);
			g.setColor(Color.green);
			double lifebar =((double)torpe.elet/(double)200)*(double)50;
			g.fillRect(x*70+0, y*70, (int) lifebar , 4);
			g.setColor(Color.white); // fehér alapszín visszaállítása
		}
}
