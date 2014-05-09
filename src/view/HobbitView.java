package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Hobbit;

public class HobbitView implements BaseView {

	private Hobbit hobbit;

	public HobbitView(Hobbit h) {
		hobbit = h;
		Drawables.getInstance().add(this);
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(hobbit.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs sajátút, akkor csak törlünk (ellenség meghalt)
	}

	@Override
	public void paint() {
		int x = hobbit.getSajatUt().getCoord().x;
		int y = hobbit.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/hobbit.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x * 70, y * 70, null);
	}

}
