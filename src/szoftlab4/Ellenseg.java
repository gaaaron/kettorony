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

	// Tartalmazza hogy az Elenség éppen melyik mezõn van rajta
	public Ut sajatUt;

	// Az elõzõ út, lépéskor használjuk
	protected Ut elozoUt;

	// Tartalmazza az Ellenség életének értékét
	// Leszármazott osztályokban felülírni!
	public int elet;

	// Tartalmazza, hogy az Ellenség halála esetén mennyivel növekszik a játékos
	// varázsereje
	// Leszármazott osztályokban felülírni!
	protected int ertek;

	protected BaseView view;
	
	private ArrayList<Ut> joutak = null;

	// Az Ellenség osztály konstruktora
	// Leszármazott osztályban felülírni!
	public Ellenseg(Ut sajat) {
		sajatUt = sajat;
		elet = 0;
		ertek = 0;
		sebesseg = 0;
	}

	// Ha tick történik a rendszerben, ez a függvény hívódik meg
	// Tick hatására, az ellenség bizonyos valószínûséggel lépni fog.
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

	// Ha a közelben van egy Végzethegye objektum, ezen függvény segítségével
	// támadja meg azt
	public void tamad(VegzetHegye hegy) {
		hegy.sebez(25);
		this.meghal();
	}

	// Ha az ellenség életereje nullára csökken, ez a függvény hívódik meg
	public void meghal() {

		sajatUt.levesz(this);
		Application.game.ellenseglista.remove(this);
		Application.game.controller.meghaltam(ertek);
		Application.game.ellensegkeszito.meghalt.add(this);
		sajatUt = null;
		if (view != null)
			view.notifyChanged();
	}

	// Amikor az Elenség lép, ez a függvény cseréli le az aktuális mezõt, amin
	// áll
	public void SajatUtCsere(Ut ujUt) {

		// kicseréljük az utunkat az új útra
		sajatUt = ujUt;

	}

	// A torony hívja meg, amennyiben le akarja lõni az ellenséget
	// Az alosztályokban felül kell írni, a megfelelõ logikával!!!
	// TODO: Az alosztályokban meg kell valósítani hogy ha hasító lövedéket kap,
	// akkor ketté váljon
	public void sebez(Lovedek lovedek) {

	}

	// Kiválaszt egy utat ahova lépni szeretne
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

	// A sajatUt attribútumot inicializálja
	public void init(Ut sajat) {
		sajatUt = sajat;
	}

	public Ut getSajatUt() {
		return sajatUt;
	}

}
