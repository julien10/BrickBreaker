import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import Niveau.ClavierListener;


public class Panel extends JPanel {
	
	public int x;
	public int y;
	private Niveau niveau;
	boolean gaucheEnfoncee = false;
	boolean droiteEnfoncee = false;
	boolean pauseEnfoncee;
	boolean fin = false;
	
	
	public Panel(Niveau niveau) {
		addKeyListener(new ClavierListener());
		this.niveau = niveau;
		boolean pauseEnfoncee = false;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image pokeball;
		Image brick1 = null;
		Image brick2 = null;
		Image brick3 = null;
		Image bonusMB;
		Image brick4;
		Image brickCloud;
		Image bonusArgent;
		Image bonusLI;
		Image bonusVie;
		try {
			pokeball = ImageIO.read(new File("pokeball.png"));
			if (main.theme == 2) {
				brick1 = ImageIO.read(new File("briquerouge1big.png"));
				brick2 = ImageIO.read(new File("briquerouge2big.png"));
				brick3 = ImageIO.read(new File("briquerouge3big.png"));
			}
			else if (main.theme == 1) {
				brick1 = ImageIO.read(new File("briqueeau1big.png"));
				brick2 = ImageIO.read(new File("briqueeau2big.png"));
				brick3 = ImageIO.read(new File("briqueeau3big.png"));
			}
			else if (main.theme == 3) {
				brick1 = ImageIO.read(new File("briqueplante1big.png"));
				brick2 = ImageIO.read(new File("briqueplante2big.png"));
				brick3 = ImageIO.read(new File("briqueplante3big.png"));
			}
			bonusMB = ImageIO.read(new File("bonusMB.png"));
			brick4 = ImageIO.read(new File("briqueunbreakablebig.png"));
			brickCloud = ImageIO.read(new File("brickCloud.png"));
			bonusArgent = ImageIO.read(new File("argent.png"));
			bonusLI = ImageIO.read(new File("bonusLI.png"));
			bonusVie = ImageIO.read(new File("vie.png"));
			
			for(GameObject o : niveau.balls) {
				int x2 = (int) o.getPosX();
				int y2 = (int) o.getPosY();

				g.drawImage(pokeball,x2,y2,null);
			}
			
			for(GameObject o : niveau.briques) {
//				if (o.getLongueur() == 40) {
				if (o.getLongueur() == 80) {
					int px = (int)(o.getPosX());
					int py = (int)(o.getPosY());

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
					else if (o instanceof BrickCloud)
						g.drawImage(brickCloud,px,py,null);
					else
						g.drawImage(brick1, px, py, null);
				}
			}
			

			for(Bonus o : niveau.bonus) {
				int px = (int)(o.getPosX());
				int py = (int)(o.getPosY());
				if (o instanceof BonusMB)
					g.drawImage(bonusMB,px,py,null);
				if (o instanceof BonusArgent)
					g.drawImage(bonusArgent,px,py,null);
				if (o instanceof BonusLI)
					g.drawImage(bonusLI,px,py,null);
				if (o instanceof BonusVie)
					g.drawImage(bonusVie,px,py,null);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(niveau == null) {
			return;
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
			 if (e.getKeyCode() == KeyEvent.VK_F)
				 fin = true;
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
