package plantManager;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public abstract class Person implements Mover  {
private int x,y;
private int nextX, nextY;
private float renderX,renderY,speed;
private Image image ;
private AStarPathFinder aStarPathFinder = new AStarPathFinder(SetupClass.gameMap, 999, false);
private Path path = new Path();
private Graphics g = new Graphics();


public Person() {
	try {
		this.image = new Image("res/duck.png",false);
		//this.aStarPathFinder = new AStarPathFinder(SetupClass.gameMap, 999, false);
	
		
	} catch (SlickException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	this.x = 0;
	this.y = 0;
}
public void go() {
	int targetX = 11;
	int targetY = 11;
	float speed = 0.20f;
	
	path = aStarPathFinder.findPath(this, x, y, targetX, targetY);

	
	try {
	nextX=path.getX(1);
	nextY=path.getY(1);}
	catch(NullPointerException e){
		 
	}
	
	
	if(nextX>x) {
		renderX+=speed;
	}
	else if(nextY>y) {
		renderY+=speed;
	}
	
	if(x==targetX && y==targetY) {
		renderX=0.0f;
		renderY=0.0f;
	}
	
	x = (int) (renderX/32.0f);
	y = (int) (renderY/32.0f);
	render();
	
}

private void render() {
	image.draw(renderX,renderY,32.0f,32.0f);
}

public String getCoords() {
	return "X = "+this.x+" Y = "+this.y;
}

public String getNextCoords() {
	return "X = "+this.renderX+" Y = "+this.renderY;
}


}
