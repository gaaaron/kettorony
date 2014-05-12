package szoftlab4;

import view.TundeView;


//Egy speciális ellenségtípus
public class Tunde extends Ellenseg{

	//Tunde osztály publikus konstruktora
	public Tunde(Ut sajat) {
		super(sajat);
		elet = 170;
		ertek = 100;
		count = 0;
		sebesseg=2;
		view = new TundeView(this);
	}
	
	//Ha lövés éri az ellenséget, akkor a rá vonatkozó értékkel csökken az élete
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
