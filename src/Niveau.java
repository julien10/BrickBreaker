import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.*;
import java.nio.file.*;


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
	 
	 public Niveau() {
		 score = 0;
		 briques = new ArrayList<Brick>();
		 File file = File("C:\\Users\\el-matador\\Documents\\miguel\\university\\informatique\\workspace\\BrickBreaker\\text.txt");
		 niveauReader (file.getAbsolutePath());
//		 // int longueur, int hauteur, float points, int resistance, int throwedBonus, int posX, int posY, float speedX, float speedY, int bonus
//		 // int longueur, int hauteur,  int posX, int posY, float speedX, float speedY,int bonus
//		 int a = 80;
//		 for (int i=0; i<12; i++) {
////			 briques.add(new BrickBonusMB(40,20,a*(i+1),50,0,0));
//			 briques.add(new BrickBonusMB(80,40,a*(i+1),50,0,0));
//		 }
//		 int b = 100;
//		 for (int i=0; i<11; i++) {
////			 briques.add(new BrickResistance(3,40,20,b*(i+1)-20*i,70,0,0));
//			 briques.add(new BrickResistance(3,80,40,b*(i+1)-20*i,90,0,0));
//		 }		
////		for (int i=0; i<25; i++)
////			 briques.add(new BrickBonusArgent(40,20,a*(i+1),90,0,0));

		 raquette = new Raquette(150, 10, 3, 475, 600, 0, 0);
		 vies = raquette.getLives();
		 
		 balls = new ArrayList<Ball>();
		 balls.add(new Ball(15,15, raquette.getPosX() + raquette.getLongueur()/2, raquette.getPosY()-17, 0,(float)-4.24)));
		 
		 bonus = new ArrayList<Bonus>();
		 briques.add(raquette);
//		 objets = new ArrayList<GameObject>();
//		 objets.add(raquette);
//		 for (GameObject e : briques) {
//			 objets.add(e);
//		 }
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
			 if (balls.size() == 1) {
				 raquette.setLives(raquette.getLives()-1);
			 	 ListBallsRefresh(raquette);
			 }
			 else
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
	 	Path chemin = Paths.get(path);
	 			// Lire les octets du fichier
	 		byte[] contenu = Files.readAllBytes(chemin);
	 			// Parcourir les octets et afficher les caract�res correspondants
	 		int y = 0;
	 		int x = 0;
	 		for (byte b : contenu){
	 			String chara=Byte.toString(b);
	 			
	 			if (chara =="N" ){
	 				 // int longueur, int hauteur, float points, int resistance, int throwedBonus, int posX, int posY, float speedX, float speedY, int bonus
	 				 // int longueur, int hauteur,  int posX, int posY, float speedX, float speedY,int bonus
	 					 briques.add(new BrickNormal(80,40,x,y,0,0));
	 				x += 80;
	 			}
	 			if (chara == " "){
	 				x += 80;
	 			}
	 			 if (chara == "S"){
	 				 x=0;
	 				y += 40; 	 
	 			 }
	 			}	
	 				
	 			}
	 				
	 
}
