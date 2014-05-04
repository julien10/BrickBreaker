
public class Raquette extends Brick {
	private int lives;

	
	public Raquette(int longueur, int hauteur,int lives,int posX,int posY,float speedX,float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
		this.lives=lives;
	}

	public int getLives(){
		return this.lives;
	}
	

	public void setLives(int lives){
		if (lives >= 0)
			this.lives=lives;
	}
	
	public boolean reactionRebond(GameObject o, Niveau niveau){
		boolean stop = false;
		if (isInside(niveau.newPosX(o), niveau.newPosY(o), o.getLongueur(), o.getHauteur())){
			stop = true;
			o.setPosX(o.lastPosX());
			o.setPosY(o.lastPosY());
			if(isRebondVertical(o.getPosX(), o.getLongueur())){
				o.setSpeedY(-o.getSpeedY());
				float vx = o.getPosX() + o.getLongueur()/2 - (this.getPosX() + this.getLongueur()/2);
				o.setSpeedX(vx/12);
			}
			if(isRebondHorizontal(o.getPosY(), o.getHauteur())){
				o.setSpeedX(-o.getSpeedX());
			}
		}
		return stop;
	}
	
	public void lifeMinusNormal(Ball b, float posy, Niveau niveau){
		if(b.ballout(posy)){
			if(getLives() >= 1){
				setLives(getLives()-1);
				b.setPosX(400);
				b.setPosY(400);
				b.setSpeedX(3);
				b.setSpeedY(-1);
			}
			else{
				niveau.balls.remove(b);
			}
		}
	}
	
	public void lifeMinusFinal(Niveau niveau){
		if(niveau.balls.size() == 1){
			niveau.raquette.lifeMinusNormal(niveau.balls.get(0), niveau.raquette.getPosY(), niveau);
		}
		else{
			niveau.ListBallsRefresh(niveau.raquette);		
		}
	}

}