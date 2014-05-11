import java.util.ArrayList;
import java.util.List;

public class BrickBomb extends Brick {

	public BrickBomb(int longueur, int hauteur,  int posX, int posY, float speedX, float speedY){
		super(longueur, hauteur, posX,posY,speedX,speedY);
	}


	public boolean reactionRebond(GameObject b,Niveau niveau){
		boolean stop = false;
		if (isInside(niveau.newPosX(b), niveau.newPosY(b), b.getLongueur(), b.getHauteur())){
			stop = true;
			List<Brick> liste=new ArrayList<Brick>();
			for (Brick e : niveau.briques) {
				if (e.getPosX()==this.getPosX()-(float)80.0 && e.getPosY()==this.getPosY()){ // s'il y a une brique à gauche
					liste.add(e);
				}
				else if (e.getPosX()==this.getPosX()+(float)80 && e.getPosY()==this.getPosY()){	// s'il y a une brique à droite
					liste.add(e);			
				}
				else if (e.getPosX()==this.getPosX() && e.getPosY()==this.getPosY()-(float)40.0){	// s'il y a une brique au dessus
					liste.add(e);					
				}
				else if (e.getPosX()==this.getPosX()+40 && e.getPosY()==this.getPosY()-(float)40.0){	// s'il y a une brique au dessus
					liste.add(e);					
				}
				else if (e.getPosX()==this.getPosX()-40 && e.getPosY()==this.getPosY()-(float)40.0){	// s'il y a une brique au dessus
					liste.add(e);					
				}
				else if (e.getPosX()==this.getPosX() && e.getPosY()==this.getPosY()+(float)40.0){	// s'il y a une brique en dessous
					liste.add(e);			
				}
				else if (e.getPosX()==this.getPosX()+40 && e.getPosY()==this.getPosY()+(float)40.0){	// s'il y a une brique en dessous
					liste.add(e);			
				}
				else if (e.getPosX()==this.getPosX()-40 && e.getPosY()==this.getPosY()+(float)40.0){	// s'il y a une brique en dessous
					liste.add(e);			
				}
			}
			for (Brick e:liste){
				niveau.brickDelete(e);
				if (e instanceof BrickUnbreakable)
					niveau.incassables -= 1;
			}
			niveau.brickDelete(this);
			niveau.score = niveau.score + 50*liste.size();
			if(isRebondVertical(b.getPosX(), b.getLongueur())){
					b.setSpeedY((float)-b.getSpeedY());
					b.setSpeedX((float)b.getSpeedX());
				}
			if(isRebondHorizontal(b.getPosY(), b.getHauteur())){
					b.setSpeedX((float)-b.getSpeedX());
					b.setSpeedY((float)b.getSpeedY());
				}
		}
		return stop;
	}
}
