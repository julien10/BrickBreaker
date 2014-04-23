import java.awt.Color;


public abstract class GameObject {
	private float posX;
	private float posY;
	private float speedX;
	private float speedY;
	private int hauteur;
	protected int longueur;
	private int bonus;
	private Color couleur;
	
	public GameObject(int longueur, int hauteur, float posX, float posY, float speedX, float speedY, int bonus){
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.posX = posX;	
		this.posY = posY;
		this.speedX = speedX;
		this.speedY = speedY;
		this.bonus = bonus;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLongueur() {
		return this.longueur;
	}
	
	public void setCouleur(Color c) {
		couleur = c;
	}
	
	public float getPosX(){
		return this.posX;
	}
	public float getPosY(){
		return this.posY;
	}
	public float getSpeedX(){
		return this.speedX;
	}
	public float getSpeedY(){
		return this.speedY;
	}
	public int getbonusX(){
		return this.bonus;
	}
	public void setPosX(float posX){
		this.posX = posX;
	}
	public void setPosY(float posY){
		this.posY = posY;
	}
	public void setSpeedX(float speedX){
		this.speedX = speedX;
	}
	public void setSpeedY(float speedY){
		this.speedY = speedY;
	}
	public void setbonus(Integer bonus){
		this.bonus = bonus;
	}
		
}
