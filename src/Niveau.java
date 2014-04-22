import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.Timer;


public class Niveau {
	 public List<GameObject> briques;
	 
	 public Niveau() {
		 briques = new ArrayList<GameObject>();
		 briques.add( new Brick(120,1,0,15,20,0,0,0) );
		 briques.add( new Brick(120,1,0,15,30,0,0,0) );
	 }

}