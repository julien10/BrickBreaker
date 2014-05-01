
public class BonusLI extends Bonus {
	private int newLongueur;

	public BonusLI(int newLongueur, int longueur, int hauteur,  float posX, float posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
		this.newLongueur = newLongueur;
	}
	
	
	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean newlongueur = false;
		if (isInside(b.getPosX(), b.getPosY(), b.getLongueur(), b.getHauteur())){
			newlongueur = true;
			niveau.RaquetteChangeLongueur(newLongueur);
		}
		return newlongueur;
	}
}