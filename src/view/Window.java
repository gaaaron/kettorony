package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import szoftlab4.Game;

public class Window extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game;
	static Window window = null;
	private JFrame frame = new JFrame("Két Torony");
	boolean voltmar = false;

	public Window(Game game) {
		window = this;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		this.game = game;

		Drawables.getInstance().setGraphics(getGraphics());
		
		SideMenu.sideMenu = new SideMenu(game);
		frame.add(SideMenu.sideMenu, BorderLayout.WEST);
		
		JPanel center = new JPanel();
		window.setPreferredSize(new Dimension(800,600));
		center.add(window, BorderLayout.CENTER);
		frame.add(center, BorderLayout.CENTER);
		
		// this.getGraphics().
		frame.pack();
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(900, 650));
		frame.setMinimumSize(new Dimension(900, 650));
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
			
			System.out.println(Drawables.getInstance().getSize());
		// System.out.println(Drawables.getInstance().getSize());
		voltmar = true;
	}
	
	
}
