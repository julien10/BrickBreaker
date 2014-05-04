
public class BrickResistance extends Brick {
	
	public int resistance;
	
	public BrickResistance(int resistance,int longueur, int hauteur, int posX, int posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
		this.resistance = resistance;
	}
	
	public void setResistance(int resistance){
		if (resistance > 0 && resistance < 4)
			this.resistance = resistance;
	}

	public int getResistance(){
		return resistance;
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (getResistance() == 1) {
			if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
				stop = true;
				niveau.brickDelete(this);
				niveau.score = niveau.score + 50;
				if(isRebondVertical(b.getPosX(), b.getLongueur())){
					b.setSpeedY(-b.getSpeedY());
				}
				else if(isRebondHorizontal(b.getPosY(), b.getHauteur())){
					b.setSpeedX(-b.getSpeedX());
				}
			}
		}
		else {
			if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
				stop = true;
				niveau.score = niveau.score + 50*(1 + getResistance());
				this.setResistance(this.getResistance()-1);
				if (isRebondVertical(b.getPosX(), b.getLongueur())) {
					b.setSpeedY(-b.getSpeedY());
				}
				else if (isRebondHorizontal(b.getPosY(), b.getHauteur())) {
					b.setSpeedX(-b.getSpeedX());
				}
			}
		}
		return stop;
		}
}
