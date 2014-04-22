import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel {
	
	private Niveau niveau = new Niveau();
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
	}
}