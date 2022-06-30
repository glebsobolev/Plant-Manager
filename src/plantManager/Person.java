package plantManager;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public abstract class Person implements Mover  {
private int tileX,tileY,nextX, nextY;
private int targetX = 5;
private int targetY = 5;
private float cartesianX,cartesianY;
private float isoX,isoY;
public static  float offsetX = 0.0f;
public static  float offsetY= -32.0f;
private Image image ;
private AStarPathFinder aStarPathFinder = new AStarPathFinder(SetupClass.gameMap,1000, false);
private Path path = new Path();
private Graphics g = new Graphics();
private Input input = new Input(300);


public Person() {
	try {
		this.image = new Image("res/Person.png",false);
		//this.aStarPathFinder = new AStarPathFinder(SetupClass.gameMap, 999, false);
	
		
	} catch (SlickException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	this.tileX = 0;
	this.tileY = 0;
}
public void doAction() {
	

	findPath();
	
	moveTowardsTarget();
	
	checkIfReachedTarget();
	
	cartesianToIsometric();
	
	render();
	
}

private void findPath() {
	
	path = aStarPathFinder.findPath(this,tileX, tileY, targetX, targetY);

	
	try {
	nextX=path.getX(1);
	nextY=path.getY(1);}
	catch(NullPointerException e){
		 
	}
	
}
private void moveTowardsTarget() {
	
	if(nextX>tileX) {
		cartesianX+=Constants.GAMESPEED;
		
	}
	else if(nextY>tileY) {
		cartesianY+=Constants.GAMESPEED;
		
	}
	else if(nextX<tileX) {
		cartesianX-=Constants.GAMESPEED;
		
	}else if(nextY<tileY) {
		cartesianY-=Constants.GAMESPEED;
		
	}
	
	
}
private void checkIfReachedTarget() {
	
	if(Math.abs(cartesianX-(nextX*32.0f))<=0.5f){
		tileX=nextX;
	}
	if(Math.abs(cartesianY-(nextY*32.0f))<=0.50f) {
		tileY=nextY;
	}
	
	if(tileX==targetX && tileY==targetY) {
		targetX = 0;
		targetY = 0;
	}
	
}
private void cartesianToIsometric() {
	isoX = cartesianX-cartesianY;
	isoY = (cartesianX+cartesianY)/2;
}
private void render() {
	image.draw(isoX+offsetX+SetupClass.screenOffsetX,isoY+offsetY+SetupClass.screenOffsetY);
	//image.draw(isoX+offsetX+SetupClass.screenOffsetX,isoY+offsetY+SetupClass.screenOffsetY,32.0f,32.0f);
}

public String getCoords() {
	return "X = "+this.tileX+" Y = "+this.tileY;
}


public String getNextCoords() {
	return "X = "+this.isoX+" Y = "+this.isoY;
}

public String getTarget() {
	return "target X = "+this.targetX+"target Y = "+this.targetY;
}

public String getNextMovement() {
	return "next X = "+this.nextX+"next Y = "+this.nextY;
}
public String getIsoCoords() {
	return "Iso X = " + this.isoX + "Iso Y = " + this.isoY;
}

}
