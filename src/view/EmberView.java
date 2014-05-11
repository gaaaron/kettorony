package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Ember;

//Az Ember nev� ellens�g kirajzol�s�t megval�s�t� oszt�ly
public class EmberView implements BaseView {

	private Ember ember;
	
//Az oszt�ly publikus konstruktora
	public EmberView(Ember e){
		ember = e;
		Drawables.getInstance().add(this);
	}
	
//Ha az Ember �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(ember.getSajatUt() != null)
			Drawables.getInstance().add(this); //ha nincs saj�t�t, akkor csak t�rl�nk (ellens�g meghalt)
	}

//Itt rajzoljuk ki az Embert
	public void paint() {
		int x = ember.getSajatUt().getCoord().x;
		int y = ember.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/ember.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}
	
	

	
}
