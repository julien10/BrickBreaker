
public class BrickAccelerate extends Brick {

	public BrickAccelerate(int longueur, int hauteur,  int posX, int posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (isBallInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 150;
			if(isRebondVertical(b.getPosX())){
				b.setSpeedY((float)-1.2*b.getSpeedY());
				b.setSpeedX((float)1.2*b.getSpeedX());
			}
			if(isRebondHorizontal(b.getPosY())){
				b.setSpeedX((float)-1.2*b.getSpeedX());
				b.setSpeedY((float)1.2*b.getSpeedY());
			}
		}
		return stop;
	}


}