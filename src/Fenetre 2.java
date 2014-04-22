import java.awt.Color;

import javax.swing.JFrame;


public class Fenetre extends JFrame {
	private Panel panel = new Panel();
	
	public Fenetre(Niveau niveau) {
		this.setTitle("Casse-Briques");
		this.setSize(800,600);
		panel.setBackground(Color.black);
		this.setContentPane(panel);
		setVisible(true);
	}
		

}
