package szoftlab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jatekter {

	//A j�t�kt�r cell�it tartalmazza
	public ArrayList<ArrayList<Cella>> cellak;
	public int width;
	public int height;
	
	//Az aktu�lis j�t�kost tartalmazza
	public Jatekos felhasznalo;

	//A Jatekter oszt�ly konstruktora. Param�terk�nt egy j�t�kost v�r.
	public Jatekter(Jatekos user) {
		felhasznalo = user;
		cellak = new ArrayList<ArrayList<Cella>>();
	}

	//Egy p�lya bet�lt�s�re val� f�ggv�ny. P�lyasz�mot v�r.
	public void betolt(int palyaSzam) {

	}

	//Egy p�lya bet�lt�s�re val� f�ggv�ny. A p�ly�t tartalmaz� f�jl nev�t v�rja.
	public boolean betolt(String filename, Application.Message msg) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));

			//Az els� sorb�l beolvassa a p�lya m�reteit
			String line = br.readLine();
			String[] splitLine = line.split("\\s+");
			int sizeI = Integer.parseInt(splitLine[0]);
			int sizeJ = Integer.parseInt(splitLine[1]);

			//Olvassa a f�jlb�l a p�lya sorait
			for(int i=0;i<sizeI;i++){
				line = br.readLine();
				cellak.add(new ArrayList<Cella>(sizeI));
				for(int j=0;j<sizeJ;j++){
					if (line.charAt(j) == 'M')		
						cellak.get(i).add(new Mezo(i,j));
					else if (line.charAt(j) == 'U'){
						Ut ut = new Ut(i,j);
						cellak.get(i).add(ut);
						
						if( ( i == 0 || i==(sizeI-1) ) || ( j == 0 || j==(sizeJ-1) ) ) Application.game.ellensegkeszito.belepoUtak.add(ut);
					}
					else 							break;
				}
			}
			
			//V�gzetHegye poz�ci�j�t beolvassuk a f�jlb�l
			line = br.readLine();
			splitLine = line.split("\\s+");
			if(splitLine[0].equals("VH")){
				if(splitLine.length == 3){ 
					VegzetHegye uj = new VegzetHegye(cellak.get(Integer.parseInt(splitLine[1])).get(Integer.parseInt(splitLine[2])));
					Ut sajatUt = (Ut) cellak.get(Integer.parseInt(splitLine[1])).get(Integer.parseInt(splitLine[2]));
					sajatUt.ratesz(uj);
					uj.init(sajatUt);
					Application.game.hegy = uj;
					Application.game.controller.aktiv.add(uj);
			}
			}
			
			
			//Felhaszn�l� var�zserej�t beolvassuk a f�jlb�l
			line = br.readLine();
			splitLine = line.split("\\s+");
			if(splitLine[0].equals("POWER")){
				if(splitLine.length == 2) 
					felhasznalo.varazserotKap(Integer.parseInt(splitLine[1]));
			}
			
			//Felhaszn�l� var�zserej�t beolvassuk a f�jlb�l
			line = br.readLine();
			splitLine = line.split("\\s+");
			if(splitLine[0].equals("PLUSENEMY")){
				if(splitLine.length == 2) 
					Application.game.ellensegkeszito.plusenemy = Integer.parseInt(splitLine[1]);
			}

			//Cella szomsz�dainak be�ll�t�sa
			for(int i=0; i< cellak.size();i++){
				for(int j=0; j< cellak.get(i).size();j++){
					if(i>0)							cellak.get(i).get(j).szomszedok.add(cellak.get(i-1).get(j));
					if(i< (cellak.size()-1) )		cellak.get(i).get(j).szomszedok.add(cellak.get(i+1).get(j));
					if(j>0)							cellak.get(i).get(j).szomszedok.add(cellak.get(i).get(j-1));
					if(j< (cellak.get(i).size()-1))	cellak.get(i).get(j).szomszedok.add(cellak.get(i).get(j+1));
				}
			}
			height = cellak.size();
			width = cellak.get(0).size();
			return true;

		} catch (IOException e) {
			msg.text = "IO Hiba";
			return false;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				msg.text = "IO Hiba";
				return false;
			}
		}

	}

	public int getAr(String koTipus) {

		int ar = 0;
		return ar;
	}
}
