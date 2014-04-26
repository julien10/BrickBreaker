
public class Raquette extends Brick {
	private int lives;

	
	public Raquette(int longueur, int hauteur,int lives,int posX,int posY,float speedX,float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
		this.lives=lives;
	}

	public int getLives(){
		return this.lives;
	}
	

	public void setLives(int lives){
		if (lives > 0)
			this.lives=lives;
	}
	
	
	public boolean reactionRebond(GameObject b, Niveau niveau){
		boolean stop = false;
		if (isBallInside(b.getPosX(), b.getPosY(), b.getLongueur())){
			stop = true;
			if(isRebondVertical(b.getPosX())){
				b.setSpeedY(-b.getSpeedY());
			}
			if(isRebondHorizontal(b.getPosY())){
				b.setSpeedX(-b.getSpeedX());
			}
		}
		return stop;
	}
	
	public void lifeMinusNormal(Ball b, float posy){
		if(b.ballout(posy)){
			if(getLives() >= 1){
				setLives(getLives()-1);
				b.setPosX(400);
				b.setPosY(400);
				b.setSpeedX(3);
				b.setSpeedY(-1);
			}
			else{
				b.setPosX(400);
				b.setPosY(400);
				b.setSpeedX(0);
				b.setSpeedY(0);
			}
		}
	}
	
	public void lifeMinusFinal(Niveau niveau){
		if(niveau.balls.size() == 1){
			niveau.raquette.lifeMinusNormal(niveau.balls.get(0), niveau.raquette.getPosY());
		}
		else{
			niveau.ListBallsRefresh(niveau.raquette);
					
		}
	}
}