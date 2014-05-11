package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Kod;

//A k�dh�z tartoz� View oszt�ly
public class KodView implements BaseView {

	private Kod kod;
	
//Az oszt�ly publikus konstruktora. Be�ll�tjuk hogy melyik k�dh�z tartozunk, �s megh�vjuk a notifyChanged met�dust.
	public KodView(Kod k){
		kod = k;
		notifyChanged();
	}
	
//Ha az �t �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		
		if (kod.getTorony() != null) Drawables.getInstance().add(this);	
		
		
	}

//Itt rajzoljuk ki az k�d�t
	public void paint() {
		int x = kod.getTorony().getSajatMezo().getCoord().x;
		int y = kod.getTorony().getSajatMezo().getCoord().y;
		Image image = new ImageIcon("img/kod.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);

		
	}
	

}
