package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import szoftlab4.Game;

public class SideMenu extends JPanel {
	static SideMenu sideMenu = null;
	private Game game;
	
	public JLabel varazsero;
	
	public JLabel zoldcount;
	public JLabel kekcount;
	public JLabel sargacount;
	public JLabel piroscount;
	public JLabel narancscount;
	public JLabel barnacount;
	public JLabel lilacount;
	
	
	
	public SideMenu(Game game){	
		this.game =game;
		sideMenu=this;
		setLayout(null);
		setPreferredSize(new Dimension(130, 23));
		setBackground(Color.WHITE);
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setAlignmentY(0.0f);
		panel_1.setBounds(0, 0, 125, 60);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("\u00DAj j\u00E1t\u00E9k");
		button.setSize(new Dimension(95, 23));
		button.setPreferredSize(new Dimension(95, 23));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Arial", Font.BOLD, 11));
		button.setBackground(new Color(204, 204, 204));
		panel_1.add(button);
		
		JButton button_1 = new JButton("Kil\u00E9p\u00E9s");
		button_1.setSize(new Dimension(95, 23));
		button_1.setPreferredSize(new Dimension(95, 23));
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Arial", Font.BOLD, 11));
		button_1.setBackground(new Color(204, 204, 204));
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setAlignmentY(0.0f);
		panel_2.setBounds(0, 71, 125, 279);
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("K\u0151 v\u00E1s\u00E1rl\u00E1s");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		panel_2.add(label);

		JLabel label_1 = new JLabel("Toronyk\u00F6vek");
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_2.add(label_1);
		
		JButton button_2 = new JButton("z\u00F6ld");
		button_2.setIcon(new ImageIcon("img\\zold.png"));
		button_2.setToolTipText("N\u00F6veli a torony hat\u00F3t\u00E1vols\u00E1g\u00E1t.");
		button_2.setSize(new Dimension(95, 23));
		button_2.setPreferredSize(new Dimension(95, 23));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Arial", Font.PLAIN, 10));
		button_2.setBackground(new Color(204, 204, 204));
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("k\u00E9k");
		button_3.setIcon(new ImageIcon("img\\kek.png"));
		button_3.setToolTipText("N\u00F6veli a torony emberen ejtett sebz\u00E9s\u00E9t.");
		button_3.setSize(new Dimension(95, 23));
		button_3.setPreferredSize(new Dimension(95, 23));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Arial", Font.PLAIN, 10));
		button_3.setBackground(new Color(204, 204, 204));
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("s\u00E1rga");
		button_4.setIcon(new ImageIcon("img\\sarga.png"));
		button_4.setToolTipText("N\u00F6veli a torony t\u00FCzel\u00E9si gyakoris\u00E1g\u00E1t.");
		button_4.setSize(new Dimension(95, 23));
		button_4.setPreferredSize(new Dimension(95, 23));
		button_4.setHorizontalAlignment(SwingConstants.LEFT);
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Arial", Font.PLAIN, 10));
		button_4.setBackground(new Color(204, 204, 204));
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("piros");
		button_5.setIcon(new ImageIcon("img\\piros.png"));
		button_5.setToolTipText("N\u00F6veli a torony t\u00F6rp\u00E9n ejtett seb\u00E9s\u00E9t.");
		button_5.setSize(new Dimension(95, 23));
		button_5.setPreferredSize(new Dimension(95, 23));
		button_5.setHorizontalAlignment(SwingConstants.LEFT);
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Arial", Font.PLAIN, 10));
		button_5.setBackground(new Color(204, 204, 204));
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("narancs");
		button_6.setIcon(new ImageIcon("img\\narancs.png"));
		button_6.setToolTipText("N\u00F6veli a torony t\u00FCnd\u00E9n ejtett sebz\u00E9s\u00E9t.");
		button_6.setSize(new Dimension(95, 23));
		button_6.setPreferredSize(new Dimension(95, 23));
		button_6.setHorizontalAlignment(SwingConstants.LEFT);
		button_6.setForeground(Color.BLACK);
		button_6.setFont(new Font("Arial", Font.PLAIN, 10));
		button_6.setBackground(new Color(204, 204, 204));
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("barna");
		button_7.setIcon(new ImageIcon("img\\barna.png"));
		button_7.setToolTipText("N\u00F6veli a torony hobbiton ejtett sebz\u00E9s\u00E9t.");
		button_7.setSize(new Dimension(95, 23));
		button_7.setPreferredSize(new Dimension(95, 23));
		button_7.setHorizontalAlignment(SwingConstants.LEFT);
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Arial", Font.PLAIN, 10));
		button_7.setBackground(new Color(204, 204, 204));
		panel_2.add(button_7);
		
		JLabel label_2 = new JLabel("Akad\u00E1lyk\u0151");
		label_2.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_2.add(label_2);
		
		JButton button_8 = new JButton("lila");
		button_8.setIcon(new ImageIcon("img\\lila.png"));
		button_8.setToolTipText("N\u00F6veli az akad\u00E1ly \u00E1ltal lass\u00EDthat\u00F3 ellenfelek sz\u00E1m\u00E1t.");
		button_8.setSize(new Dimension(95, 23));
		button_8.setPreferredSize(new Dimension(95, 23));
		button_8.setHorizontalAlignment(SwingConstants.LEFT);
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Arial", Font.PLAIN, 10));
		button_8.setBackground(new Color(204, 204, 204));
		panel_2.add(button_8);
		add(panel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 105, 2);
		add(separator);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 361, 125, 272);
		panel_3.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_3.setBackground(Color.WHITE);
		
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("J\u00E1t\u00E9kos         ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(lblNewLabel);
		
		JLabel lblVarzser = new JLabel("Var\u00E1zser\u0151:");
		lblVarzser.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblVarzser);
		
		varazsero = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazsero));
		varazsero.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(varazsero);
		
		JLabel lblZldVarzsk = new JLabel("Z\u00F6ld var\u00E1zsk\u0151: ");
		lblZldVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblZldVarzsk);
		
		zoldcount = new JLabel("  1");
		zoldcount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(zoldcount);
		
		JLabel lblKkVarzsk = new JLabel("K\u00E9k var\u00E1zsk\u0151: ");
		lblKkVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblKkVarzsk);
		
		kekcount = new JLabel("  1");
		kekcount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(kekcount);
		
		JLabel lblSrgaVarzsk = new JLabel("S\u00E1rga var\u00E1zsk\u0151: ");
		lblSrgaVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblSrgaVarzsk);
		
		sargacount = new JLabel("  1");
		sargacount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(sargacount);
		
		JLabel lblPirosVarzsk = new JLabel("Piros var\u00E1zsk\u0151: ");
		lblPirosVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblPirosVarzsk);
		
		piroscount = new JLabel("  1");
		piroscount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(piroscount);
		
		JLabel lblNarancsVarzsk = new JLabel("Narancs var\u00E1zsk\u0151: ");
		lblNarancsVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblNarancsVarzsk);
		
		narancscount = new JLabel("  1");
		narancscount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(narancscount);
		
		JLabel lblBarnaVarzsk = new JLabel("Barna var\u00E1zsk\u0151: ");
		lblBarnaVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblBarnaVarzsk);
		
		barnacount = new JLabel("  1");
		barnacount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(barnacount);
		
		JLabel lblLilaVarzsk = new JLabel("Lila var\u00E1zsk\u0151: ");
		lblLilaVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblLilaVarzsk);
		
		lilacount = new JLabel("  1");
		lilacount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lilacount);
		
		add(panel_3);
	}
}
