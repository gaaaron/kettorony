package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Akadaly;


//Az akad�ly oszt�lyhoz tartoz� View oszt�ly, ami a kirajzol�s��rt felel.
public class AkadalyView implements BaseView {

	private Akadaly akadaly;
	

//Az oszt�ly publikus konstruktora
	public AkadalyView(Akadaly a) {
		akadaly = a;
		notifyChanged();
	}
	
//Ez a f�ggv�ny h�v�dik akkor, hogyha az akad�ly objektum �llapot�ban v�ltoz�s t�rt�nik
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		int pozition = Drawables.getInstance().getMapSize();
		Drawables.getInstance().add(pozition+1, this);
		
	}

//Az akad�ly kirajzol�s�t megval�s�t� f�ggv�ny
//Megn�zi, hogy milyen koordin�t�kra kell rajzolnia, �s bet�lti, majd kirajzolja az akad�ly k�p�t
	public void paint() {
		int x = akadaly.getSajatUt().getCoord().x;
		int y = akadaly.getSajatUt().getCoord().y;
		Image image = new ImageIcon("img/akadaly.png").getImage();
		Image lila = new ImageIcon("img\\lila.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
		
		if(akadaly.ko!=null)
		{
			g.drawImage(lila, x*70, y*70+50, null);
		}
	}

}
