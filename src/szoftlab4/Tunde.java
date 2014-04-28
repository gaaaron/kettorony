package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

//Egy speci�lis ellens�gt�pus
public class Tunde extends Ellenseg{

	//Tunde oszt�ly publikus konstruktora
	public Tunde(Ut sajat) {
		super(sajat);
		elet = 170;
		ertek = 150;
		count = 0;
		sebesseg=3;
	}
	
	//Ha l�v�s �ri az ellens�get, akkor a r� vonatkoz� �rt�kkel cs�kken az �lete
	public void sebez(Lovedek lovedek){
		if(elet - lovedek.sebzesTunde <= 0) meghal();
		elet = elet - lovedek.sebzesTunde;
		
		if(lovedek.hasit){
			Tunde h = new Tunde(this.sajatUt);
			h.id = (this.id+"cp");
			h.elet = this.elet;
			Application.game.ellensegkeszito.osztodott.add(h);
		}
	}

}
