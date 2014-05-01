
public class BonusVie extends Bonus {

	public BonusVie(int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean ViePlus = false;
		if (isInside(b.getPosX(), b.getPosY(), b.getLongueur(), b.getHauteur())){
			ViePlus = true;
			niveau.RaquettePLusLife();
		}
		return ViePlus;
	}

}
