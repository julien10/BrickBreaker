
public class Raquette extends GameObject {
	private float length;
	private int lives;


	public Raquette(float length,int lives,int posX,int posY,float speedX,float speedY,int bonus){
		super(posX,posY,speedX,speedY,bonus);
		this.lives=lives;
		this.length=length;
	}
	
	public float getLength(){
		return this.length;
	}

	public int getLives(){
		return this.lives;
	}
	
	public void setLength(float length){
		this.length=length;
	}

	public void setLives(int lives){
		this.lives=lives;
	}


}
