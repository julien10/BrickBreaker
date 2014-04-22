
public class Brick extends GameObject {
	private int throwedBonus;
	private float points;
	private int resistance;
	
	
	
	
	public Brick(float points,int resistance,int throwedBonus,int posX,int posY,float speedX,float speedY,int bonus){
		super(posX,posY,speedX,speedY,bonus);
		this.points=points;
		this.resistance=resistance;
		this.throwedBonus=throwedBonus;
	}	
		
		
		public float getPoints(){
		return this.points;
}
	public int getResistance(){
		return this.resistance;
}	
	public int getThrowedBonus(){
		return this.throwedBonus;
}
	public void setPoints(float points){
		this.points=points;
}	
	public void setResistance(int resistance){
		this.resistance=resistance;
}	
	public void setThrowedBonus(int throwedBonus){
		this.throwedBonus=throwedBonus;
}	
	

		
}
