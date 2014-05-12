package szoftlab4;

import view.TorpeView;


//Egy speciális ellenségtípus
public class Torpe extends Ellenseg {

//Törpe publikus konstruktora
	public Torpe(Ut sajat) {
		super(sajat);
		elet = 200;
		ertek = 100;
		count = 0;
		sebesseg=5;
		view = new TorpeView(this);
	}
	

	
	//Ha lövés éri az ellenséget, akkor a rá vonatkozó értékkel csökken az élete
	public void sebez(Lovedek lovedek){
		if(elet - lovedek.sebzesTorpe <= 0) meghal();
		elet = elet - lovedek.sebzesTorpe;
		
		if(lovedek.hasit){
			Torpe h = new Torpe(this.sajatUt);
			h.id = (this.id+"cp");
			h.elet = this.elet;
			Application.game.ellensegkeszito.osztodott.add(h);
		}
	}

}
