package szoftlab4;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;

public class TesztAblak extends JFrame {

	public JPanel contentPane;
	public JTextPane palya;
	public JTextPane status;
	public boolean isVisible;

	/**
	 * Create the frame.
	 */
	public TesztAblak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		palya = new JTextPane();
		contentPane.add(palya);
		
		status = new JTextPane();
		contentPane.add(status);
		isVisible=false;
	}

}
