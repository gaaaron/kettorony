package szoftlab4;

import java.util.Random;
import java.util.ArrayList;

import view.BaseView;

public class Ellenseg implements Utravalo, Aktiv {

	public String id;

	public int count;

	public int irany = 3;

	//
	public int sebesseg;

	// Tartalmazza hogy az Elens�g �ppen melyik mez�n van rajta
	public Ut sajatUt;

	// Az el�z� �t, l�p�skor haszn�ljuk
	protected Ut elozoUt;

	// Tartalmazza az Ellens�g �let�nek �rt�k�t
	// Lesz�rmazott oszt�lyokban fel�l�rni!
	public int elet;

	// Tartalmazza, hogy az Ellens�g hal�la eset�n mennyivel n�vekszik a j�t�kos
	// var�zsereje
	// Lesz�rmazott oszt�lyokban fel�l�rni!
	protected int ertek;

	protected BaseView view;
	
	private ArrayList<Ut> joutak = null;

	// Az Ellens�g oszt�ly konstruktora
	// Lesz�rmazott oszt�lyban fel�l�rni!
	public Ellenseg(Ut sajat) {
		sajatUt = sajat;
		elet = 0;
		ertek = 0;
		sebesseg = 0;
	}

	// Ha tick t�rt�nik a rendszerben, ez a f�ggv�ny h�v�dik meg
	// Tick hat�s�ra, az ellens�g bizonyos val�sz�n�s�ggel l�pni fog.
	public void tick() {
		ArrayList<Ut> lehetsegesutak = null;
		if (count == sebesseg) {
			if (sajatUt != null) {
				lehetsegesutak = sajatUt.lepnek();
			}
			if (lehetsegesutak != null)
				lepek(lehetsegesutak);
			count = 0;
		} else
			count++;

	}

	// Ha a k�zelben van egy V�gzethegye objektum, ezen f�ggv�ny seg�ts�g�vel
	// t�madja meg azt
	public void tamad(VegzetHegye hegy) {
		hegy.sebez(25);
		this.meghal();
	}

	// Ha az ellens�g �letereje null�ra cs�kken, ez a f�ggv�ny h�v�dik meg
	public void meghal() {

		sajatUt.levesz(this);
		Application.game.ellenseglista.remove(this);
		Application.game.controller.meghaltam(ertek);
		Application.game.ellensegkeszito.meghalt.add(this);
		sajatUt = null;
		if (view != null)
			view.notifyChanged();
	}

	// Amikor az Elens�g l�p, ez a f�ggv�ny cser�li le az aktu�lis mez�t, amin
	// �ll
	public void SajatUtCsere(Ut ujUt) {

		// kicser�lj�k az utunkat az �j �tra
		sajatUt = ujUt;

	}

	// A torony h�vja meg, amennyiben le akarja l�ni az ellens�get
	// Az aloszt�lyokban fel�l kell �rni, a megfelel� logik�val!!!
	// TODO: Az aloszt�lyokban meg kell val�s�tani hogy ha has�t� l�ved�ket kap,
	// akkor kett� v�ljon
	public void sebez(Lovedek lovedek) {

	}

	// Kiv�laszt egy utat ahova l�pni szeretne
	public void lepek(ArrayList<Ut> utak) {
		
		//if (elozoUt != null) {
		//	utak.remove(elozoUt);
		//}
		if (utak.size() > 0) {
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(utak.size());

			Ut kovetkezout = utak.get(index);
			
			if(joutak == null){
				joutak = new ArrayList<Ut>();
				Application.game.hegy.tavolsag(sajatUt, new ArrayList<Ut>(), joutak);
				//if(joutak.size() != 0) joutak.remove(joutak.size()-1);
			}
			
			if(joutak.size()-1 >=0 ){
				kovetkezout = joutak.get(joutak.size()-1);
				joutak.remove(joutak.size()-1);
			}

			elozoUt = sajatUt;

			sajatUt.levesz(this);
			kovetkezout.ratesz(this);
			if (view != null)
				view.notifyChanged();
		}
	}

	// A sajatUt attrib�tumot inicializ�lja
	public void init(Ut sajat) {
		sajatUt = sajat;
	}

	public Ut getSajatUt() {
		return sajatUt;
	}

}
