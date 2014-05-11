package szoftlab4;

import java.util.ArrayList;
import java.util.List;

import view.VegzetHegyeView;

public class VegzetHegye implements Utravalo, Aktiv{
	
	//Ez t�rolja hogy melyik cell�n van az objektum
	private Ut sajatUt;
	
	//A VegzetHegye �let�t tartalmazza
	public int elet;
	
	private VegzetHegyeView view;
		
	//Konstruktor, ami inicializ�lja az objektumot.
	public VegzetHegye(){
		sajatUt = null;
		elet = 100;
		view = new VegzetHegyeView(this); 
	}
	public VegzetHegye(Cella sj){
		sajatUt = (Ut)sj;
		elet = 300;
		view = new VegzetHegyeView(this);
	}
	
	//A torony �let�t lecs�kkkenti a param�terben kapott mennyis�ggel
	//Amennyiben a torony �lete negat�v tartom�nyba esik, megh�vja a meghal() f�ggv�nyt.
	public void sebez(int egyseg){
			elet = elet-egyseg;
			if(elet<=0)
				meghal();
	}
			
	//Akkor h�v�dik meg, hogyha a torony ereje annyira lecs�kken, hogy a toronynak el kell
	//pusztulnia
	public void meghal(){
		Application.game.controller.endgame(true);
	}
	
	
	//Inicializ�lja az oszt�j sajatUt attrib�tum�t, ami tartalmazza hogy az elem
	//melyik cell�n van rajta
	public void init(Ut sajat){
		sajatUt = sajat;
	}
	
	public int getElet(){
		return elet;
	}
	@Override
	public void tick() {
		
		ArrayList<Ellenseg> ellensegek = sajatUt.kivanrajtam();
		
		for(Ellenseg e: ellensegek){
			e.tamad(this);
		}
	}
	public Ut getSajatUt() {
		return sajatUt;
	}
	
	public boolean tavolsag(Ut ut, ArrayList<Ut> bejarva, List<Ut> joutak){
		if(bejarva.contains(ut)) return false;
		bejarva.add(ut);
		
		
		if(ut == sajatUt) return true;
		
		for(Ut uu : ut.lepneeeek()){
			if(tavolsag(uu,bejarva,joutak)){
				joutak.add(uu);
				return true;
			}
		}
		return false;
	}
}
