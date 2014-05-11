package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import szoftlab4.Game;

public class SideMenu extends JPanel {
	static SideMenu sideMenu = null;
	private Game game;
	
	public JLabel varazsero;
	public static JComboBox combo;
	
	public JLabel zoldcount;
	public JLabel kekcount;
	public JLabel sargacount;
	public JLabel piroscount;
	public JLabel narancscount;
	public JLabel barnacount;
	public JLabel lilacount;
	
	public static int whatwhat;
	//0:semmi
	//1:újakadály
	//2:újtorony
	//3:fejleszttorony
	//4:fejlesztakadály
	
	
//A SideMenu publikus konstruktora. Példányosítjuk a komponenseket, beállítjuk a tulajdonságaikat.	
	public SideMenu(final Game game){	
		this.game =game;
		sideMenu=this;
		setLayout(null);
		setPreferredSize(new Dimension(130, 23));
		setBackground(Color.WHITE);
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		
//Alapból nincsen kiválasztva semmi funkció
		whatwhat = 0;
		
//Panel a fõmenünek
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setAlignmentY(0.0f);
		panel_1.setBounds(0, 0, 125, 60);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
//Új játék gomb
		final JButton button = new JButton("Indít");
		button.setSize(new Dimension(95, 23));
		button.setPreferredSize(new Dimension(95, 23));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Arial", Font.BOLD, 11));
		button.setBackground(new Color(204, 204, 204));
		panel_1.add(button);
		
//Ha rákattintanak, új játékot kezdünk
		button.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
               if(!Window.enabled){
            	   game.controller.startTick();
            	   Window.enabled = true;
            	   button.setEnabled(false);
               }
            }
        }); 
		
//Kilépés gomb
		JButton button_1 = new JButton("Kil\u00E9p\u00E9s");
		button_1.setSize(new Dimension(95, 23));
		button_1.setPreferredSize(new Dimension(95, 23));
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Arial", Font.BOLD, 11));
		button_1.setBackground(new Color(204, 204, 204));
		
//Ha rákattintanak a kilépés gombra, meglepõ módon kilép :)
        button_1.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
               System.exit(0);
            }
        }); 
		
		panel_1.add(button_1);
		
//Új panel a kövek megvásárlásához
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setAlignmentY(0.0f);
		panel_2.setBounds(0, 71, 125, 400);
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("K\u0151 v\u00E1s\u00E1rl\u00E1s");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		panel_2.add(label);

		JLabel label_1 = new JLabel("Toronyk\u00F6vek");
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_2.add(label_1);
		
//Innentõl kezdve fel vannak sorolva a toronykövek. Rákattintva megvásárlásra kerülnek, hogyha a játékosnak van elegendõ
//varázsereje mûvelethez
		
		JButton button_2 = new JButton("z\u00F6ld");
		button_2.setIcon(new ImageIcon("img\\zold.png"));
		button_2.setToolTipText("N\u00F6veli a torony hat\u00F3t\u00E1vols\u00E1g\u00E1t.");
		button_2.setSize(new Dimension(95, 23));
		button_2.setPreferredSize(new Dimension(95, 23));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Arial", Font.PLAIN, 10));
		button_2.setBackground(new Color(204, 204, 204));
		
        button_2.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("zold");
            }
        }); 
		
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
		
        button_3.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("kek");
            }
        });
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
		
        button_4.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("sarga");
            }
        });
		
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("piros");
		button_5.setIcon(new ImageIcon("img\\piros.png"));
		button_5.setToolTipText("N\u00F6veli a torony t\u00F6rp\u00E9n ejtett sebz\u00E9s\u00E9t.");
		button_5.setSize(new Dimension(95, 23));
		button_5.setPreferredSize(new Dimension(95, 23));
		button_5.setHorizontalAlignment(SwingConstants.LEFT);
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Arial", Font.PLAIN, 10));
		button_5.setBackground(new Color(204, 204, 204));
        button_5.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("piros");
            }
        });
		
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
		
        button_6.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("narancs");
            }
        });
		
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
		
        button_7.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("barna");
            }
        });
		
		panel_2.add(button_7);

//Innentõl a Lila akadály követ tudjuk megvásárolni
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
		
        button_8.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                game.jatekter.felhasznalo.kovetVesz("lila");
            }
        });
		
		panel_2.add(button_8);
		add(panel_1);
		
		JLabel ujpalyaelem = new JLabel("\u00DAj p\u00E1lyaelem");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		panel_2.add(ujpalyaelem);
		
