
public class BrickBonusLI extends Brick {

	public BrickBonusLI(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
<<<<<<< HEAD
		if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 25;
			BonusLI bonusli = new BonusLI(200,50,50,getPosX()+getLongueur()/2-25,getPosY(),0,2);
			niveau.bonusAdd(bonusli);
			if(isRebondVertical(b.getPosX(), b.getLongueur())){
				b.setSpeedY(-b.getSpeedY());
			}
			if(isRebondHorizontal(b.getPosY(), b.getHauteur())){
=======
		if (isBallInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 25;
			BonusLI bonusli = new BonusLI(200,10,10,getPosX()+getLongueur()/2-5,getPosY(),0,2);
			niveau.bonusAdd(bonusli);
			if(isRebondVertical(b.getPosX())){
				b.setSpeedY(-b.getSpeedY());
			}
			if(isRebondHorizontal(b.getPosY())){
>>>>>>> FETCH_HEAD
				b.setSpeedX(-b.getSpeedX());
			}
		}
		return stop;
	}
<<<<<<< HEAD
}
=======

}
>>>>>>> FETCH_HEAD
