package szoftlab4;

import java.util.ArrayList;

import view.JatekosView;

public class Jatekos {
	
	JatekosView view;
	//Tárolja a játékos varázserejét
	public int varazsero = 0;
	
	//A játékos birtokában léõv varázsköveket tartalmazza
	public ArrayList<Varazsko> varazskovek;
	
	//A játékos birtokában léõvõ varázskövek száma
	public int[] varazskoszam;

	//A Jatekos osztály konstruktora
	public Jatekos() {
		view = new JatekosView(this);
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
		varazskoszam = new int[7];
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
		view.notifyChanged();
	}

	//A játékos varázserejét csökkenti
	public void varazserotVeszit(int i) {

		varazsero -= i;
		view.notifyChanged();
	}

	//Egy kiválasztott akadályt fejleszthetünk vele, ha van a birtokunkban Lila varázskõ
	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko) {
		akadaly.addko(varazsko);
		varazskovek.remove(varazsko);
		varazskoszam[2]-=1;
		view.notifyChanged();
	}
	
	public void fejleszt(Torony torony, Toronykovek toronyko) {
		torony.addKo(toronyko);
		varazskovek.remove(toronyko);
		
		if(toronyko instanceof Barnavarazsko) varazskoszam[0]-=1;
		else if(toronyko instanceof Kekvarazsko) varazskoszam[1]-=1;
		else if(toronyko instanceof Narancsvarazsko) varazskoszam[3]-=1;
		else if(toronyko instanceof Pirosvarazsko) varazskoszam[4]-=1;
		else if(toronyko instanceof Sargavarazsko) varazskoszam[5]-=1;
		else if(toronyko instanceof Zoldvarazsko) varazskoszam[6]-=1;
		
		
		view.notifyChanged();
	}

	//Egy új akadályt hozhatunk létre, ha van rá elég varázserõnk
	public boolean ujAkadaly(Ut valasztottUt, Akadaly ezt, Application.Message msg) {
		
		if(varazsero>=20){
			valasztottUt.akadaly = ezt;
			ezt.init(valasztottUt);
			varazserotVeszit(20);
			msg.text = "Akadály létrehozva";
			return true;
		}else{
			msg.text = "Nincs elég varázserõ";
			return false;
		}
		
	}

	//Egy új Tornyot hozhatunk létre, ha van rá elég varázserõnk
	public boolean ujTorony(Mezo valasztottMezo, Torony ezt, Application.Message msg) {
		
		if(varazsero>=10){
			valasztottMezo.ratesz(ezt);
			varazserotVeszit(10);
			ezt.init(valasztottMezo);
			msg.text = "Torony létrehozva";
			return true;
		}else{
			msg.text = "Nincs elég varázserõ";
			return false;
		}
	}

	public void kovetVesz(String koTipus) {
		
		if(varazsero < 30){
			return;
		}
		
		if (koTipus.matches("barna")){
			varazskovek.add(new Barnavarazsko());
			varazskoszam[0]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else if (koTipus.matches("kek")){
			varazskovek.add(new Kekvarazsko());
			varazskoszam[1]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else if (koTipus.matches("lila")){
			varazskovek.add(new Lilavarazsko());
			varazskoszam[2]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else if (koTipus.matches("narancs")){
			varazskovek.add(new Narancsvarazsko());
			varazskoszam[3]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else if (koTipus.matches("piros")){
			varazskovek.add(new Pirosvarazsko());
			varazskoszam[4]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else if (koTipus.matches("sarga")){
			varazskovek.add(new Sargavarazsko());
			varazskoszam[5]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else if (koTipus.matches("zold")){
			varazskovek.add(new Zoldvarazsko());
			varazskoszam[6]+=1;
			view.notifyChanged();
			varazserotVeszit(30);
		}
		else{
			return;
		}

		return;

	}
}