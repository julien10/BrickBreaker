
public class BrickCloud extends Brick {

	public BrickCloud(int longueur, int hauteur,  int posX, int posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
<<<<<<< HEAD
		if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
=======
		if (isBallInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur())){
>>>>>>> FETCH_HEAD
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 50;
		}
		return stop;
	}

}
