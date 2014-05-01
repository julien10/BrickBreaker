import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class Fenetre extends JFrame implements ActionListener {
	private Panneau pan = new Panneau();
	private JButton play = new JButton();
	public ChoixTheme choix;
	
	public Fenetre() {
		this.setTitle("Brick Breaker Pokemon");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		Icon playimg = new ImageIcon("play.png");
		play.setIcon(playimg);
		play.setBorder(BorderFactory.createEmptyBorder());
		play.setContentAreaFilled(false);
		pan.setLayout(null);
		pan.add(play);
		play.setBounds(200, 570, 193, 77);
		play.addActionListener(this);
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg) {
		this.dispose();
		try {
			choix = new ChoixTheme();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Niveau niveau = new Niveau();
//		new Window(niveau);
		//System.out.println("Yo");
	}
}
