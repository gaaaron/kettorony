package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.VegzetHegye;

public class VegzetHegyeView implements BaseView {

	VegzetHegye vegzetHegye;
	
	public VegzetHegyeView(VegzetHegye vH){
		vegzetHegye = vH;
		notifyChanged();
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}

	@Override
	public void paint() {
		int x = vegzetHegye.getSajatUt().getCoord().x;
		int y = vegzetHegye.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/hegy.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}

}
