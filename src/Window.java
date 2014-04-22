import java.awt.Color;

import javax.swing.JFrame;


public class Window extends JFrame {
	private Panel panel = new Panel();
	
	public Window(Niveau niveau) {
		this.setTitle("Casse-Briques");
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel.setBackground(Color.black);
		this.setContentPane(panel);
		setVisible(true);
	}
		

}
