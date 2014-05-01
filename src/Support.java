
public abstract class Support extends GameObject {
	

	
	public Support(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);

	}	

//	
//	public boolean isInside(GameObject o) {
//		boolean inside = false;
//		float x = o.getPosX();
//		float y = o.getPosY();
//		float l = o.getLongueur();
//		float h = o.getHauteur();
//		if (y + h > getPosY() && y < getPosY() + getHauteur() && x + l > getPosX() && x < getPosX() + getLongueur()) 
//				inside = true;
//		return inside;
//	}
	
	public boolean isRebondVertical(GameObject b){
		boolean rebondVertical = false;
		float x = b.getPosX();
		int l = b.getLongueur();
		if(x + l > getPosX() && x < getPosX() + getLongueur() ){
			rebondVertical = true;
		}
		return rebondVertical;
	}



	public boolean isRebondHorizontal(GameObject b){
		boolean rebondHorizontal = false;
		float y = b.getPosY();
		int h = b.getHauteur();
		if(y + h > getPosY() && y < getPosY() + getHauteur() ){
			rebondHorizontal = true;
		}
		return rebondHorizontal;
	}
	
//	public abstract  boolean reactionRebond(GameObject b,Niveau niveau);
			
}
