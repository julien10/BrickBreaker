import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Window extends JFrame {
	public static Panel panel;
	public Niveau niveau;
	public Timer timer;
	public JPanel container;
	public JPanel infos;
	
	public Window(Niveau niveau) {
		this.niveau = niveau;
		this.setTitle("Casse-Briques");
		this.setSize(1250,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = new JPanel();
		panel = new Panel(niveau);
		infos = new JPanel();
		panel.setPreferredSize(new Dimension(1100, 700));
		infos.setPreferredSize(new Dimension(150, 700));
		infos.setOpaque(false);
		panel.setOpaque(false);
		container.setBackground(Color.yellow);
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		//panel.setBackground(Color.black);
		container.add(panel);
		container.add(infos);
		this.setContentPane(container);
		this.setVisible(true);
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
	        		niveau.raquette.setSpeedX(-6);
	        	else if (panel.droiteEnfoncee)
	        		niveau.raquette.setSpeedX(6);
	        	else
	        		niveau.raquette.setSpeedX(0);
	        	
	        	niveau.raquette.setPosX(niveau.newPosX(niveau.raquette));
//	        	for(Brick e : niveau.bonus){
//	        	e.setPosY(niveau.newPosY(e));
//	        	e.reactionRebond(niveau.raquette, niveau);
//	        	}
	        	CheckBonus(niveau.raquette,  niveau);

	        	for (Ball b : niveau.balls){
	        		b.setPosX(niveau.newPosX(b));
	        		b.setPosY(niveau.newPosY(b));
	        		checkRebond(b, niveau);

	        	}
	        	niveau.raquette.lifeMinusFinal(niveau);
	        	panel.repaint();
	        }
	    };
	    return new Timer (30, action);
	  }
	
	public void checkRebond(Ball b,Niveau niveau){
		boolean stop=false;
		for(int num=0; stop==false && num < niveau.briques.size() ; num++){
			niveau.briques.get(num).reactionRebond(b, niveau);
		}		
	}

	public void CheckBonus(Brick br, Niveau niveau){
		for(Brick e : niveau.bonus){
			e.setPosY(niveau.newPosY(e));
			e.reactionRebond(niveau.raquette, niveau);
		}
		niveau.ListBonusRefresh(br);
		
		
	}

	
	// ANCIENNE METHODE (NON FONCTIONNELLE)
/*
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
		
*/
}
