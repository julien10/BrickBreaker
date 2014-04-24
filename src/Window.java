import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Window extends JFrame {
	private Panel panel;
	public Niveau niveau;
	public Timer timer;
	
	public Window(Niveau niveau) {
		this.niveau = niveau;
		this.setTitle("Casse-Briques");
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel(niveau);
		//panel.setBackground(Color.black);
		this.setContentPane(panel);
		setVisible(true);
		panel.requestFocus();
		timer = createTimer();
		timer.start();
	}
	
	private Timer createTimer ()
	  {
	    // Création d'une instance de listener 
	    // associée au timer
	    ActionListener action = new ActionListener () {
	        // Méthode appelée à chaque tic du timer
	        public void actionPerformed (ActionEvent event) {
	        	if (panel.gaucheEnfoncee)
	        		niveau.raquette.setSpeedX(-5);
	        	else if (panel.droiteEnfoncee)
	        		niveau.raquette.setSpeedX(5);
	        	else
	        		niveau.raquette.setSpeedX(0);
	        	
	        	niveau.raquette.setPosX(niveau.newPosX(niveau.raquette));
	        	
	        	niveau.ball.setPosX(niveau.newPosX(niveau.ball));
	        	niveau.ball.setPosY(niveau.newPosY(niveau.ball));
	        	checkRebond(niveau.ball);
	        	panel.repaint();
	        }
	    };
	    return new Timer (30, action);
	  }
	

	public void checkRebond(Ball b) {
		if (b.getSpeedX() < 0 && b.getSpeedY() < 0) {	// vers le haut gauche
			for (GameObject e : niveau.objets) {
				if (b.getPosY() == e.getPosY() + e.getHauteur() && e.getPosX() <= b.getPosX() && b.getPosX() <= e.getPosX() + e.getLongueur()) {
					b.setSpeedY(-b.getSpeedY());
					break;
				}
				if (b.getPosX() == e.getPosX() + e.getLongueur() && e.getPosY() <= b.getPosY() && b.getPosY() <= e.getPosY() + e.getHauteur()) {
					b.setSpeedX(-b.getSpeedX());
					break;
				}
			}
		}
		if (b.getSpeedX() > 0 && b.getSpeedY() < 0) {	// vers le haut droit
			for (GameObject e : niveau.objets) {
				if (b.getPosY() == e.getPosY() + e.getHauteur() && e.getPosX() <= b.getPosX() && b.getPosX() <= e.getPosX() + e.getLongueur()) {
					b.setSpeedY(-b.getSpeedY());
					break;
				}
				if (b.getPosX() + b.getRadius() == e.getPosX() && e.getPosY() <= b.getPosY() && b.getPosY() <= e.getPosY() + e.getHauteur()) {
					b.setSpeedX(-b.getSpeedX());
					break;
				}
			}
		}
		if (b.getSpeedX() > 0 && b.getSpeedY() > 0) {	// vers le bas droit
			for (GameObject e : niveau.objets) {
				if (b.getPosY() + b.getRadius() == e.getPosY() && e.getPosX() < b.getPosX() && b.getPosX() < e.getPosX() + e.getLongueur()) {
					b.setSpeedY(-b.getSpeedY());
					break;
				}
				if (b.getPosX() + b.getRadius() == e.getPosX() && e.getPosY() < b.getPosY() && b.getPosY() < e.getPosY() + e.getHauteur()) {
					b.setSpeedX(-b.getSpeedX());
					break;
				}
			}
		}
		if (b.getSpeedX() < 0 && b.getSpeedY() > 0) {	// vers le bas gauche
			for (GameObject e : niveau.objets) {
				if (b.getPosY() + b.getRadius() == e.getPosY() && e.getPosX() < b.getPosX() && b.getPosX() < e.getPosX() + e.getLongueur()) {
					b.setSpeedY(-b.getSpeedY());
					break;
				}
				if (b.getPosX() == e.getPosX() + e.getLongueur() && e.getPosY() < b.getPosY() && b.getPosY() < e.getPosY() + e.getHauteur()) {
					b.setSpeedX(-b.getSpeedX());
					break;
				}
			}
		}
	}
		

}
