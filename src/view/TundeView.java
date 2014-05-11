package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Tunde;

//A Tünde nevû ellenség kirajzolását megvalósító osztály
public class TundeView implements BaseView {

	private Tunde tunde;
//Az osztály publikus konstruktora
	public TundeView(Tunde t) {
		tunde = t;
		Drawables.getInstance().add(this);
	}

	
//Ha Tünde állapotában változás történik, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(tunde.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs sajátút, akkor csak törlünk (ellenség meghalt)
	}

//Itt rajzoljuk ki Tündét
	public void paint() {
		int x = tunde.getSajatUt().getCoord().x;
		int y = tunde.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/tunde.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x * 70, y * 70, null);
		g.setFont(new Font("Arial", Font.BOLD, 9));
		g.drawString(String.format("%4d", tunde.elet), x*70, y*70+12);
	}

}
