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

	// Tartalmazza hogy az Elens�g �ppen melyik mez�n van rajta
	public Ut sajatUt;

	// Az el�z� �t, l�p�skor haszn�ljuk
	private Ut elozoUt;

	// Tartalmazza az Ellens�g �let�nek �rt�k�t
	// Lesz�rmazott oszt�lyokban fel�l�rni!
	public int elet;

	// Tartalmazza, hogy az Ellens�g hal�la eset�n mennyivel n�vekszik a j�t�kos
	// var�zsereje
	// Lesz�rmazott oszt�lyokban fel�l�rni!
	protected int ertek;

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

		if (count == sebesseg) {
			ArrayList<Ut> lehetsegesutak = sajatUt.lepnek();
			lepek(lehetsegesutak);
			count = 0;
		} else
			count++;

	}

	// Ha a k�zelben van egy V�gzethegye objektum, ezen f�ggv�ny seg�ts�g�vel
	// t�madja meg azt
	public void tamad(VegzetHegye hegy) {

	}

	// Ha az ellens�g �letereje null�ra cs�kken, ez a f�ggv�ny h�v�dik meg
	public void meghal() {

		sajatUt.levesz(this);
		Application.game.ellenseglista.remove(this);
		Application.game.controller.meghaltam(ertek);
		Application.game.ellensegkeszito.meghalt.add(this);
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

	// A sajatUt attrib�tumot inicializ�lja
	public void init(Ut sajat) {
		sajatUt = sajat;
	}

}
