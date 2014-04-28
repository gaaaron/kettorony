package szoftlab4;



import java.util.ArrayList;
import java.lang.Runnable;

public class Controller implements Runnable{
	
	//Az akt�v j�t�kteret tartalmazza
	Jatekter jatekter;
	
	//Az Akt�v elemeket tartalmazza, amelyeknek sz�ks�ge van tick-re.
	ArrayList<Aktiv> aktiv;
	
	//Tick sz�l �s az azt le�ll�t� flag
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
    
    
	//A Controller oszt�ly konstruktora
	public Controller(Jatekter ter) { 
		jatekter = ter;
		aktiv = new ArrayList<Aktiv>();
		STOP = false;
	}

	// P�lya kiv�laszt�sa, j�t�kos felruh�z�sa var�zser�vel
	public void indit(){ 
		int palyaSzam = 0;
			jatekter.betolt(palyaSzam);
			jatekter.felhasznalo.varazserotKap(100);
			startTick();

	}
	
	public void startTick() { // Tick sz�l ind�t�sa
		this.notify();
	}
	
	public void addTick(){	//Minden elem kap egy ticket
		for (Aktiv elem : aktiv) {
			elem.tick();
		}
		Application.game.ellensegkeszito.tick();
	}

	//Egy ellens�g hal�la ut�n, a j�t�kos var�zser�t kap
	public void meghaltam(int ertek) { 

		jatekter.felhasznalo.varazserotKap(ertek);

	}

	//Egy akt�v p�lyaelemet hozz�ad az Akt�v list�hoz
	public void addAktiv(Aktiv a) {
		aktiv.add(a);
	}

	// F�ggv�ny, aminek megh�v�s�val jelezhetj�k a j�t�k v�g�t. True-t kell neki
	// �tadni, ha a j�t�kos nyert,
	// false-ot ha a j�t�kos vesztett.
	//TODO: ez nincs k�sz m�g... 
	public void endgame(boolean nyerte) {
		STOP=true;
	}


}
