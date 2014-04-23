
public class Raquette extends GameObject {
	private int lives;


	public Raquette(int longueur, int hauteur,int lives,int posX,int posY,float speedX,float speedY,int bonus){
		super(longueur, hauteur, posX,posY,speedX,speedY,bonus);
		this.lives=lives;
	}

	public int getLives(){
		return this.lives;
	}
	
	public void setLongueur(int longueur){
		this.longueur=longueur;
	}

	public void setLives(int lives){
		this.lives=lives;
	}


}
