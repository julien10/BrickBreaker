
public class Ball extends GameObject {

	
	public Ball(int longueur, int hauteur,float posX,float posY,float speedX,float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
	}
	

	
	public float speedTotal(){
		float speedtotal=(float) Math.sqrt(getSpeedX()*getSpeedX()+getSpeedY()*getSpeedY());
		return speedtotal;
		
	}
	
	
	public boolean ballout(float posy){
		boolean ballOut = false;
		if ( getPosY() >= posy+15){
			ballOut = true;
		}
		
		return ballOut;
	}
	

}
