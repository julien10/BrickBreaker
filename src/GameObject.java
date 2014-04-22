import java.awt.Color;


public abstract class GameObject {
	private float posX;
	private float posY;
	private float speedX;
	private float speedY;
	private int bonus;
	private Color couleur;
	
	public GameObject(float posX, float posY, float speedX,float speedY,int bonus){
		this.posX = posX;	
		this.posY = posY;
		this.speedX = speedX;
		this.speedY = speedY;
		this.bonus = bonus;
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
		this.posX = posY;
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
	
	public float deltaX(float t, float speedX){
		return t*speedX;
	}
	public float deltaY(float t, float speedY){
		return t*speedY;
	}

	
}
