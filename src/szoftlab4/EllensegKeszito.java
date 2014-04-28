package szoftlab4;

import java.util.ArrayList;
import java.util.Random;

public class EllensegKeszito implements Aktiv {
	
		//Tartalmazza azokat az utakat, ahov� egy ellens�g lerakhat�
		public ArrayList<Ut> belepoUtak;
		public ArrayList<Ellenseg> osztodott;
		public ArrayList<Ellenseg> meghalt;
		
		//Az EllensegKeszito param�teres konstruktora. �t kell neki adni a bel�p�utak list�j�t.
		/*public EllensegKeszito(ArrayList<Ut> utak){
			belepoUtak = utak;
			osztodott = new ArrayList<Ellenseg>();
		}*/
		
		public EllensegKeszito(){
			belepoUtak = new ArrayList<Ut>();
			osztodott = new ArrayList<Ellenseg>();
			meghalt = new ArrayList<Ellenseg>();
		}
		
		//Tick hat�s�ra v�laszt egy utat, majd bizonyos val�sz�n�s�ggel lerak oda egy
		//v�letlen�l kiv�lasztott ellens�get
		public void tick(){  
	         
			//TODO: ellens�g egyedi id-t kapjon
			/*Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(10);
			
			if(index == 1){
			
				String ellenseg;
				
				Ut valasztott = utatValaszt();
				ellenseg = getEllensegTipus();
				
				if(ellenseg.matches("Hobbit"))
					valasztott.ratesz(new Hobbit(valasztott));
				else if(ellenseg.matches("T�nde"))
					valasztott.ratesz(new Tunde(valasztott));
				else if(ellenseg.matches("Ember"))
					valasztott.ratesz(new Ember(valasztott));
				else
					valasztott.ratesz(new Torpe(valasztott));
				
			}*/
			osztodottBetesz();
			meghaltKivesz();
		}
		
		//V�letlenszer�en kiv�laszt egy ellens�gt�pust, �s visszaadja azt String-k�nt
		public String getEllensegTipus(){
			String mitad = null;			
			
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(3);
	        
			switch(index)
			{
			case 0: mitad = new String("Ember"); break;
			case 1: mitad = new String("Hobbit"); break;
			case 2: mitad = new String("Torp"); break;
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
