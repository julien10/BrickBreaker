import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Niveau {
	 public List<Brick> briques;
	 public List<GameObject> objets;
	 public ArrayList<Bonus> bonus;
	 public ArrayList<Ball> balls;
	 public Raquette raquette;
	 public Ball ball;
	 public int dt = 3;
	 public int score;
	 public int vies;
	 public int incassables = 0;
	 
	 public Niveau(int lvl) {
		 score = 0;
		 briques = new ArrayList<Brick>();
		 String numero = "";
		 if (lvl == 1)
			 numero = "./lvl1.txt";
		 else if (lvl == 2)
			 numero = "./lvl2.txt";
		 else if (lvl == 3)
			 numero = "./lvl3.txt";
		 else if (lvl == 4)
			 numero = "./lvl4.txt";
		 else if (lvl == 5)
			 numero = "./lvl5.txt";
		 try {
			niveauReader(numero);
			System.out.println("fichier lu");
		} catch (IOException e) {
			System.out.println("Julien le tout puissant");
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		 

		 raquette = new Raquette(150, 10, 3, 475, 600, 0, 0);
		 vies = raquette.getLives();
		 
		 balls = new ArrayList<Ball>();
//		 balls.add(new Ball(25,25, raquette.getPosX() + raquette.getLongueur()/2, raquette.getPosY()-27, 3, -3));
		 balls.add(new Ball(25,25, raquette.getPosX() + raquette.getLongueur()/2 - 12, raquette.getPosY()-26, 0, 0));
		 
		 bonus = new ArrayList<Bonus>();
		 briques.add(raquette);
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
			 if (newPosX < 0 || newPosX > 1075) {
				 float tmp = a.getSpeedX();
				 a.setSpeedX(-tmp);
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
			 ListBallsRefresh(raquette);
		 }
		 return newPosY;
	 }


	 public void brickDelete(Brick Br){
		 briques.remove(Br);
	 }
	 
	 public void bonusDelete(GameObject b){
		 bonus.remove(b);
	 }
	 public void bonusAdd(Bonus Br){
		 bonus.add(Br);
	 }
	 
	 public void  ListBonusRefresh(Brick br){
		 ArrayList<Bonus> bonusToLow = new ArrayList<Bonus>();
		 for(Bonus bn : bonus){
			 if (bn.BonusLow(br.getPosY(), br.getHauteur())){
				 bonusToLow.add(bn);
			 }
		 }
		 if(bonusToLow.size()>0){
			 for(Bonus bn : bonusToLow){
				 bonus.remove(bn);
			 }
		 }
	 }
	 
	 public void RaquettePLusLife(){
		 raquette.setLives(raquette.getLives()+1);
	 }
	 
	 public void RaquetteChangeLongueur(int newLongueur){
		 raquette.setLongueur(newLongueur);
	 }
	 
	 
	 public void  ListBallsRefresh(Brick br){
		 ArrayList<Ball> ballsToLow = new ArrayList<Ball>();
		 for(Ball b : balls){
			 if (b.ballout(br.getPosY())){
				 ballsToLow.add(b);
			 }
		 }
		 if(ballsToLow.size()>0){
			 for(Ball b : ballsToLow){
				 balls.remove(b);
			 }
		 }
	 }
	 
	 public void niveauReader (String path) throws IOException{
//	 	Path chemin = Paths.get(path);
		 			// Lire les octets du fichier
		BufferedReader yo = new BufferedReader(new FileReader(path));
		 			// Parcourir les octets et afficher les caractères correspondants
		 		
	 	String line="";
	 	int y = 0;
		int x = 0;
 		while ((line = yo.readLine()) != null) {
 			if (line.compareTo("N") == 0){
	 			if (x < 960) {
	 				briques.add(new BrickNormal(80,40,x,y,0,0));
	 				x += 80;
	 			}
	 		}
 			else if (line.compareTo("R") == 0){
 				if (x < 960) {
 					briques.add(new BrickResistance(3,80,40,x,y,0,0));
 					x += 80;
 				}
	 		}
 			else if (line.compareTo("C") == 0){
 				if (x < 960) {
 					briques.add(new BrickCloud(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}
 			else if (line.compareTo("U") == 0){
 				if (x < 960) {
 					briques.add(new BrickUnbreakable(80,40,x,y,0,0));
 					x += 80;
 					incassables += 1;
 				}
	 		}

 			else if (line.compareTo("MB") == 0){
 				if (x < 960) {
 					briques.add(new BrickBonusMB(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}

 			else if (line.compareTo("LI") == 0){
 				if (x < 960) {
 					briques.add(new BrickBonusLI(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}

 			else if (line.compareTo("V") == 0){
 				if (x < 960) {
 					briques.add(new BrickBonusVie(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}

 			else if (line.compareTo("A") == 0){
 				if (x < 960) {
 					briques.add(new BrickAccelerate(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}

 			else if (line.compareTo("BA") == 0){
 				if (x < 960) {
 					briques.add(new BrickBonusArgent(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}

 			else if (line.compareTo("B") == 0){
 				if (x < 960) {
 					briques.add(new BrickBomb(80,40,x,y,0,0));
 					x += 80;
 				}
	 		}
	 		else if (line.compareTo("-") == 0){
				x += 40;
 			}

	 		else if (line.compareTo("_") == 0){
				x += 80;
 			}
	 		else if (line.compareTo("S") == 0){
	 			x = 0;
	 			y += 40;
			}
	 		else if (line.compareTo("SS") == 0){
	 			x = 0;
	 			y += 60;
			}
//	 		else {
//	 			System.out.println(line);
//	 		}
		}
 		yo.close();
	}
	 
}
