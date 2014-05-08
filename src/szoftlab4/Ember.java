package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

import view.EmberView;


public class Ember extends Ellenseg {
	
	public Ember(Ut sajat) {
		super(sajat);
		elet = 100;
		view = new EmberView(this);
		ertek = 100;
		count = 0;
		sebesseg=3;
	}
	
	//Paraméterként kap egy lövedéket, és a rá vonatkozó értékkel sebzi magát
	public void sebez(Lovedek lovedek){
		if(elet - lovedek.sebzesEmber <= 0) meghal();
		elet = elet - lovedek.sebzesEmber;
		
		if(lovedek.hasit){
			Ember h = new Ember(this.sajatUt);
			h.id = (this.id+"cp");
			h.elet = this.elet;
			Application.game.ellensegkeszito.osztodott.add(h);
		}
	}
	
	


	
}
