
public class Ball extends GameObject {
	private float radius;
	
	public Ball(float radius,float posX,float posY,float speedX,float speedY,int bonus){
		super(posX,posY,speedX,speedY,bonus);
		this.radius = radius;
	}
	
	public float getRadius(){
		return this.radius;
	}
	
	public void setRadius(float radius){
		this.radius=radius;
	}
	

}
