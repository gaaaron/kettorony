package view;

import java.awt.Color;
import java.awt.Graphics;


import szoftlab4.Mezo;


public class MezoView implements BaseView {

	private Mezo mezo;
	Color color;
	
	
	public MezoView(Mezo m){
		mezo = m;
		Drawables.getInstance().add(this);
		color = new Color(0, 128, 0);
		
}
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);	
		
	}
	
	

	@Override
	public void paint() {
		int x = mezo.getCoord().x;
		int y = mezo.getCoord().y;
		Graphics g = Drawables.getInstance().getGraphics();
		
		g.setColor(color);
		g.fillRect(x*70, y*70, 70, 70);
	}
}
