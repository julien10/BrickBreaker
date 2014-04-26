
public class BrickBonusMB extends Brick {

	public BrickBonusMB(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 25;
			BonusMB bonusmb = new BonusMB(10,10,getPosX()+getLongueur()/2-5,getPosY(),0,2,0);
			niveau.bonusAdd(bonusmb);
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
