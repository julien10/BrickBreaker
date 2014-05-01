import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;




public class Container extends JPanel{

	public void paintComponent(Graphics g){
	    try {
	    	if (main.theme == 1) {
	    		Image img = ImageIO.read(new File("bg1.png"));
	    		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    	}
	    	else if (main.theme == 2) {
	    		Image img = ImageIO.read(new File("bg2.png"));
	    		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    	}
	    	else if (main.theme == 3) {
	    		Image img = ImageIO.read(new File("bg3.png"));
	    		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }                
	  }

}
