
public class BrickBonusMB extends Brick {

	public BrickBonusMB(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 25;
			BonusMB bonusmb = new BonusMB(32,32,getPosX()+getLongueur()/2-5,getPosY(),0,2);
			niveau.bonusAdd(bonusmb);
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
