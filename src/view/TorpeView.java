package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Torpe;

//Az T�rpe oszt�lyhoz tartoz� View oszt�ly
public class TorpeView implements BaseView {

	private Torpe torpe;
	
//Az oszt�ly publikus konstruktora, ahol be�ll�tjuk hogy melyik t�rp�hez tartozik ez a View oszt�ly
	public TorpeView(Torpe t){
		torpe = t;
		Drawables.getInstance().add(this);
		}
		
	
//Ha a t�rpe �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
		public void notifyChanged() {
			Drawables.getInstance().remove(this);
			if(torpe.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs saj�t�t, akkor csak t�rl�nk (ellens�g meghalt)
		}

//Itt rajzoljuk ki az t�rp�t
		public void paint() {
			int x = torpe.getSajatUt().getCoord().x;
			int y = torpe.getSajatUt().getCoord().y;
			Image image = new ImageIcon("img/torp.png").getImage();
			Graphics g = Drawables.getInstance().getGraphics();
			g.drawImage(image, x*70, y*70, null);
		}
}
