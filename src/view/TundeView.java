package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Tunde;

//A T�nde nev� ellens�g kirajzol�s�t megval�s�t� oszt�ly
public class TundeView implements BaseView {

	private Tunde tunde;
//Az oszt�ly publikus konstruktora
	public TundeView(Tunde t) {
		tunde = t;
		Drawables.getInstance().add(this);
	}

	
//Ha T�nde �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(tunde.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs saj�t�t, akkor csak t�rl�nk (ellens�g meghalt)
	}

//Itt rajzoljuk ki T�nd�t
	public void paint() {
		int x = tunde.getSajatUt().getCoord().x;
		int y = tunde.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/tunde.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x * 70, y * 70, null);
		g.setFont(new Font("Arial", Font.BOLD, 9));
		g.drawString(String.format("%4d", tunde.elet), x*70, y*70+12);
	}

}
