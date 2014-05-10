package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Kod;

public class KodView implements BaseView {

	private Kod kod;
	
	public KodView(Kod k){
		kod = k;
		notifyChanged();
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		
		if (kod.getTorony() != null) Drawables.getInstance().add(this);	
		
		
	}

	
	public void paint() {
		int x = kod.getTorony().getSajatMezo().getCoord().x;
		int y = kod.getTorony().getSajatMezo().getCoord().y;
		Image image = new ImageIcon("img/kod.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);

		
	}
	

}
