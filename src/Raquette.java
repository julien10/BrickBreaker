
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
	
	
	public boolean reactionRebond(GameObject b, Niveau niveau){
		double a = 0.6/(getLongueur()/2-15);
		boolean stop = false;
		double deltaXD=b.getPosX()-getPosX()-getLongueur()/2+15 ;
		float speedtotal = b.speedTotal();
		if (isBallInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur())){
			stop = true;
					System.out.println(("a" + speedtotal));
//			if(deltaXD >= 0  ){
//				System.out.println((b.speedTotal()));
//				System.out.println((speedtotal));
//				b.setSpeedX((float)(a*deltaXD)*speedtotal);
//				b.setSpeedY((float)(1-a*deltaXD)*speedtotal);
//			}
//			else{
				float posX = b.lastPosX();
				float posY = b.lastPosY();
				b.setPosX(posX);
				b.setPosY(posY);
				if(isRebondVertical(b.getPosX())){
					b.setSpeedY(-b.getSpeedY());
				}
				if(isRebondHorizontal(b.getPosY())){
					b.setSpeedX(-b.getSpeedX());
				}
//			}
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