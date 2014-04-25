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
	 
	 public Niveau() {
		 briques = new ArrayList<Brick>();
		 // int longueur, int hauteur, float points, int resistance, int throwedBonus, int posX, int posY, float speedX, float speedY, int bonus
		 // int longueur, int hauteur,  int posX, int posY, float speedX, float speedY,int bonus
		 int a = 40;
		 for (int i=0; i<25; i++) {
			 briques.add(new BrickNormal(40,20,a*(i+1),50,0,0,0));
		 }
		 int b = 60;
		 for (int i=0; i<24; i++) {
			 briques.add(new BrickBonusMB(40,20,b*(i+1)-20*i,70,0,0,0));
		 }
		 
		 // int longueur, int hauteur,int lives,int posX,int posY,float speedX,float speedY,int bonus
		 raquette = new Raquette(150,10, 1, 475, 600, 0, 0, 0);
		 
		 
		 // int longueur, int hauteur, float radius,float posX,float posY,float speedX,float speedY,int bonus
//		 ball = new Ball(0,0,15, 550, 350, 1, -2, 0);
		 
		 balls = new ArrayList<Ball>();
		 balls.add(new Ball(12,12, 485, 350, 2, -1, 0));
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
			 if (newPosX < 0 || newPosX > 1090) {
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
			 raquette.setLives(raquette.getLives()-1);
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
	 
}