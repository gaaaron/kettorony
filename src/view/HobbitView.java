package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Hobbit;

//A Hobbit nev� ellens�g kirajzol�s�t megval�s�t� oszt�ly
public class HobbitView implements BaseView {

	private Hobbit hobbit;

//Az oszt�ly publikus konstruktora
	public HobbitView(Hobbit h) {
		hobbit = h;
		Drawables.getInstance().add(this);
	}
	
//Ha a Hobbit �llapot�ban v�ltoz�s t�rt�nik, ez a f�ggv�ny h�v�dik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		if(hobbit.getSajatUt() != null) Drawables.getInstance().add(this); //ha nincs saj�t�t, akkor csak t�rl�nk (ellens�g meghalt)
	}

//Itt rajzoljuk ki az Hobbitot
	public void paint() {
		int x = hobbit.getSajatUt().getCoord().x;
		int y = hobbit.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/hobbit.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x * 70, y * 70, null);
	}

}
