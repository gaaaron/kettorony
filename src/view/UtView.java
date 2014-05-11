package view;

import java.awt.Color;
import java.awt.Graphics;

import szoftlab4.Ut;

//Az Ut osztályhoz tartozó View osztály
public class UtView implements BaseView {

	private Ut ut;
	Color color;
	
//Az osztály publikus konstruktora, ahol beállítjuk az Út színét, és azt az utat amihez tartozunk.
	public UtView(Ut u){
		ut = u;
		Drawables.getInstance().add(this);
		color = new Color(139, 69, 19);
	}

//Ha az út állapotában változás történik, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
	}

//Itt rajzoljuk ki az utat
	public void paint() {
		int x = ut.getCoord().x;
		int y = ut.getCoord().y;
		Graphics g = Drawables.getInstance().getGraphics();
		
		g.setColor(color);
		g.fillRect(x*70, y*70, 70, 70);
	}
	
}
