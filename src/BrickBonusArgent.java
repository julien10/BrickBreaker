<<<<<<< HEAD

=======
>>>>>>> FETCH_HEAD
public class BrickBonusArgent extends Brick {

	public BrickBonusArgent(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
<<<<<<< HEAD
		if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 25;
			BonusArgent bonusargent = new BonusArgent(200,24,24,getPosX()+getLongueur()/2-12,getPosY(),0,2);
			niveau.bonusAdd(bonusargent);
			if(isRebondVertical(b.getPosX(), b.getLongueur())){
				b.setSpeedY(-b.getSpeedY());
			}
			if(isRebondHorizontal(b.getPosY(), b.getHauteur())){
=======
		if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur())){
			stop = true;
			niveau.brickDelete(this);
			niveau.score = niveau.score + 25;
			BonusArgent bonusargent = new BonusArgent(200,10,10,getPosX()+getLongueur()/2-5,getPosY(),0,2);
			niveau.bonusAdd(bonusargent);
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
