import java.awt.Color;

import javax.swing.JFrame;


public class Window extends JFrame {
	private Panel panel = new Panel();
	private Thread t;
	
	public Window(Niveau niveau) {
		this.setTitle("Casse-Briques");
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel.setBackground(Color.black);
		this.setContentPane(panel);
		setVisible(true);
		panel.repaint();
		t.start();
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
