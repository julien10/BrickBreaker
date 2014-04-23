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
	 public List<GameObject> objets;
	 public Raquette raquette;
	 public Ball ball;
	 public int dt = 3;
	 
	 public Niveau() {
		 briques = new ArrayList<GameObject>();
		 // float points, int resistance, int throwedBonus, int posX, int posY, float speedX, float speedY, int bonus
		 int a = 40;
		 for (int i=0; i<25; i++) {
			 briques.add(new Brick(40,20,50,1,0,a*(i+1),50,0,0,0));
		 }
		 int b = 60;
		 for (int i=0; i<24; i++) {
			 briques.add(new Brick(40,20,50,1,0,b*(i+1)-20*i,70,0,0,0));
		 }
		 
		 // float length,int lives,int posX,int posY,float speedX,float speedY,int bonus
		 raquette = new Raquette(150,10, 3, 475, 600, 0, 0, 0);
		 
		 
		 // float radius,float posX,float posY,float speedX,float speedY,int bonus
		 ball = new Ball(0,0,15, 550, 350, 3, -1, 0); 
		 objets = new ArrayList<GameObject>();
		 for (GameObject e : briques) {
			 objets.add(e);
		 }
		 objets.add(raquette);
	 }
	
	 public float newPosX(GameObject a) {
		 float newPosX = a.getPosX() + a.getSpeedX()*dt;
		 if (a instanceof Raquette) {
			 if (newPosX < -150) {
				 newPosX = 1100;
			 }
			 else if (newPosX > 1100) {
				 newPosX = -120;
			 }
		 }
		 if (a instanceof Ball) {
			 if (newPosX < 0 || newPosX > 1100) {
				 float tmp = a.getSpeedX();
				 a.setSpeedX(-tmp);
				 System.out.println(a.getClass());
			 }
		 }
		 return newPosX;
	 }
	 
	 public float newPosY(GameObject a) {
		 float newPosY = a.getPosY() + a.getSpeedY()*dt;
		 if (newPosY < 1) {
			 float tmp = a.getSpeedY();
			 a.setSpeedY(-tmp);
		 }
		 else if (newPosY > 700) {
			 raquette.setLives(raquette.getLives()-1);
		 }
		 return newPosY;
	 }

	 
}