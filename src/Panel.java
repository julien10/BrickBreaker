import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

//import Niveau.ClavierListener;


public class Panel extends JPanel {
	
	private Niveau niveau = new Niveau();
	private JTextField control = new JTextField();
	@Override
	protected void paintComponent(Graphics g) {
		if(niveau == null) {
			return;
		}
		super.paintComponent(g);
		for(GameObject o : niveau.briques) {
			int px = (int)(o.getPosX());
			int py = (int)(o.getPosY());
			g.drawRect(px, py, 40, 20);
		}
		int x = (int) niveau.raquette.getPosX();
		int y = (int) niveau.raquette.getPosY();
		g.fillRoundRect(x, y, 150, 10,15,15);
		
		control.addKeyListener(new ClavierListener());
		this.add(control);
		// 39 droite, 37 gauche
	}
	
	 class ClavierListener implements KeyListener {
		 public void keyPressed(KeyEvent e) {
			 if (e.getKeyCode() == 37) {
				 niveau.raquette.setPosX(niveau.raquette.getPosX()-10);
			 }
			 else if (e.getKeyCode() == 39) {
				 niveau.raquette.setPosX(niveau.raquette.getPosX()+10);
			 }
		 }
		 
		 public void keyReleased(KeyEvent e) {}
		 public void keyTyped(KeyEvent e) {}
	 }
}