package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import szoftlab4.VegzetHegye;

//Oszt�ly, ami a V�gzet hegy�nek kirajzol�s��rt felel�s
public class VegzetHegyeView implements BaseView {

	VegzetHegye vegzetHegye;
	
//Az oszt�ly publikus konstruktora
	public VegzetHegyeView(VegzetHegye vH){
		vegzetHegye = vH;
		notifyChanged();
	}
	
//Ha a V�gzet hegy�nek �llapota m�dosul, ez a f�ggv�ny h�v�dik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}

//A v�gzet hegye kirajzol�s�t v�gezz�k itt el az el�re be�ll�tott koordin�t�kra.
	public void paint() {
		int x = vegzetHegye.getSajatUt().getCoord().x;
		int y = vegzetHegye.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/hegy.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.drawString(String.format("%4d", vegzetHegye.elet), x*70, y*70+12);
	}

}
