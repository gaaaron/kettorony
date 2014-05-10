package szoftlab4;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import view.Window;

/*
 *	Prototípus fõprogram
 */
public class Application {

	public static Game game = new Game();
	public static TesztAblak ablak;
	public static Message return_message;

	/*
	 * Prototípus konzolos felületének parancsai
	 */
	private static enum Code {
		loadmap(1), printstate(0), tick(0), printpower(0), printgems(0), buygem(1), addtower(3), addtowergem(2), addtrap(3),
		addtrapgem(2), addenemy(4), addspecialprojectile(1), addfog(1), enemydirection(2), exit(0), error(0), enter(0), show(0), magic(0), showData(0);

		public int param_count; 	//kódszót követõ szükséges paraméterek száma
		/*
		 * Paraméterként átadott sztringhez tartozó kódszó visszaadása
		 */
		Code(int pc){
			this.param_count = pc;
		}
		static Code parseString(String par) {
			try {
				if (par.equals(""))
					return enter;
				return valueOf(par);
			} catch (NullPointerException ex) {
				return enter;
			} catch (IllegalArgumentException ex) {
				return error;
			}
		}
	}
	public static class Message{
		public String text;
		public Message(){
			text = null;
		}
	}
	public static void main(String[] args) {
		try {
			startProto();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void startProto() throws IOException {
		//System.out.println("A két torony - Prototípus /datcode/");
		//System.out.println("");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Mindenkori
																					// konzolos
																					// bemenetként
																					// szolgál
		boolean exit_flag = false;
		String line = null;
		String[] parancs = null;
		return_message = new Message();

		try {

			while (!exit_flag) {
				try { // A felhasználó választásának beolvasása
					line = br.readLine(); // Egy sor beolvasása
					parancs = line.split("\\s+"); // Sor tördelése szóközök
													// mentén
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				return_message.text = null;
				switch (Code.parseString(parancs[0])) { // parseString() enum
														// típussal tér vissza
				case loadmap:
					if(parancs.length > Code.loadmap.param_count) 		loadmap(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case printstate:
					if(parancs.length > Code.printstate.param_count) 	printstate(return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case tick:
					if(parancs.length > Code.tick.param_count) 			tick(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case printpower:
					return_message.text = null;
					if(parancs.length > Code.printpower.param_count) 	printpower();
					else												return_message.text = "Invalid parameter";
					break;
				case printgems:
					return_message.text = null;
					if(parancs.length > Code.printgems.param_count) 	printgems();
					else												return_message.text = "Invalid parameter";
					break;
				case buygem:
					if(parancs.length > Code.buygem.param_count) 		buygem(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addtower:
					if(parancs.length > Code.addtower.param_count) 		addtower(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addtowergem:
					if(parancs.length > Code.addtowergem.param_count) 	addtowergem(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addtrapgem:
					if(parancs.length > Code.addtrapgem.param_count) 	addtrapgem(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addtrap:
					if(parancs.length > Code.addtrap.param_count) 		addtrap(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addenemy:
					if(parancs.length > Code.addenemy.param_count) 		addenemy(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addspecialprojectile:
					if(parancs.length > Code.addspecialprojectile.param_count) 	addspecialprojectile(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case addfog:
					if(parancs.length > Code.addfog.param_count) 		addfog(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case enemydirection:
					if(parancs.length > Code.enemydirection.param_count) enemydirection(parancs,return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case exit:
					return_message.text = null;
					if(parancs.length > Code.exit.param_count) 			exit();
					else												return_message.text = "Invalid parameter";
					exit_flag = true;
					break;
				case error:
					return_message.text = "Bad command";
					break;
				case enter:
					break;
				case show:
					if(parancs.length > Code.exit.param_count) 			show(return_message);
					else												return_message.text = "Invalid parameter";
					break;
				case magic:
					if(parancs.length > Code.exit.param_count) 			start();
					else												return_message.text = "Invalid parameter";
					break;
				default:
					break;
				}
				
				
				if(return_message.text != null) System.out.println(return_message.text);
				printstate(return_message);
				show(return_message);
			}

		} finally {
			if (br != null)
				br.close();
		}
	}

	public static boolean loadmap(String args[], Application.Message msg) {
		Window w = new Window(game);
		if(Application.game.jatekter.betolt(args[1], msg));
		else return false;
		w.setPreferredSize(new Dimension(game.jatekter.width*70,game.jatekter.height*70));
		w.repaint();
		msg.text = "Map loaded";
		
	
		return true;
	}

	public static void printstate(Application.Message msg) {
		msg.text = "";
		for (int i = 0; i < game.toronylista.size(); i++) {
			int x = game.getCoord(game.toronylista.get(i).sajatMezo).x;
			int y = game.getCoord(game.toronylista.get(i).sajatMezo).y;
			msg.text += ("Torony " + game.toronylista.get(i).id + " " + y
					+ " " + x + "\n");
		}

		for (int i = 0; i < game.ellenseglista.size(); i++) {
			int x = game.getCoord(game.ellenseglista.get(i).sajatUt).x;
			int y = game.getCoord(game.ellenseglista.get(i).sajatUt).y;
			if (game.ellenseglista.get(i) instanceof Hobbit)
				msg.text += ("Hobbit " + game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet + "\n");
			else if (game.ellenseglista.get(i) instanceof Ember)
				msg.text += ("Ember " + game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet + "\n");
			else if (game.ellenseglista.get(i) instanceof Tunde)
				msg.text += ("Tunde "+ game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet + "\n");
			else if (game.ellenseglista.get(i) instanceof Torpe)
				msg.text += ("Torpe " + game.ellenseglista.get(i).id  + " " + y
						+ " " + x + " "+ game.ellenseglista.get(i).elet + "\n");
		}

		for (int i = 0; i < game.akadalylista.size(); i++) {
			int x = game.getCoord(game.akadalylista.get(i).sajatUt).x;
			int y = game.getCoord(game.akadalylista.get(i).sajatUt).y;
			msg.text += ("Akadaly " + game.akadalylista.get(i).id + " " + y +" " +x + "\n");
		}
		
		if(game.hegy != null)
			msg.text += ("Vegzet Hegye " + game.hegy.elet + "\n");
		
	}

	public static boolean tick(String args[], Application.Message msg) {
		int count = 0;
		if (args.length > 1)
			count = Integer.parseInt(args[1]);
		else
			count = 1;
		
		int i = 0;
		for (i = 0; i < count; i++) {
			game.controller.addTick();
		}
		msg.text = (i + " tick megtortent");
		return true;
	}

	public static void printpower() {
		System.out.println("Varazsero " + game.jatekter.felhasznalo.varazsero);
	}

	public static void printgems() {

		int barna = 0;
		int sarga = 0;
		int narancs = 0;
		int kek = 0;
		int piros = 0;
		int zold = 0;
		int lila = 0;

		for (int i = 0; i < game.jatekter.felhasznalo.varazskovek.size(); i++) {
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Barnavarazsko)
				barna++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Sargavarazsko)
				sarga++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Narancsvarazsko)
				narancs++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Kekvarazsko)
				kek++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Pirosvarazsko)
				piros++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Zoldvarazsko)
				zold++;
			if (game.jatekter.felhasznalo.varazskovek.get(i) instanceof Lilavarazsko)
				lila++;
		}

		if (barna != 0)
			System.out.println("Barnavarazsko " + barna);
		if (kek != 0)
			System.out.println("Kekvarazsko " + kek);
		if (lila != 0)
			System.out.println("Lilavarazsko " + lila);
		if (narancs != 0)
			System.out.println("Narancsvarazsko " + narancs);
		if (piros != 0)
			System.out.println("Pirosvarazsko " + piros);
		if (sarga != 0)
			System.out.println("Sargavarazsko " + sarga);
		if (zold != 0)
			System.out.println("Zoldvarazsko " + zold);

	}

	public static boolean buygem(String args[], Application.Message msg) {	
		if(game.jatekter.felhasznalo.varazsero < 30){
			msg.text = "Nincs eleg varazsero";
			return false;
		}
		
		if (args[1].matches("barna")){
			game.jatekter.felhasznalo.varazskovek.add(new Barnavarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else if (args[1].matches("kek")){
			game.jatekter.felhasznalo.varazskovek.add(new Kekvarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else if (args[1].matches("lila")){
			game.jatekter.felhasznalo.varazskovek.add(new Lilavarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else if (args[1].matches("narancs")){
			game.jatekter.felhasznalo.varazskovek.add(new Narancsvarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else if (args[1].matches("piros")){
			game.jatekter.felhasznalo.varazskovek.add(new Pirosvarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else if (args[1].matches("sarga")){
			game.jatekter.felhasznalo.varazskovek.add(new Sargavarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else if (args[1].matches("zold")){
			game.jatekter.felhasznalo.varazskovek.add(new Zoldvarazsko());
			game.jatekter.felhasznalo.varazserotVeszit(30);
		}
		else{
			msg.text = "Nincs ilyen kotipus";
			return false;
		}

		msg.text = "Varazsko megvasarolva";
		return true;
	}



	public static boolean addtower(String args[], Application.Message msg) {
		int sor = Integer.parseInt(args[2]);
		int oszlop = Integer.parseInt(args[3]);
		boolean joid = true;

		for (int i = 0; i < game.toronylista.size(); i++) {
			if (game.toronylista.get(i).id.matches(args[1]))
				joid = false;
		}

		if (joid) {
			Torony uj = new Torony(args[1]);
			
			Cella valasztott = game.jatekter.cellak.get(sor).get(oszlop);
			if (valasztott.mezovagyok()){
				if(game.jatekter.felhasznalo.ujTorony((Mezo) valasztott, uj,msg)){
					game.toronylista.add(uj);
					uj.init((Mezo) valasztott);
					game.controller.aktiv.add(uj);
					return true;
				}
				else{
					return false;
				}

			}
			else{
				msg.text = "Parameter nem mezot jelol";
				return false;
			}
		} else {
			msg.text = "Mar letezo ID";
			return false;
		}
	}

	public static boolean addtowergem(String args[], Application.Message msg) {
		boolean megvan = false;
		boolean vanbenne = false;
		int iindex = 0;
		
		Toronykovek ko;

		if (args[2].matches("barna")) {
			for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
				if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Barnavarazsko)
				{
					vanbenne = true;
					iindex = i;
				}
			}
		}
		else if (args[2].matches("kek")) {
			for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
				if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Kekvarazsko)
				{
					vanbenne = true;
					iindex = i;
				}
			}
		}
		else if (args[2].matches("narancs")) {
			for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
				if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Narancsvarazsko)
				{
					vanbenne = true;
					iindex = i;
				}
			}
		}
		else if (args[2].matches("piros")) {
			for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
				if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Pirosvarazsko)
				{
					vanbenne = true;
					iindex = i;
				}
			}
		}
		else if (args[2].matches("sarga")) {
			for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
				if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Sargavarazsko)
				{
					vanbenne = true;
					iindex = i;
				}
			}
		}
		else if (args[2].matches("zold")) {
			for(int i = 0;i<game.jatekter.felhasznalo.varazskovek.size();i++){
				if(game.jatekter.felhasznalo.varazskovek.get(i) instanceof Zoldvarazsko)
				{
					vanbenne = true;
					iindex = i;
				}
			}
		}
		else{
			msg.text ="Nincs ilyen kotipus";
			return false;
		}
		

		
		if (vanbenne) {

			Toronykovek toronyko = (Toronykovek)game.jatekter.felhasznalo.varazskovek.get(iindex);
			
			for(Torony a : game.toronylista){
				if (a.id.equals(args[1])){
					game.jatekter.felhasznalo.fejleszt(a, toronyko);
					game.jatekter.felhasznalo.varazskovek.remove(iindex);
					msg.text = "Varazsko hozzaadva";
					megvan = true;
					return true;
				}
			}
			
			if (megvan == false) {
				msg.text = "Nem letezo ID";
				return false;
			}
			return true;
		} else {
			msg.text = "Nem letezo varazsko";
			return false;
		}

	}

	public static boolean addtrapgem(String args[], Application.Message msg) {
		boolean megvan = false;
		Lilavarazsko l = new Lilavarazsko();
		if (game.jatekter.felhasznalo.varazskovek.contains(l)) {

			for(Akadaly a : game.akadalylista){
				if (a.id.equals(args[1])){
					a.addko(l);
					game.jatekter.felhasznalo.varazskovek.remove(l);
					msg.text = "Varazsko hozzaadva";
					megvan = true;
					return true;
				}
			}
			
			if (megvan == false) {
				msg.text = "Nem letezo ID";
				return false;
			}
			return true;
		} else {
			msg.text = "Nem letezo varazsko";
			return false;
		}
	}

	public static boolean addenemy(String args[], Application.Message msg) {
		int sor = Integer.parseInt(args[3]);
		int oszlop = Integer.parseInt(args[4]);
		Cella valasztott = (Ut)game.jatekter.cellak.get(sor).get(oszlop);
		if (!valasztott.mezovagyok()) {
			int type = 0;
			if (args[1].matches("hobbit"))
				type = 0;
			else if (args[1].matches("ember"))
				type = 1;
			else if (args[1].matches("tunde"))
				type = 2;
			else if (args[1].matches("torpe"))
				type = 3;
			else{
				msg.text = "Bad parameter";
				return false;
			}

			switch (type) {
			case 0:
				Hobbit h = new Hobbit((Ut) valasztott);
				game.controller.aktiv.add(h);
				h.id = args[2];
				valasztott.ratesz(h);
				game.ellenseglista.add(h);
				break;
			case 1:
				Ember e = new Ember((Ut) valasztott);
				game.controller.aktiv.add(e);
				e.id = args[2];
				valasztott.ratesz(e);
				game.ellenseglista.add(e);
				break;
			case 2:
				Tunde t = new Tunde((Ut) valasztott);
				game.controller.aktiv.add(t);
				t.id = args[2];
				valasztott.ratesz(t);
				game.ellenseglista.add(t);
				break;
			case 3:
				Torpe t1 = new Torpe((Ut) valasztott);
				game.controller.aktiv.add(t1);
				t1.id = args[2];
				valasztott.ratesz(t1);
				game.ellenseglista.add(t1);
				break;
			default:
				msg.text = "Bad parameter";
				return false;
			}
			
			msg.text = "Ellenseg letrehozva";
			return true;

		} else {
			msg.text= "Parameter nem utat jelol";
			return false;
		}

	}

	public static boolean addspecialprojectile(String args[], Application.Message msg) {
		Torony ebben = null;
		boolean megvan = false;
		for (int i = 0; i < game.toronylista.size(); i++) {
			if (args[1].matches(game.toronylista.get(i).id)){
				ebben = game.toronylista.get(i);
				megvan = true;
			}
		}
		if(megvan){
			ebben.specprojectile = true;
			msg.text = "Specialis lovedek hozzaadva";
			return true;
		}
		else{
			msg.text = "Nem letezo ID";
			return false;
		}

	}

	public static boolean addfog(String args[], Application.Message msg) {
		boolean megvan = false;
		int index = 0;
		
		while (megvan == false && index < game.toronylista.size()) {
			if (game.toronylista.get(index).id.matches(args[1])) {
				game.toronylista.get(index).kodosit();
				megvan = true;
			} else {
				index++;
			}
		}
		
		if (!megvan){
			msg.text = "Nem letezo ID";
			return false;
		}
		else{
			msg.text = "Kod hozzaadva";
			return true;
		}
	}

	public static boolean enemydirection(String args[], Application.Message msg) {
		boolean megvan = false;
		int index = 0;
		for (Ellenseg ell : game.ellenseglista) {
			if (ell.id.matches(args[1])) {
				index = game.ellenseglista.indexOf(ell);
				megvan = true;
			}
		}

		if (megvan){
			Ellenseg temp = game.ellenseglista.get(index);
			if (args[2].matches("N"))
				temp.irany = 1;
			else if (args[2].matches("S"))
				temp.irany = 2;
			else if (args[2].matches("E"))
				temp.irany = 3;
			else if (args[2].matches("W"))
				temp.irany = 4;
			else
				temp.irany = 0;

			msg.text = "Ellenseg iranya beallitva";
			return true;
		} 
		else{
			msg.text = "Nem letezo ID";
			return false;
		}


	}
	public static boolean addtrap(String[] args, Application.Message msg) {
		int sor = Integer.parseInt(args[2]);
		int oszlop = Integer.parseInt(args[3]);
		boolean joid = true;

		for (int i = 0; i < game.akadalylista.size(); i++) {
			if (game.akadalylista.get(i).id.matches(args[1]))
				joid = false;
		}

		if (joid) {
			Akadaly uj = new Akadaly(args[1]);
			Cella valasztott = game.jatekter.cellak.get(sor).get(oszlop);
			if (!valasztott.mezovagyok()){
				if(game.jatekter.felhasznalo.ujAkadaly((Ut) valasztott, uj,msg)){
					game.akadalylista.add(uj);
					uj.init((Ut)valasztott);
					return true;
				}
				else{
					return false;
				}
				
			}
			else{
				msg.text= "Parameter nem utat jelol";
				return false;
			}
			
		} else {
			msg.text = "Mar letezo ID";
			return false;
		}
	}

	public static void exit() {
		System.out.println("Szia!");
		System.exit(0);
	}
	
	public static void show(Application.Message message){
		if(ablak == null){
		ablak = new TesztAblak();
		ablak.setVisible(true);
		ablak.isVisible=true;
		}
		showData(message);
		
	}
	
	public static synchronized void showData(Application.Message msg){
		
		String szoveg = new String();
		
		szoveg="    ";
		for(int i=0;i<Application.game.jatekter.cellak.get(0).size();i++){
			szoveg += i+"\t\t";
		}
		szoveg += "\n";
		int j=0;
		
		for(ArrayList<Cella> sor : Application.game.jatekter.cellak){
			szoveg += j+"  ";
			j++;
			for(Cella cella : sor){
				if(cella instanceof Mezo){
					if(((Mezo) cella).rajtamvan.size() == 0) szoveg += "* ";
					else{
						for(Mezorevalo m : ((Mezo) cella).rajtamvan){
							szoveg += ((Torony)m).id + " ";
						}
					}
				}
				else{
					if( ((Ut)cella).akadaly != null) szoveg += ((Ut)cella).akadaly.id + " ";
					
					if(((Ut) cella).rajtamvan.size() == 0 && ((Ut)cella).akadaly == null) szoveg += "# ";
					else{
						for(Utravalo m : ((Ut) cella).rajtamvan){
							//TODO: VégzetHegye is kikerüljön a rajtamvan litából?
							if(m instanceof Ellenseg) szoveg += ((Ellenseg)m).id + " ";
							else if(m instanceof VegzetHegye) szoveg += "V ";
						}
					}
				}
				szoveg += "\t\t";
			}
			szoveg += "\n";
		}
		
		ablak.palya.setText(szoveg);
		ablak.status.setText(msg.text);
		
		
	}
	
	public static void start(){
		Application.game.controller.startTick();
	}

	public static ArrayList<ArrayList<Cella>> getMapCells() {
		
		return Application.game.jatekter.cellak;
	}

}

