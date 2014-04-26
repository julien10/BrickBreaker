import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
		Image pokeball;
		Image brick1;
		Image brick2;
		Image brick3;
		try {
			pokeball = ImageIO.read(new File("pokeball.png"));
			brick1 = ImageIO.read(new File("briquerouge1.png"));
			brick2 = ImageIO.read(new File("briquerouge2.png"));
			brick3 = ImageIO.read(new File("briquerouge3.png"));
			
			for(GameObject o : niveau.balls) {
				int x2 = (int) o.getPosX();
				int y2 = (int) o.getPosY();
//				int diameter = (int) o.getLongueur();
//				g.fillOval(x2, y2, diameter, diameter);
				g.drawImage(pokeball,x2,y2,null);
			}
			
			for(GameObject o : niveau.briques) {
				if (o.getLongueur() == 40) {
					int px = (int)(o.getPosX());
					int py = (int)(o.getPosY());
//					g.drawRect(px, py, o.getLongueur(), o.getHauteur());
					g.drawImage(brick1, px, py, null);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(niveau == null) {
			return;
		}

		for(Brick o : niveau.bonus) {
			int px = (int)(o.getPosX());
			int py = (int)(o.getPosY());
			g.drawRect(px, py, o.getLongueur(), o.getHauteur());
		}
		g.setColor(Color.white);

		if (niveau.raquette.getLives() > 0) {
			int x = (int) niveau.raquette.getPosX();
			int y = (int) niveau.raquette.getPosY();
			g.fillRoundRect(x, y, niveau.raquette.getLongueur(), niveau.raquette.getHauteur(),15,15);
		}
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