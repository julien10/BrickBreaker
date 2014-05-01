
public abstract class Brick extends GameObject {
	

	
	public Brick(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);

	}	

	
	public boolean isInside(float x, float y, int longueur, int hauteur) {
		boolean inside = false;
		if (y + hauteur > getPosY() && y < getPosY() + getHauteur() && x + longueur > getPosX() && x < getPosX() + getLongueur()) 
			inside = true;
		return inside;
	}
	
	public boolean isRebondVertical(float x, int longueur){
		boolean rebondVertical = false;
		if(x + longueur > getPosX() && x < getPosX() + getLongueur() ){
			rebondVertical = true;
		}
		return rebondVertical;
	}



	public boolean isRebondHorizontal(float y, int hauteur){
		boolean rebondHorizontal = false;
		if(y + hauteur > getPosY() && y < getPosY() + getHauteur() ){
			rebondHorizontal = true;
		}
		return rebondHorizontal;
	}
	
	public abstract  boolean reactionRebond(GameObject b,Niveau niveau);
			
}
