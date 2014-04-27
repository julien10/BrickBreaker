import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Window extends JFrame {
	public static Panel panel;
	public Niveau niveau;
	public Timer timer;
	public JPanel container;
	public JPanel infos;
	public JLabel affichageScore;
	public JLabel affichageVies;
	
	public Window(Niveau niveau) {
		this.niveau = niveau;
		this.setTitle("Casse-Briques");
		this.setSize(1250,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = new Container();
		panel = new Panel(niveau);
		infos = new JPanel();
		panel.setPreferredSize(new Dimension(1100, 700));
		infos.setPreferredSize(new Dimension(150, 700));
		infos.setOpaque(false);
		infos.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		affichageScore = new JLabel("<html>Score :<br>" + niveau.score + "</html>");
		affichageVies = new JLabel("<html>Vies restantes :<br>" + niveau.vies + "</html>");
		Font scoreFont = new Font("Helvetica", Font.BOLD, 20);
		Font scoreVies = new Font("Helvetica", Font.BOLD, 16);
		affichageScore.setFont(scoreFont);
		affichageVies.setFont(scoreVies);
		affichageScore.setForeground(Color.white);
		affichageVies.setForeground(Color.white);
		infos.add(affichageScore);
		infos.add(affichageVies);
		panel.setOpaque(false);
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
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
	        	if (panel.pauseEnfoncee == false){
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
	        		CheckBonus(niveau.raquette, niveau);

	        		for (Ball b : niveau.balls){
	        			b.setPosX(niveau.newPosX(b));
	        			b.setPosY(niveau.newPosY(b));
	        			checkRebond(b, niveau);

	        		}
	        		niveau.vies = niveau.raquette.getLives();
	        		niveau.raquette.lifeMinusFinal(niveau);
	        		affichageScore.setText("<html>Score<br>" + niveau.score + "</html>");
	        		affichageVies.setText("<html>Vies restantes :<br>" + niveau.vies + "</html>");
	        		panel.repaint();
	        	}
	        	else{
	        		affichageScore.setText("<html>PAUSE<br>" + niveau.score + "</html>");
	        	}
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
