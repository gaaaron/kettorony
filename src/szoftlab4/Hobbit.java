package szoftlab4;

public class Hobbit extends Ellenseg {

	public Hobbit(Ut sajat) {
		super(sajat);
		elet = 150;
		ertek = 110;
		count = 0;
		sebesseg=3;
	}
	
	//Param�terk�nt kap egy l�ved�ket, �s a r� vonatkoz� �rt�kkel sebzi mag�t
	public void sebez(Lovedek lovedek){
		if(elet - lovedek.sebzesHobbit <= 0) meghal();
		elet = elet - lovedek.sebzesHobbit;
		
		if(lovedek.hasit){
			Hobbit h = new Hobbit(this.sajatUt);
			h.elet = this.elet;
			h.id = (this.id+"cp");
			Application.game.ellensegkeszito.osztodott.add(h);
		}
	}

}
