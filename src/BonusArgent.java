
public class BonusArgent extends Bonus {
	private int argent;

	public BonusArgent(int argent, int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
		this.argent = argent;
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean cond = false;
		if (isInside(b.getPosX(), b.getPosY(), b.getLongueur(), b.getHauteur())){
			cond = true;
			niveau.score = niveau.score + argent ;
		}
		return cond;
	}
}