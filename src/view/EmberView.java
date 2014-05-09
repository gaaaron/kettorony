package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Ember;

public class EmberView implements BaseView {

	private Ember ember;
	
	public EmberView(Ember e){
		ember = e;
		Drawables.getInstance().add(this);
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(ember.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs sajátút, akkor csak törlünk (ellenség meghalt)
	}

	@Override
	public void paint() {
		int x = ember.getSajatUt().getCoord().x;
		int y = ember.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/ember.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}
	
	

	
}
