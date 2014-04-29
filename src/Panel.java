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
	boolean pauseEnfoncee ;
	
	private Image pokeball;
	private Image brick1;
	private Image brick2;
	private Image brick3;
	private Image bonus;
	private Image brick4;
	
	public Panel(Niveau niveau) {
		addKeyListener(new ClavierListener());
		this.niveau = niveau;
		boolean pauseEnfoncee = false;
		
		try {
			pokeball = ImageIO.read(new File("pokeball.png"));
			brick1 = ImageIO.read(new File("briquerouge1.png"));
			brick2 = ImageIO.read(new File("briquerouge2.png"));
			brick3 = ImageIO.read(new File("briquerouge3.png"));
			bonus = ImageIO.read(new File("bonus.png"));
			brick4 = ImageIO.read(new File("briqueunbreakable.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(niveau == null)
			return;

			
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
				if (o instanceof BrickResistance) {
					if (((BrickResistance) o).getResistance() == 1)
						g.drawImage(brick1, px, py, null);
					else if (((BrickResistance) o).getResistance() == 2)
						g.drawImage(brick2, px, py, null);
					else if (((BrickResistance) o).getResistance() == 3)
						g.drawImage(brick3, px, py, null);
				}
				else if (o instanceof BrickUnbreakable)
					g.drawImage(brick4,px,py,null);
				else
					g.drawImage(brick1, px, py, null);
			}
		}
		

		for(Brick o : niveau.bonus) {
			int px = (int)(o.getPosX());
			int py = (int)(o.getPosY());
//				g.drawRect(px, py, o.getLongueur(), o.getHauteur());
			g.drawImage(bonus,px,py,null);
		}

		g.setColor(Color.white);
		

		if (niveau.raquette.getLives() >= 0) {
			int x = (int) niveau.raquette.getPosX();
			int y = (int) niveau.raquette.getPosY();
			g.fillRoundRect(x, y, niveau.raquette.getLongueur(), niveau.raquette.getHauteur(),15,15);
		}
	}
	
	
	 class ClavierListener implements KeyListener {
		 public void keyPressed(KeyEvent e) {
			 if (e.getKeyCode() == 37) {
				 gaucheEnfoncee = true;
			 }
			 else if (e.getKeyCode() == 39) {
				 droiteEnfoncee = true;
			 }
			 if (e.getKeyCode() == KeyEvent.VK_P && pauseEnfoncee == false){
				 pauseEnfoncee = true;
			 }
			 else if (e.getKeyCode() == KeyEvent.VK_P && pauseEnfoncee == true){
				 pauseEnfoncee = false;
			 }
		 }
		 
		 public void keyReleased(KeyEvent e) {
			 if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				 gaucheEnfoncee = false;
			 }
			 else if (e.getKeyCode() == 39) {
				 droiteEnfoncee = false;
			 }

		 }
		 public void keyTyped(KeyEvent e) {}
	 }
	 
}
