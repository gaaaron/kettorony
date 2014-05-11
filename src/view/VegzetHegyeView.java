package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import szoftlab4.VegzetHegye;

//Osztály, ami a Végzet hegyének kirajzolásáért felelõs
public class VegzetHegyeView implements BaseView {

	VegzetHegye vegzetHegye;
	
//Az osztály publikus konstruktora
	public VegzetHegyeView(VegzetHegye vH){
		vegzetHegye = vH;
		notifyChanged();
	}
	
//Ha a Végzet hegyének állapota módosul, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}

//A végzet hegye kirajzolását végezzük itt el az elõre beállított koordinátákra.
	public void paint() {
		int x = vegzetHegye.getSajatUt().getCoord().x;
		int y = vegzetHegye.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/hegy.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.drawString(String.format("%4d", vegzetHegye.elet), x*70, y*70+12);
		
		// life bar a vézet hegyének
		g.setColor(Color.white);
		g.fillRect(x*70+11, y*70+55, 50, 5);
		g.setColor(Color.red);
		double lifebar =((double)vegzetHegye.elet/(double)300)*(double)50;
		g.fillRect(x*70+11, y*70+55, (int) lifebar , 4);
		g.setColor(Color.white); // fehér alapszín visszaállítása
	}

}
