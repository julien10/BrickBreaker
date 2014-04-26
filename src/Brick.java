
public abstract class Brick extends GameObject {
	

	
	public Brick(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);

	}	
	
	
	public boolean isBallInside(float x, float y, float radius){	
		boolean inside = false;
		if (y+radius >= getPosY() && y-radius<=getPosY()+getHauteur()){
			if (x>=getPosX() && x<=getPosX()+getLongueur()){
				inside = true;
			}
		}
		if (x+radius>=getPosX() && x-radius<=getPosX()+getLongueur()){
			if (y >= getPosY() && y<=getPosY()+getHauteur()){
				inside = true;
			}
		}
		return inside;
	}
	
	public boolean isRebondVertical(float x){
		boolean rebondVertical = false;
		if(x>= getPosX() && x <= getPosX()+getLongueur() ){
			rebondVertical = true;
		}
		return rebondVertical;
	}



	public boolean isRebondHorizontal(float y){
		boolean rebondHorizontal = false;
		if(y>= getPosY() && y <= getPosY()+getHauteur() ){
			rebondHorizontal = true;
		}
		return rebondHorizontal;
	}
	
	public abstract  boolean reactionRebond(GameObject b,Niveau niveau);

	public boolean isInsideObjectUpperSide(float posx, float posy,int  longueur){
		boolean isInside = false;
		if (getPosY()+getHauteur()>posy && getPosY()<posy){
			if(posx<getPosX() && posx+longueur>getPosX()+getLongueur()){
				isInside = true;
			}
		}
		return isInside;
	}
			
}
