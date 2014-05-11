package view;

import java.awt.Color;
import java.awt.Font;
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
		g.setFont(new Font("Arial", Font.BOLD, 9));
		g.drawString(String.format("%4d", hobbit.elet), x*70, y*70+12);
		
		// life-bar a hobbitnak
		g.setColor(Color.white);
		g.fillRect(x*70+0, y*70, 50, 5);
		g.setColor(Color.green);
		double lifebar =((double)hobbit.elet/(double)150)*(double)50;
		g.fillRect(x*70+0, y*70, (int) lifebar , 4);
		g.setColor(Color.white); // feh�r alapsz�n vissza�ll�t�sa
	}

}
