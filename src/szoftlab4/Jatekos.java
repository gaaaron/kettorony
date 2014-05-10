package szoftlab4;

import java.util.ArrayList;

import view.JatekosView;

public class Jatekos {
	
	JatekosView view;
	//T�rolja a j�t�kos var�zserej�t
	public int varazsero = 0;
	
	//A j�t�kos birtok�ban l��v var�zsk�veket tartalmazza
	public ArrayList<Varazsko> varazskovek;
	
	//A j�t�kos birtok�ban l��v� var�zsk�vek sz�ma
	public int[] varazskoszam;

	//A Jatekos oszt�ly konstruktora
	public Jatekos() {
		view = new JatekosView(this);
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
		varazskoszam = new int[7];
	}

	//V�s�r�l egy k�vet, hogyha a j�t�kosnak van r� el�g var�zsereje
	public void vasarol(Varazsko v) {
		if (Varazsko.getAr() <= varazsero) {
			varazserotVeszit(Varazsko.getAr());
			varazskovek.add(v);
		}
	}

	//Ez a f�ggv�ny h�v�dik meg, ha egy ellens�g meghal.
	//A j�t�kos var�zserej�t n�veli
	public void varazserotKap(int i) {

		varazsero += i;
		view.notifyChanged();
	}

	//A j�t�kos var�zserej�t cs�kkenti
	public void varazserotVeszit(int i) {

		varazsero -= i;
		view.notifyChanged();
	}

	//Egy kiv�lasztott akad�lyt fejleszthet�nk vele, ha van a birtokunkban Lila var�zsk�
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

	//Egy �j akad�lyt hozhatunk l�tre, ha van r� el�g var�zser�nk
	public boolean ujAkadaly(Ut valasztottUt, Akadaly ezt, Application.Message msg) {
		
		if(varazsero>=20){
			valasztottUt.akadaly = ezt;
			ezt.init(valasztottUt);
			varazserotVeszit(20);
			msg.text = "Akad�ly l�trehozva";
			return true;
		}else{
			msg.text = "Nincs el�g var�zser�";
			return false;
		}
		
	}

	//Egy �j Tornyot hozhatunk l�tre, ha van r� el�g var�zser�nk
	public boolean ujTorony(Mezo valasztottMezo, Torony ezt, Application.Message msg) {
		
		if(varazsero>=10){
			valasztottMezo.ratesz(ezt);
			varazserotVeszit(10);
			ezt.init(valasztottMezo);
			msg.text = "Torony l�trehozva";
			return true;
		}else{
			msg.text = "Nincs el�g var�zser�";
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