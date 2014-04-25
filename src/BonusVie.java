
public class BonusVie extends Bonus {

	public BonusVie(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean ViePlus = false;
		if (isInsideObjectUpperSide(b.getPosX(), b.getPosY(), b.getLongueur())){
			ViePlus = true;
			niveau.RaquettePLusLife();
		}
		return ViePlus;
	}

}
