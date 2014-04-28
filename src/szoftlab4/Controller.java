package szoftlab4;



import java.util.ArrayList;
import java.lang.Runnable;

public class Controller implements Runnable{
	
	//Az aktív játékteret tartalmazza
	Jatekter jatekter;
	
	//Az Aktív elemeket tartalmazza, amelyeknek szüksége van tick-re.
	ArrayList<Aktiv> aktiv;
	
	//Tick szál és az azt leállító flag
	private Thread ticker;
	public volatile boolean STOP;
    public void addNotify() {
    	STOP=true;
        ticker = new Thread(this);
        ticker.start();
    }
	@Override
	public void run() {
        while (!STOP) {
        	addTick();
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
    
    
	//A Controller osztály konstruktora
	public Controller(Jatekter ter) { 
		jatekter = ter;
		aktiv = new ArrayList<Aktiv>();
		STOP = false;
	}

	// Pálya kiválasztása, játékos felruházása varázserõvel
	public void indit(){ 
		int palyaSzam = 0;
			jatekter.betolt(palyaSzam);
			jatekter.felhasznalo.varazserotKap(100);
			startTick();

	}
	
	public void startTick() { // Tick szál indítása
		this.notify();
	}
	
	public void addTick(){	//Minden elem kap egy ticket
		for (Aktiv elem : aktiv) {
			elem.tick();
		}
		Application.game.ellensegkeszito.tick();
	}

	//Egy ellenség halála után, a játékos varázserõt kap
	public void meghaltam(int ertek) { 

		jatekter.felhasznalo.varazserotKap(ertek);

	}

	//Egy aktív pályaelemet hozzáad az Aktív listához
	public void addAktiv(Aktiv a) {
		aktiv.add(a);
	}

	// Függvény, aminek meghívásával jelezhetjük a játék végét. True-t kell neki
	// átadni, ha a játékos nyert,
	// false-ot ha a játékos vesztett.
	//TODO: ez nincs kész még... 
	public void endgame(boolean nyerte) {
		STOP=true;
	}


}
