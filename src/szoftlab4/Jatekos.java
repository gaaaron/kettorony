package szoftlab4;

import java.util.ArrayList;

public class Jatekos {
	
	//T�rolja a j�t�kos var�zserej�t
	public int varazsero = 0;
	
	//A j�t�kos birtok�ban l��v var�zsk�veket tartalmazza
	public ArrayList<Varazsko> varazskovek;

	//A Jatekos oszt�ly konstruktora
	public Jatekos() {
		varazskovek = new ArrayList<Varazsko>();
		varazsero = 0;
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

	}

	//A j�t�kos var�zserej�t cs�kkenti
	public void varazserotVeszit(int i) {

		varazsero -= i;

	}

	//Egy kiv�lasztott akad�lyt fejleszthet�nk vele, ha van a birtokunkban Lila var�zsk�
	public void fejleszt(Akadaly akadaly, Lilavarazsko varazsko) {
		akadaly.addko(varazsko);
	}
	
	public void fejleszt(Torony torony, Toronykovek toronyko) {
		torony.addKo(toronyko);
	}

	//Egy �j akad�lyt hozhatunk l�tre, ha van r� el�g var�zser�nk
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

	//Egy �j Tornyot hozhatunk l�tre, ha van r� el�g var�zser�nk
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