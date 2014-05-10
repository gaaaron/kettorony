package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Torony;

public class ToronyView implements BaseView {
	
	private Torony torony;
	
	public ToronyView(Torony t) {
		torony = t;
		notifyChanged();
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}

	public void paint() {
		int x = torony.getSajatMezo().getCoord().x;
		int y = torony.getSajatMezo().getCoord().y;
		Image image = new ImageIcon("img/torony.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}

}
