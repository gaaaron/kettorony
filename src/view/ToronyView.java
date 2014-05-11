package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Torony;


//A Torony oszt�lyhoz tartoz� View oszt�ly
public class ToronyView implements BaseView {
	
	private Torony torony;
	
//Az oszt�ly publikus konstruktora, ahol be�ll�tjuk a hozz� tartoz� tornyot, �s megh�vjuk a notifyChanged f�ggv�nyt.
	public ToronyView(Torony t) {
		torony = t;
		notifyChanged();
	}
	
//Ha az Torony �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
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
