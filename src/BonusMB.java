
public class BonusMB extends Bonus {

	public BonusMB(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean multiBalls = false;
		if (isInside(b.getPosX(), b.getPosY(), b.getLongueur(), b.getHauteur())){
			multiBalls = true;
			niveau.balls.add(new Ball(15,15, niveau.raquette.getPosX()+(niveau.raquette.getLongueur()/2), niveau.raquette.getPosY()-12, -3, -1));
//			niveau.balls.add(new Ball(12,12, 50, 380, 3, -1, 0));
		}
		return multiBalls;
	}






}