
public class BrickCloud extends Brick {

	public BrickCloud(int longueur, int hauteur,  int posX, int posY, float speedX, float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 50;
		}
		return stop;
	}

}
