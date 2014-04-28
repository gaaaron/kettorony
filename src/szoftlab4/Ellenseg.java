package szoftlab4;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class Ellenseg implements Utravalo, Aktiv {


	public String id;

	public int count;

	public int irany = 3;

	//
	public int sebesseg;

	// Tartalmazza hogy az Elenség éppen melyik mezõn van rajta
	public Ut sajatUt;

	// Az elõzõ út, lépéskor használjuk
	private Ut elozoUt;

	// Tartalmazza az Ellenség életének értékét
	// Leszármazott osztályokban felülírni!
	public int elet;

	// Tartalmazza, hogy az Ellenség halála esetén mennyivel növekszik a játékos
	// varázsereje
	// Leszármazott osztályokban felülírni!
	protected int ertek;

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

		if (count == sebesseg) {
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
			count = 0;
		} else
			count++;

	}

	// Ha a közelben van egy Végzethegye objektum, ezen függvény segítségével
	// támadja meg azt
	public void tamad(VegzetHegye hegy) {

	}

	// Ha az ellenség életereje nullára csökken, ez a függvény hívódik meg
	public void meghal() {

		sajatUt.levesz(this);
		Application.game.ellenseglista.remove(this);
		Application.game.controller.meghaltam(ertek);
		Application.game.ellensegkeszito.meghalt.add(this);
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

		if (elozoUt != null) {
			utak.remove(elozoUt);
		}
		if (utak.size() > 0) {
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(utak.size());

			Ut kovetkezout = utak.get(index);

			elozoUt = sajatUt;

			sajatUt.levesz(this);
			kovetkezout.ratesz(this);
		}
	}

	// A sajatUt attribútumot inicializálja
	public void init(Ut sajat) {
		sajatUt = sajat;
	}

}
