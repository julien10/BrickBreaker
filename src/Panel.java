import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel {
	
	
	@Override
	protected void paintComponent(Graphics g) {
		if(niveau == null) {
			return;
		}
		super.paintComponent(g);
		for(GameObject o : niveau.briques) {
			int px = (int)(o.getPosX());
			int py = (int)(o.getPosY());
			g.drawRect(px, py, 32, 32);
		}
	}
}