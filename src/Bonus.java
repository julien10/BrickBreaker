
public abstract class Bonus extends Brick {

	public Bonus(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
	}
	
	public boolean BonusLow(float posy, int hauteur){
		boolean toLow = false;
		if(getPosY()>=posy+ hauteur-getHauteur() ){
			toLow = true;
		}
		return toLow;
	}
	

}
