package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import szoftlab4.Barnavarazsko;
import szoftlab4.Kekvarazsko;
import szoftlab4.Lilavarazsko;
import szoftlab4.Narancsvarazsko;
import szoftlab4.Pirosvarazsko;
import szoftlab4.Sargavarazsko;
import szoftlab4.Torony;
import szoftlab4.Zoldvarazsko;


//A Torony osztályhoz tartozó View osztály
public class ToronyView implements BaseView {
	
	private Torony torony;
	private int[] kovek; 
	
//Az osztály publikus konstruktora, ahol beállítjuk a hozzá tartozó tornyot, és meghívjuk a notifyChanged függvényt.
	public ToronyView(Torony t) {
		torony = t;
		notifyChanged();
	}
	
//Ha az Torony állapotában változás történik, ez a függvény hívódik meg
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);
		
	}
	//Itt rajzoljuk ki a tornyot
	public void paint() {
		kovek = new int[6];
		for(int i=0;i<6;i++)
		{
			kovek[i]=0;
		}
		
		int x = torony.getSajatMezo().getCoord().x;
		int y = torony.getSajatMezo().getCoord().y;
		Image image = new ImageIcon("img/torony.png").getImage();
		Image zold = new ImageIcon("img\\zold.png").getImage();
		Image piros = new ImageIcon("img\\piros.png").getImage();
		Image sarga = new ImageIcon("img\\sarga.png").getImage();
		Image barna = new ImageIcon("img\\barna.png").getImage();
		Image kek = new ImageIcon("img\\kek.png").getImage();
		Image narancs = new ImageIcon("img\\narancs.png").getImage();
		Graphics g = Drawables.getInstance().getGraphics();
		g.drawImage(image, x*70, y*70, null);
		
		g.setFont(new Font("Arial", Font.BOLD, 8));
		// a tornyon lévõ varázskövek kirajzolása		
		for (int i = 0; i < torony.kovek.size(); i++) {
			if (torony.kovek.get(i) instanceof Barnavarazsko)
			{
				kovek[0]++;
				g.drawImage(barna, x*70+10,y*70+45,null);			
				g.drawString(String.format("%4d",kovek[0]), x*70+11, y*70+45+13); // spéci koordináták a kõszámnak
			}
					
			if (torony.kovek.get(i) instanceof Sargavarazsko)
			{
				kovek[1]++;
				g.drawImage(sarga, x*70+43,y*70,null);		
				g.drawString(String.format("%4d",kovek[1]), x*70+44, y*70+13);
			}
			if (torony.kovek.get(i) instanceof Narancsvarazsko)
			{
				kovek[2]++;
				g.drawImage(narancs, x*70+42,y*70+45,null);
				g.drawString(String.format("%4d",kovek[2]), x*70+43, y*70+45+13);
			}
			
			if (torony.kovek.get(i) instanceof Kekvarazsko)
			{
				kovek[3]++;
				g.drawImage(kek, x*70+25,y*70+20,null);		
				g.drawString(String.format("%4d",kovek[3]), x*70+26, y*70+20+13);
			}
			if (torony.kovek.get(i) instanceof Pirosvarazsko)
			{
				kovek[4]++;
				g.drawImage(piros, x*70+25,y*70,null);		
				g.drawString(String.format("%4d",kovek[4]), x*70+26, y*70+13);
			}
			if (torony.kovek.get(i) instanceof Zoldvarazsko)
			{
				kovek[5]++;
				g.drawImage(zold, x*70+7,y*70,null);
				g.drawString(String.format("%4d",kovek[5]), x*70+8, y*70+13);
			}
		}
		
	}

}