//Új torony gomb. Rákattintva, majd egy mezõt kiválasztva egy tornyot tudunk építeni
		JButton button9 = new JButton("\u00DAj torony");
		button9.setSize(new Dimension(95, 23));
		button9.setPreferredSize(new Dimension(95, 23));
		button9.setForeground(Color.BLACK);
		button9.setFont(new Font("Arial", Font.BOLD, 11));
		button9.setBackground(new Color(204, 204, 204));
		
        button9.addActionListener(new ActionListener() {
         	 
            public void actionPerformed(ActionEvent e)
            {
                whatwhat = 2;
            }
        });
		
		panel_2.add(button9);
		

//Új akadály gomb. Rákattintva, majd egy utat kiválasztva egy új akadály tudunk létrehozni, amennyibe van rá elég suskánk
		JButton button10 = new JButton("\u00DAj akad\u00E1ly");
		button10.setSize(new Dimension(95, 23));
		button10.setPreferredSize(new Dimension(95, 23));
		button10.setForeground(Color.BLACK);
		button10.setFont(new Font("Arial", Font.BOLD, 11));
		button10.setBackground(new Color(204, 204, 204));
        button10.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
                whatwhat = 1;
            }
        });
		
		panel_2.add(button10);

//Fejlesztés funkciót tudjuk kiválasztani, mely segítségével köveket pakolhatunk a játékelemekre.
		JButton button11 = new JButton("Fejleszt\u00E9s");
		button11.setSize(new Dimension(95, 23));
		button11.setPreferredSize(new Dimension(95, 23));
		button11.setForeground(Color.BLACK);
		button11.setFont(new Font("Arial", Font.BOLD, 11));
		button11.setBackground(new Color(204, 204, 204));
		
        button11.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	if(combo.getSelectedIndex() == 2)
            		whatwhat = 4;
            	else whatwhat = 3;
            	
            }
        });
		
		panel_2.add(button11);
	
//Itt tudjuk kiválasztani hogy milyen kõvel szeretnék felszerelni a pályaelemeket.
		String[] ko = { "Barna", "K\u00E9k", "Lila", "Narancs", "Piros", "S\u00E1rga", "Z\u00F6ld"};
		combo = new JComboBox(ko);
		
	    combo.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent arg0) {
	            if(combo.getSelectedIndex() == 2) whatwhat = 4;
	            else whatwhat = 3;
	        }
	    });
		
		panel_2.add(combo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 105, 2);
		add(separator);
		
//Panel, mely a felhasználó birtokában lévõ dolgokat mutatja ki
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 450, 125, 272);
		panel_3.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_3.setBackground(Color.WHITE);
		
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("J\u00E1t\u00E9kos         ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(lblNewLabel);
	
//Itt írjuk ki a játékos varázserejét
		
		JLabel lblVarzser = new JLabel("Var\u00E1zser\u0151:");
		lblVarzser.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblVarzser);
		
		varazsero = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazsero));
		varazsero.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(varazsero);
		
		
//Az itt következõ részben íratjuk ki a felhasználó által birtokolt varázskövek mennyiségét
		JLabel lblZldVarzsk = new JLabel("Z\u00F6ld var\u00E1zsk\u0151: ");
		lblZldVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblZldVarzsk);
		
		zoldcount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[6]));
		zoldcount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(zoldcount);
		
		JLabel lblKkVarzsk = new JLabel("K\u00E9k var\u00E1zsk\u0151: ");
		lblKkVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblKkVarzsk);
		
		kekcount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[1]));
		kekcount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(kekcount);
		
		JLabel lblSrgaVarzsk = new JLabel("S\u00E1rga var\u00E1zsk\u0151: ");
		lblSrgaVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblSrgaVarzsk);
		
		sargacount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[5]));
		sargacount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(sargacount);
		
		JLabel lblPirosVarzsk = new JLabel("Piros var\u00E1zsk\u0151: ");
		lblPirosVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblPirosVarzsk);
		
		piroscount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[4]));
		piroscount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(piroscount);
		
		JLabel lblNarancsVarzsk = new JLabel("Narancs var\u00E1zsk\u0151: ");
		lblNarancsVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblNarancsVarzsk);
		
		narancscount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[3]));
		narancscount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(narancscount);
		
		JLabel lblBarnaVarzsk = new JLabel("Barna var\u00E1zsk\u0151: ");
		lblBarnaVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblBarnaVarzsk);
		
		barnacount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[0]));
		barnacount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(barnacount);
		
		JLabel lblLilaVarzsk = new JLabel("Lila var\u00E1zsk\u0151: ");
		lblLilaVarzsk.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lblLilaVarzsk);
		
		lilacount = new JLabel(String.format("%4d", game.jatekter.felhasznalo.varazskoszam[2]));
		lilacount.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_3.add(lilacount);
		
		add(panel_3);
	}
}
