
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
		float vtot=(float)Math.sqrt(Math.pow(o.getSpeedX(),2)+Math.pow(o.getSpeedY(),2));
		if (isInside(niveau.newPosX(o), niveau.newPosY(o), o.getLongueur(), o.getHauteur())){
			stop = true;
			o.setPosX(o.lastPosX());
			o.setPosY(o.lastPosY());
			if(isRebondVertical(o.getPosX(), o.getLongueur())){
				o.setSpeedY(-o.getSpeedY());
				float vx = o.getPosX() + o.getLongueur()/2 - (this.getPosX() + this.getLongueur()/2);
//				if (vx < vtot)
//					o.setSpeedX(vx/20);
//				else
//					o.setSpeedX((float) (vtot-0.2));
				o.setSpeedX(vx/28);
				float vy=-(float)Math.sqrt(Math.pow(vtot,2)-Math.pow(o.getSpeedX(),2));
				o.setSpeedY(vy);
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
				System.out.println("j'enlève une vie dans lifeminusnormal (classe raquette)");
				b.setPosX(this.getPosX() + (this.getLongueur()/2) - (b.getLongueur()/2));
				b.setPosY(this.getPosY() - b.getHauteur());
				b.setSpeedX(0);
				b.setSpeedY((float)-4.24);
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
