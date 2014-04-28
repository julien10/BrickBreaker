import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Fenetre extends JFrame implements ActionListener {
	private Panneau pan = new Panneau();
	private JButton play = new JButton();
	public Fenetre() {
		this.setTitle("Brick Breaker Pokemon");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setContentPane(pan);
		Icon playimg = new ImageIcon("play.png");
		play.setIcon(playimg);
		play.setLayout(null);
		play.setBorder(BorderFactory.createEmptyBorder());
		play.setContentAreaFilled(false);
		this.add(play);
		play.setBounds(200, 570, 150, 82);
		play.addActionListener(this);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg) {
		getContentPane().removeAll();
		ChoixTheme choix;
		try {
			choix = new ChoixTheme();
			getContentPane().add(choix);
			System.out.println("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		((JComponent) getContentPane()).revalidate();
		getContentPane().repaint();
		
//		this.dispose();
//		Niveau niveau = new Niveau();
//		new Window(niveau);
		//System.out.println("Yo");
	}
}
