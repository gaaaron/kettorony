package view;

import java.awt.Color;
import java.awt.Graphics;

import szoftlab4.Ut;

public class UtView implements BaseView {

	private Ut ut;
	Color color;
	
	
	public UtView(Ut u){
		ut = u;
		Drawables.getInstance().add(this);
		color = new Color(139, 69, 19);
	}

	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
	}

	public void paint() {
		int x = ut.getCoord().x;
		int y = ut.getCoord().y;
		Graphics g = Drawables.getInstance().getGraphics();
		
		g.setColor(color);
		g.fillRect(x*70, y*70, 70, 70);
	}
	
}
