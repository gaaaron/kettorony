package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class EllensegKeszito implements Aktiv {
	
		//Tartalmazza azokat az utakat, ahov� egy ellens�g lerakhat�
		public ArrayList<Ut> belepoUtak;
		public ArrayList<Ellenseg> osztodott;
		public ArrayList<Ellenseg> meghalt;
		private int id=0;
		private int enemyNumber;
		
		//Az EllensegKeszito param�teres konstruktora. �t kell neki adni a bel�p�utak list�j�t.
		/*public EllensegKeszito(ArrayList<Ut> utak){
			belepoUtak = utak;
			osztodott = new ArrayList<Ellenseg>();
		}*/
		
		public int getEnemyNumber() {
			return enemyNumber;
		}

		public EllensegKeszito(){
			belepoUtak = new ArrayList<Ut>();
			osztodott = new ArrayList<Ellenseg>();
			meghalt = new ArrayList<Ellenseg>();
			enemyNumber = 50 + new Random().nextInt(19);
		}
		
		//Tick hat�s�ra v�laszt egy utat, majd bizonyos val�sz�n�s�ggel lerak oda egy
		//v�letlen�l kiv�lasztott ellens�get
		public void tick(){  
			
			
			osztodottBetesz();
			meghaltKivesz();
			
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(15);
				
			if(index == 1 && enemyNumber>0){
				
				String ellenseg;
				enemyNumber--;	
				Ut valasztott = utatValaszt();
				ellenseg = getEllensegTipus();
					
				index = id;
				id++;
					
				if(ellenseg.matches("Hobbit")){
					Hobbit h = new Hobbit(valasztott);
					Application.game.controller.aktiv.add(h);
					Application.game.ellenseglista.add(h);
					h.id = "ho"+index;
					valasztott.ratesz(h);
				}else if(ellenseg.matches("Tunde")){
					Tunde h = new Tunde(valasztott);
					Application.game.controller.aktiv.add(h);
					Application.game.ellenseglista.add(h);
					h.id = "tn"+index;
					valasztott.ratesz(h);
				}else if(ellenseg.matches("Ember")){
					Ember h = new Ember(valasztott);
					Application.game.controller.aktiv.add(h);
					Application.game.ellenseglista.add(h);
					h.id = "em"+index;
					valasztott.ratesz(h);
				}else{
					Torpe h = new Torpe(valasztott);
					Application.game.controller.aktiv.add(h);
					Application.game.ellenseglista.add(h);
					h.id = "tr"+index;
					valasztott.ratesz(h);
				}
					
			}
		}	
		//V�letlenszer�en kiv�laszt egy ellens�gt�pust, �s visszaadja azt String-k�nt
		public String getEllensegTipus(){
			String mitad = null;			
			
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(4);
	        
			switch(index)
			{
			case 0: mitad = new String("Ember"); break;
			case 1: mitad = new String("Hobbit"); break;
			case 2: mitad = new String("Torpe"); break;
			case 3: mitad = new String("Tunde"); break;
			}
			
			return mitad;
		}
		
		
		//V�letlenszer�en kiv�laszt egyet a bel�p�utak list�j�b�l, �s visszaadja azt
		public Ut utatValaszt(){
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(belepoUtak.size());
	        Ut belepout = belepoUtak.get(index);
	        return belepout;
		}
		
		public void osztodottBetesz(){
			for(Ellenseg e : osztodott){
				Application.game.controller.aktiv.add(e);
				e.sajatUt.ratesz(e);
				Application.game.ellenseglista.add(e);
			}
			osztodott.clear();
		}
		public void meghaltKivesz(){
			for(Ellenseg e : meghalt){
				Application.game.controller.aktiv.remove(e);
			}
			meghalt.clear();
		}
		
}
