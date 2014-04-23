import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Niveau {
	 public List<GameObject> briques;
	 public Raquette raquette;
	 
	 public Niveau() {
		 briques = new ArrayList<GameObject>();
		 // float points, int resistance, int throwedBonus, int posX, int posY, float speedX, float speedY, int bonus
		 int a = 40;
		 for (int i=0; i<25; i++) {
			 briques.add(new Brick(50,1,0,a*(i+1),50,0,0,0));
		 }
		 int b = 60;
		 for (int i=0; i<24; i++) {
			 briques.add(new Brick(50,1,0,b*(i+1)-20*i,70,0,0,0));
		 }
		 // float length,int lives,int posX,int posY,float speedX,float speedY,int bonus
		 raquette = new Raquette(100, 3, 475, 600, 0, 0, 0);
	 }
	 

}