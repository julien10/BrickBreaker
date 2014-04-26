
public class Ball extends GameObject {

	
	public Ball(int longueur, int hauteur,float posX,float posY,float speedX,float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	

	
	public float speedTotal(){
		float speedtotal=(float) Math.sqrt(getSpeedX()*getSpeedX()+getSpeedY()*getSpeedY());
		return speedtotal;
		
	}
	
	// Renvoie true si la balle est en dessous de posY
	public boolean ballout(float posy){
		boolean ballOut = false;
		if (getPosY() >= posy+90){
			ballOut = true;
		}
		
		return ballOut;
	}
	

}
