
public class BonusMB extends Bonus {

	public BonusMB(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean multiBalls = false;
		if (isInsideObjectUpperSide(b.getPosX(), b.getPosY(), b.getLongueur())){
			multiBalls = true;
			niveau.balls.add(new Ball(12,12, niveau.raquette.getPosX()+(niveau.raquette.getLongueur()/2), niveau.raquette.getPosY()-12, -3, -1, 0));
//			niveau.balls.add(new Ball(12,12, 50, 380, 3, -1, 0));
		}
		return multiBalls;
	}






}