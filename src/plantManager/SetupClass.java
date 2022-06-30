package plantManager;

import java.util.Arrays;
import java.util.Iterator;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class SetupClass extends BasicGame {
	
public static float screenOffsetX= 330.0f;
public static float screenOffsetY = 108.0f;
public static TiledMap map;
public static GameMap gameMap;
public float MouseX, MouseY,TilePositionX,TilePositionY;
int[][] tiles;
float offsetX, offsetY,MouseXpressed,MouseYpressed,MouseXn,MouseYn;
private boolean MouseIsReleased;
	
Operator operator;
	
	
public SetupClass(String title) {
		super(title);	
	}

public void init(GameContainer container) throws SlickException {

map = new TiledMap("res/testing.tmx");
gameMap = new GameMap(map);
operator = new Operator();
}
  

public void update(GameContainer container, int delta) throws SlickException {
	
	updateScreenOffset(container);
	

	MouseX = container.getInput().getAbsoluteMouseX();
	MouseY = container.getInput().getAbsoluteMouseY();
	
	

	
}



public void render(GameContainer container, Graphics g) throws SlickException {
	
	map.render((int)SetupClass.screenOffsetX, (int)SetupClass.screenOffsetY,0);
	operator.doAction();
	
	int stringXpos = 500;
	int pos=15;
	g.drawString("Mouse X = "+MouseX, stringXpos, pos+=15);
	g.drawString("Mouse Y = "+MouseY, stringXpos, pos+=15);
	g.drawString("Screen offset X "+ screenOffsetX, stringXpos, pos+=15);
	g.drawString("Screen offset Y "+screenOffsetY, stringXpos, pos+=15);
	g.drawString("Object offsetX: "+Person.offsetX, stringXpos, pos+=15);
	g.drawString("Object offsetY: "+Person.offsetY, stringXpos, pos+=15);
	
	g.drawString("Object target: "+"\n"+operator.getTarget(),stringXpos,pos+=45);
	g.drawString("Object next: "+"\n"+operator.getNextMovement(),stringXpos,pos+=45);
	g.drawString("Object coodrinates: "+"\n"+operator.getCoords(),stringXpos,pos+=45);
	g.drawString("Object cartesian coodrinates: "+"\n"+operator.getIsoCoords(),stringXpos,pos+=45);
	
	int pos1=400;
	
	for(int i=0;i<gameMap.tiles.length;i++) {
	
	g.drawString(Arrays.toString(gameMap.tiles[i]), 0, pos1);
	pos1+=15;
	}
	pos1=0;
}



public static void main(String[] args) throws SlickException {
	AppGameContainer app = new AppGameContainer(new SetupClass("Plant Manager Game"));
	
	app.setDisplayMode(800, 600,false);
	app.start();
}

private void updateScreenOffset(GameContainer container) {
	
	if(container.getInput().isKeyDown(200)) {
		screenOffsetY-=Constants.screenMovementSpeed;
	}
	
	if(container.getInput().isKeyDown(208)) {
		screenOffsetY+=Constants.screenMovementSpeed;
	}
	
	if(container.getInput().isKeyDown(203)) {
		screenOffsetX-=Constants.screenMovementSpeed;
	}
	
	if(container.getInput().isKeyDown(205)) {
		screenOffsetX+=Constants.screenMovementSpeed;
	}
	
}


}
