package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import szoftlab4.Application;
import szoftlab4.Cella;
import szoftlab4.Game;
import szoftlab4.Mezo;
import szoftlab4.Torony;
import szoftlab4.Ut;

public class Window extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game;
	static Window window = null;
	private JFrame frame = new JFrame("Két Torony");
	private JLabel statusbar;
	boolean voltmar = false;

	public Window(final Game game) {
		window = this;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		this.game = game;

		Drawables.getInstance().setGraphics(getGraphics());
		
		SideMenu.sideMenu = new SideMenu(game);
		frame.add(SideMenu.sideMenu, BorderLayout.WEST);
		
		JPanel center = new JPanel();
		//window.setPreferredSize(new Dimension(800,650));
		statusbar = new JLabel("<html><br/>Védd meg a Szarumán hatalmát a Gyûrû Szövetségének gonosz támadásaitól! ..És jól vigyázz! Egy apró hobbit is sokat sebezhet!</html>");
		statusbar.setFont(new Font("Arial", Font.BOLD, 12));
		
		center.add(window, BorderLayout.CENTER);
		center.add(statusbar, BorderLayout.SOUTH);
		frame.add(center, BorderLayout.CENTER);
		
		// this.getGraphics().
		frame.pack();
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(900, 670));
		frame.setMinimumSize(new Dimension(900, 670));
		
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
            	Application.return_message.text = null;
            	String[] t = null;
            	int y = e.getX()/70;
            	int x = e.getY()/70;
            	
            	boolean mezo = false;
            	Cella c = game.jatekter.cellak.get(x).get(y);
            	if(c instanceof Mezo) mezo = true;
            	
            	switch(SideMenu.whatwhat){
            	case 0: break;
            	case 1: 
            		if(!mezo){
            		t = new String[4];
            		t[0] = new String("addtrap");
            		t[1] = new String(Long.toString(System.currentTimeMillis()));
            		t[2] = new String(Integer.toString(x));
            		t[3] = new String(Integer.toString(y));
            		Application.addtrap(t, Application.return_message);
            		}
            		else Application.return_message.text="Mezõre nem tehetsz akadályt";
            		break;
            	case 2:
              		t = new String[4];
              		if(mezo){
            		t[0] = new String("addtower");
            		t[1] = new String(Long.toString(System.currentTimeMillis()));
            		t[2] = new String(Integer.toString(x));
            		t[3] = new String(Integer.toString(y));
            		Application.addtower(t, Application.return_message);
              		}
              		else Application.return_message.text="Útra nem tehetsz tornyot";
            		break;
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
                		case 3: t[2] = new String("narancs");break;
                		case 4: t[2] = new String("piros");break;
                		case 5: t[2] = new String("sarga");break;
                		case 6: t[2] = new String("zold");break;
                		default: Application.return_message.text = "ERROR";
                		}
                		Application.addtowergem(t, Application.return_message);
              		}
              		else Application.return_message.text = "Ide nem tehetsz toronykövet";
            		
            		break;
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
              		else Application.return_message.text = "Ide nem tehetsz akadálykövet";
            		
            		break;
            	}
            	if(Application.return_message.text != null) statusbar.setText("<html><br/>"+Application.return_message.text+"</html>");
                repaint();
            }

            @Override
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
		Drawables.getInstance().setGraphics(g);

			for (int i = 0; i < Drawables.getInstance().getSize(); i++){
				Drawables.getInstance().get(i).paint();
				//Drawables.getInstance().remove(i);
			}
			
			
		voltmar = true;
	}
	
	
}
