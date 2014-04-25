import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChoixTheme extends JPanel {
	
	JPanel choicePanel;
	JPanel texte;
	JPanel boutons;
	JPanel labels;
	JLabel question;
	JLabel eauLabel;
	JButton eau;
	JLabel feuLabel;
	JButton feu;
	JLabel planteLabel;
	JButton plante;
	
	
	public ChoixTheme() throws IOException {
		choicePanel = new JPanel();
		question = new JLabel("Choisissez le thème que vous souhaitez utiliser :");
		
		Image imageEau = ImageIO.read(new File("eau.png"));
		Image imageFeu = ImageIO.read(new File("feu.png"));
		Image imagePlante = ImageIO.read(new File("plante.png"));
		Image imageEauSelect = ImageIO.read(new File("eauselect.png"));
		Image imageFeuSelect = ImageIO.read(new File("feuselect.png"));
		Image imagePlanteSelect = ImageIO.read(new File("planteselect.png"));
		
		final ImageIcon iconeEau = new ImageIcon(imageEau);
		final ImageIcon iconeFeu = new ImageIcon(imageFeu);
		final ImageIcon iconePlante = new ImageIcon(imagePlante);
		final ImageIcon iconeEauSelect = new ImageIcon(imageEauSelect);
		final ImageIcon iconeFeuSelect = new ImageIcon(imageFeuSelect);
		final ImageIcon iconePlanteSelect = new ImageIcon(imagePlanteSelect);
		
		eauLabel = new JLabel("Eau");
		feuLabel = new JLabel("Feu");
		planteLabel = new JLabel("Plante");
		
		eau = new JButton(iconeEau);
		eau.addMouseListener(new MouseListener() {
			@Override
            public void mouseReleased(MouseEvent arg0) {}           
            @Override
            public void mousePressed(MouseEvent arg0) {}            
            @Override
            public void mouseExited(MouseEvent arg0) { 
                eau.setIcon(iconeEau);
            }           
            @Override
            public void mouseEntered(MouseEvent arg0) {
                eau.setIcon(iconeEauSelect);
            }           
            @Override
            public void mouseClicked(MouseEvent arg0) {
            	// Définir le thème (une variable qui sera utilisé par Window/Panel?)
            }
		});
		feu = new JButton(iconeFeu);
		feu.addMouseListener(new MouseListener() {
			@Override
            public void mouseReleased(MouseEvent arg0) {}           
            @Override
            public void mousePressed(MouseEvent arg0) {}            
            @Override
            public void mouseExited(MouseEvent arg0) { 
                feu.setIcon(iconeFeu);
            }           
            @Override
            public void mouseEntered(MouseEvent arg0) {
                feu.setIcon(iconeFeuSelect);
            }           
            @Override
            public void mouseClicked(MouseEvent arg0) {
            	// Définir le thème (une variable qui sera utilisé par Window/Panel?)
            }
		});
		plante = new JButton(iconePlante);
		plante.addMouseListener(new MouseListener() {
			@Override
            public void mouseReleased(MouseEvent arg0) {}           
            @Override
            public void mousePressed(MouseEvent arg0) {}            
            @Override
            public void mouseExited(MouseEvent arg0) { 
                plante.setIcon(iconePlante);
            }           
            @Override
            public void mouseEntered(MouseEvent arg0) {
                plante.setIcon(iconePlanteSelect);
            }           
            @Override
            public void mouseClicked(MouseEvent arg0) {
            	// Définir le thème (une variable qui sera utilisé par Window/Panel?)
            }
		});
		
		texte = new JPanel();
		texte.setLayout(new BoxLayout(texte, BoxLayout.X_AXIS));
		texte.add(question);
		
		boutons = new JPanel();
		boutons.setLayout(new BoxLayout(boutons, BoxLayout.X_AXIS));
		boutons.add(eau);
		boutons.add(feu);
		boutons.add(plante);
		
		labels = new JPanel();
		labels.setLayout(new BoxLayout(labels, BoxLayout.X_AXIS));
		labels.add(eauLabel);
		labels.add(feuLabel);
		labels.add(planteLabel);
		
		choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));
		choicePanel.add(texte);
		choicePanel.add(boutons);
		choicePanel.add(labels);
		
	}
}


// on ajoute tout dans le choicePanel, puis quand on clique sur play, on enlève tout du contentpane et on ajoute choicepanel au contentpane