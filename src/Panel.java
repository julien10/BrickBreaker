import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

//import Niveau.ClavierListener;


public class Panel extends JPanel {
	
	public int x;
	public int y;
	private Niveau niveau;
	boolean gaucheEnfoncee = false;
	boolean droiteEnfoncee = false;
	
	public Panel(Niveau niveau) {
		addKeyListener(new ClavierListener());
		this.niveau = niveau;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(niveau == null) {
			return;
		}
		for(GameObject o : niveau.briques) {
			int px = (int)(o.getPosX());
			int py = (int)(o.getPosY());
			g.drawRect(px, py, o.getLongueur(), o.getHauteur());
		}
		

		int x = (int) niveau.raquette.getPosX();
		int y = (int) niveau.raquette.getPosY();
		g.fillRoundRect(x, y, niveau.raquette.getLongueur(), niveau.raquette.getHauteur(),15,15);
		
		int x2 = (int) niveau.ball.getPosX();
		int y2 = (int) niveau.ball.getPosY();
		int radius = (int) niveau.ball.getRadius();
		g.fillOval(x2, y2, radius, radius);
		
	}
	
	
	 class ClavierListener implements KeyListener {
		 public void keyPressed(KeyEvent e) {
			 if (e.getKeyCode() == 37) {
				 gaucheEnfoncee = true;
				 System.out.println("touche gauche");
			 }
			 else if (e.getKeyCode() == 39) {
				 droiteEnfoncee = true;
				 System.out.println("touche droite");
			 }
		 }
		 
		 public void keyReleased(KeyEvent e) {
			 if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				 gaucheEnfoncee = false;
				 System.out.println("touche gauche relachée");
			 }
			 else if (e.getKeyCode() == 39) {
				 droiteEnfoncee = false;
				 System.out.println("touche droite relachée");
			 }
		 }
		 public void keyTyped(KeyEvent e) {}
	 }
	 
}