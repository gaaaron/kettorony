package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Tunde;

public class TundeView implements BaseView {

	private Tunde tunde;

	public TundeView(Tunde t) {
		tunde = t;
		Drawables.getInstance().add(this);
	}

	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(tunde.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs sajátút, akkor csak törlünk (ellenség meghalt)
	}

	@Override
	public void paint() {
		int x = tunde.getSajatUt().getCoord().x;
		int y = tunde.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/tunde.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x * 70, y * 70, null);
	}

}
