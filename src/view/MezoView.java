package view;

import java.awt.Color;
import java.awt.Graphics;


import szoftlab4.Mezo;

//Az Mezo osztályhoz tartozó View osztály
public class MezoView implements BaseView {

	private Mezo mezo;
	Color color;
	
//Az osztály publikus konstruktora, ahol beállítjuk az Mezõ színét, és azt az mezõt amihez tartozunk.
	public MezoView(Mezo m){
		mezo = m;
		Drawables.getInstance().add(this);
		color = new Color(0, 128, 0);
		
}
//Ha a mezõ állapotában változás történik, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);	
		
	}
	
	

//Itt rajzoljuk ki az mezõt
	public void paint() {
		int x = mezo.getCoord().x;
		int y = mezo.getCoord().y;
		Graphics g = Drawables.getInstance().getGraphics();
		
		g.setColor(color);
		g.fillRect(x*70, y*70, 70, 70);
	}
}
