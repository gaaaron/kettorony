package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import szoftlab4.Application;
import szoftlab4.Cella;
import szoftlab4.Game;
import szoftlab4.Mezo;
import szoftlab4.Torony;
import szoftlab4.Ut;

//Window oszt�ly. Ez �p�ti fel az eg�sz keretet, �s j�t�kablakot
public class Window extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game;
	static Window window = null;
	private JFrame frame = new JFrame("K�t Torony");
	private JLabel statusbar;
	static boolean enabled = false;
	private boolean end = false;

//Window oszt�ly publikus konstruktora, melyben p�ld�nyos�tjuk az egyes komponenseket
	public Window(final Game game) {
		window = this;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		this.game = game;
		
		Drawables.getInstance().setGraphics(getGraphics());
		
//A bal oldalon tal�lhat� Menut p�ld�nyos�tjuk, ahol a felhaszn�l� p�ld�ul k�veket tud v�s�rolni, vagy �j tornyot �p�teni
		SideMenu.sideMenu = new SideMenu(game);
		frame.add(SideMenu.sideMenu, BorderLayout.WEST);
		
//A k�z�ps� panelben fog kirajzol�dni maga a j�t�kt�r
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.add(window);
		center.add(panel_1);
		
//Hozz�adjuk az elk�sz�lt elemeket az ablakhoz
		center.setPreferredSize(new Dimension(1000, 768));
		
		JPanel panel_2 = new JPanel();
		center.add(panel_2);
		//window.setPreferredSize(new Dimension(800,650));
		
//Statusbar, ahova az esem�nyek kimenetel�t tudjuk ki�rni. P�ld�ul "Torony l�trehozva"
		statusbar = new JLabel("<html><br/>V�dd meg a Szarum�n hatalm�t a Gy�r� Sz�vets�g�nek gonosz t�mad�sait�l! ..�s j�l vigy�zz! Egy apr� hobbit is sokat sebezhet!</html>");
		panel_2.add(statusbar);
		statusbar.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(center, BorderLayout.CENTER);
//�s l�that�v� tessz�k
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
//MouseListener hozz�ad�sa. A j�t�kt�ren t�rt�n� kattint�sokat fogja feldolgozni, a sideMenuben be�ll�tott �llapotban megfelel�en
        addMouseListener(new MouseAdapter() {

//Akkor dolgozunk, hogyha az egeren kattintottak
            public void mousePressed(MouseEvent e) {
            	Application.return_message.text = null;
//Megn�zz�k hogy hol t�rt�nt kattint�s
            	if(!enabled) return;
            	if(end) return;
            	String[] t = null;
            	int y = e.getX()/70;
            	int x = e.getY()/70;
            	
            	boolean mezo = false;
            	Cella c = game.jatekter.cellak.get(x).get(y);
            	if(c instanceof Mezo) mezo = true;
       
//�s a sideMenuben be�ll�tott �rt�knek megfelel�en fel�p�tjuk a parancst�mb�t, �s megh�vjuk a parancsot
            	switch(SideMenu.whatwhat){
            	case 0: break;
//Csapda hozz�ad�sa a j�t�kt�rhez
            	case 1: 
            		if(!mezo){
            		t = new String[4];
            		t[0] = new String("addtrap");
            		t[1] = new String(Long.toString(System.currentTimeMillis()));
            		t[2] = new String(Integer.toString(x));
            		t[3] = new String(Integer.toString(y));
            		Application.addtrap(t, Application.return_message);
            		}
            		else Application.return_message.text="Mez�re nem tehetsz akad�lyt";
            		break;
//�j torony hozz�ad�sa a j�t�kt�rhez
            	case 2:
              		t = new String[4];
              		if(mezo){
            		t[0] = new String("addtower");
            		t[1] = new String(Long.toString(System.currentTimeMillis()));
            		t[2] = new String(Integer.toString(x));
            		t[3] = new String(Integer.toString(y));
            		Application.addtower(t, Application.return_message);
              		}
              		else Application.return_message.text="�tra nem tehetsz tornyot";
            		break;
            		
//Torony fejleszt�se a kiv�lasztott k�vel
            	case 3:
          			Torony torony = null;
          			Mezo m = null;
          			String id = null;
              		t = new String[3];
              		int index = 0;
              		if(mezo){
              			m = (Mezo)c;
              			for(int i = 0;i<m.rajtamvan.size();i++)
              				if(m.rajtamvan.get(i) instanceof Torony) {
              					torony = (Torony)m.rajtamvan.get(i);
              					index = i;
              				}
              		}
            		
              		if(torony!=null){
              			t[0] = new String("addtowergem");
                		t[1] = new String(torony.id);
                		switch(SideMenu.combo.getSelectedIndex()){
                		case 0: t[2] = new String("barna");break;
                		case 1: t[2] = new String("kek");break;
                		case 2: Application.return_message.text = "Ide nem tehetsz toronyk�vet"; return;
                		case 3: t[2] = new String("narancs");break;
                		case 4: t[2] = new String("piros");break;
                		case 5: t[2] = new String("sarga");break;
                		case 6: t[2] = new String("zold");break;
                		default: Application.return_message.text = "ERROR";
                		}
                		Application.addtowergem(t, Application.return_message);
              		}
              		else Application.return_message.text = "Ide nem tehetsz toronyk�vet";
            		
            		break;
//Akad�ly fejleszt�se hogyha a lila k� van kiv�lasztva, �s a felhaszn�l� birtokol ilyen sz�n� k�vet
            	case 4: 
              		t = new String[2];
              		if(!mezo){
              		Ut u = (Ut)c;
              		if(u.akadaly!=null){
            		t[0] = new String("addtrapgem");
            		t[1] = new String(u.akadaly.id);
            		Application.addtrapgem(t, Application.return_message);
              		}
              		}
              		else Application.return_message.text = "Ide nem tehetsz akad�lyk�vet";
            		
            		break;
            	}
            	if(Application.return_message.text != null) statusbar.setText("<html><br/>"+Application.return_message.text+"</html>");
                repaint();
            }

//Az eg�r felenged�s�re nem t�rt�nik semmi
            public void mouseReleased(MouseEvent e) {
            }
        });
	}

	public static Graphics getCustomGraphics() {
		if (window == null)
			window = new Window(null);
		return window.getGraphics();
	}
	public static JPanel getPanel() {
		if (window == null)
			window = new Window(null);
		return window;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		if (game.ellensegkeszito.getEnemyNumber() == 0 && game.ellenseglista.isEmpty() && !end) winWindow();
		if (game.hegy != null && game.hegy.getElet()<=0 && !end) gameOver();
		Drawables.getInstance().setGraphics(g);
		Drawables.getInstance().setMapSize(game.jatekter.cellak.size() * game.jatekter.cellak.get(0).size());	

			for (int i = 0; i < Drawables.getInstance().getSize(); i++){
				Drawables.getInstance().get(i).paint();
				//Drawables.getInstance().remove(i);
			}
			
			
	}

	private void gameOver() {
		end = true;
		game.controller.endgame(true);
		JDialog frame = new JDialog(this.frame,"Vesz�tett�l!",Dialog.ModalityType.APPLICATION_MODAL);
		JLabel label = new JLabel("Sajn�lom, a j�t�k v�get �rt!");
		label.setFont(new Font("Serif", Font.PLAIN, 24));
		frame.setMinimumSize(new Dimension(200, 150));
		frame.getContentPane().add(label,BorderLayout.CENTER);
		frame.pack();
		frame.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
		frame.setVisible(true);
		frame.setModal(true);
		
		
		
	}

	private void winWindow() {
		game.controller.endgame(true);
		end = true;
		JDialog frame = new JDialog(this.frame,"Nyert�l!",Dialog.ModalityType.APPLICATION_MODAL);
		JLabel label = new JLabel("Gratul�lok, nyert�l!");
		label.setFont(new Font("Serif", Font.PLAIN, 24));
		frame.setMinimumSize(new Dimension(200, 150));
		frame.getContentPane().add(label,BorderLayout.CENTER);
		frame.pack();
		frame.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
		frame.setVisible(true);
		frame.setModal(true);

		
	}
	
	
}
