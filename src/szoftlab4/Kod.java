package szoftlab4;

import view.KodView;

public class Kod {
	// Tartalmazza hogy a köd, mennyi ideig él
	private int idotartam;
	private Torony torony;
	private KodView view;

	public Kod(Torony t) {
		torony = t;
		idotartam = 50;
		view = new KodView(this);
	}

	public void letrejottem() {
		torony.kodosit();
	}

	public void tick() {
		if (idotartam == 0) {
			torony.kitisztul();
			torony = null;
			view.notifyChanged();
		}
		idotartam--;
	}
	public Torony getTorony(){
		return torony;
	}
}
