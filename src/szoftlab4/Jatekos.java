package szoftlab4;

import java.util.ArrayList;

public class Jatekos {
	
	//Tárolja a játékos varázserejét
	public int varazsero = 0;
	
	//A játékos birtokában léõv varázsköveket tartalmazza
	public ArrayList<Varazsko> varazskovek;

	//A Jatekos osztály konstruktora
	public Jatekos() {
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
	}

	//Vásáról egy követ, hogyha a játékosnak van rá elég varázsereje
	public void vasarol(Varazsko v) {
		if (Varazsko.getAr() <= varazsero) {
			varazserotVeszit(Varazsko.getAr());
			varazskovek.add(v);
		}
	}

	//Ez a függvény hívódik meg, ha egy ellenség meghal.
	//A játékos varázserejét növeli
	public void varazserotKap(int i) {

		varazsero += i;

	}

	//A játékos varázserejét csökkenti
	public void varazserotVeszit(int i) {

		varazsero -= i;

	}

	//Egy kiválasztott akadályt fejleszthetünk vele, ha van a birtokunkban Lila varázskõ
	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko) {
		akadaly.addko(varazsko);
	}
	
	public void fejleszt(Torony torony, Toronykovek toronyko) {
		torony.addKo(toronyko);
	}

	//Egy új akadályt hozhatunk létre, ha van rá elég varázserõnk
	public boolean ujAkadaly(Ut valasztottUt, Akadaly ezt, Application.Message msg) {
		
		if(varazsero>=20){
			valasztottUt.akadaly = ezt;
			ezt.init(valasztottUt);
			varazserotVeszit(20);
			msg.text = "Akadaly letrehozva";
			return true;
		}else{
			msg.text = "Nincs eleg varazsero";
			return false;
		}
		
	}

	//Egy új Tornyot hozhatunk létre, ha van rá elég varázserõnk
	public boolean ujTorony(Mezo valasztottMezo, Torony ezt, Application.Message msg) {
		
		if(varazsero>=10){
			valasztottMezo.ratesz(ezt);
			varazserotVeszit(10);
			msg.text = "Torony letrehozva";
			return true;
		}else{
			msg.text = "Nincs eleg varazsero";
			return false;
		}
	}

	public void kovetVesz(String koTipus) {

	}
}