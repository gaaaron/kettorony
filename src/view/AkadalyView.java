package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Akadaly;

public class AkadalyView implements BaseView {

	private Akadaly akadaly;
	
	public AkadalyView(Akadaly a) {
		akadaly = a;
		notifyChanged();
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}

	public void paint() {
		int x = akadaly.getSajatUt().getCoord().x;
		int y = akadaly.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/akadaly.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
	}

}
