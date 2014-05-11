package view;

import java.awt.Color;
import java.awt.Graphics;


import szoftlab4.Mezo;

//Az Mezo oszt�lyhoz tartoz� View oszt�ly
public class MezoView implements BaseView {

	private Mezo mezo;
	Color color;
	
//Az oszt�ly publikus konstruktora, ahol be�ll�tjuk az Mez� sz�n�t, �s azt az mez�t amihez tartozunk.
	public MezoView(Mezo m){
		mezo = m;
		Drawables.getInstance().add(this);
		color = new Color(0, 128, 0);
		
}
//Ha a mez� �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);	
		
	}
	
	

//Itt rajzoljuk ki az mez�t
	public void paint() {
		int x = mezo.getCoord().x;
		int y = mezo.getCoord().y;
		Graphics g = Drawables.getInstance().getGraphics();
		
		g.setColor(color);
		g.fillRect(x*70, y*70, 70, 70);
	}
}
