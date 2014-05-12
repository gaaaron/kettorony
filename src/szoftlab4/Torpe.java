package szoftlab4;

import view.TorpeView;


//Egy speci�lis ellens�gt�pus
public class Torpe extends Ellenseg {

//T�rpe publikus konstruktora
	public Torpe(Ut sajat) {
		super(sajat);
		elet = 200;
		ertek = 100;
		count = 0;
		sebesseg=5;
		view = new TorpeView(this);
	}
	

	
	//Ha l�v�s �ri az ellens�get, akkor a r� vonatkoz� �rt�kkel cs�kken az �lete
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
