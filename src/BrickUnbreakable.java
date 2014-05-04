
public class BrickUnbreakable extends Brick {

	public BrickUnbreakable(int longueur, int hauteur,  int posX, int posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b, Niveau niveau){
		boolean stop = false;
		if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
			stop = true;
			if(isRebondVertical(b.getPosX(), b.getLongueur())){
				b.setSpeedY(-b.getSpeedY());
			}
			if(isRebondHorizontal(b.getPosY(), b.getHauteur())){
				b.setSpeedX(-b.getSpeedX());
			}
		}
		return stop;
	}
}
