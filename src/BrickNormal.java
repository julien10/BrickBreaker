
public class BrickNormal extends Brick {

	
	public BrickNormal(int longueur, int hauteur,  int posX, int posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 50;
			if(isRebondVertical(b.getPosX())){
				b.setSpeedY(-b.getSpeedY());
			}
			if(isRebondHorizontal(b.getPosY())){
				b.setSpeedX(-b.getSpeedX());
			}
		}
		return stop;
	}


}
