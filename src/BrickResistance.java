
public class BrickResistance extends Brick {
	
	public int resistance;
	
	public BrickResistance(int resistance,int longueur, int hauteur, int posX, int posY, float speedX, float speedY, int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
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
			if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur()/2)){
				stop = true;
				niveau.brickDelete(this);
				if(isRebondVertical(b.getPosX())){
					b.setSpeedY(-b.getSpeedY());
				}
				if(isRebondHorizontal(b.getPosY())){
					b.setSpeedX(-b.getSpeedX());
				}
			}
		}
		else {
			if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur()/2)){
				stop = true;
				setResistance(getResistance()-1);
				if (isRebondVertical(b.getPosX())) {
					b.setSpeedY(-b.getSpeedY());
				}
				if (isRebondHorizontal(b.getPosY())) {
					b.setSpeedX(-b.getSpeedX());
				}
			}
		}
		return stop;
		}



}
