
public class BonusMB extends Bonus {

	public BonusMB(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean multiBalls = false;
		if (isInside(b.getPosX(), b.getPosY(), b.getLongueur(), b.getHauteur())){
			multiBalls = true;
			niveau.balls.add(new Ball(25,25, niveau.raquette.getPosX()+(niveau.raquette.getLongueur()/2)-12, niveau.raquette.getPosY()-25, 0, (float) -4.24));
		}
		return multiBalls;
	}
}
