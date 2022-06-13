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
float offsetX = 0;
float offsetY = 0;
MouseIsReleased = false;

}

public void update(GameContainer container, int delta) throws SlickException {
	
	
	if(container.getInput().isKeyPressed(57)) {
		//map.setTileId(TilePositionX, TilePositionY, 1, 52);
	}
	
	

	MouseX = container.getInput().getAbsoluteMouseX();
	MouseY = container.getInput().getAbsoluteMouseY();
	
	
	TilePositionX = (MouseX-offsetX)-(MouseY-offsetY)/(1.5f);
	TilePositionY = (((MouseY-offsetY)/3.0f+(MouseX-offsetX))/1.5f);
	

	
}

public void render(GameContainer container, Graphics g) throws SlickException {
	int stringXpos = 600;
	map.render(360, 100,0);
	operator.go();

	
	g.drawString("Mouse X = "+MouseX, stringXpos, 15);
	g.drawString("Mouse Y = "+MouseY, stringXpos, 30);
	g.drawString("Tile Position X = "+TilePositionX, stringXpos, 45);
	g.drawString("Tile Position Y = "+TilePositionY, stringXpos, 60);

	
	g.drawString("Mouse X pressed "+MouseXpressed, stringXpos, 105);
	g.drawString("Mouse Y pressed "+MouseYpressed, stringXpos, 120);
	
	g.drawString("Mouse Xn pressed "+MouseXn, stringXpos, 135);
	g.drawString("Mouse Yn pressed "+MouseYn, stringXpos, 150);
	g.drawString("Object coodrinates: "+"\n"+operator.getCoords(),stringXpos,165);
	g.drawString("Object render coodrinates: "+"\n"+operator.getNextCoords(),stringXpos,200);
	
	int pos=400;
	
	for(int i=0;i<gameMap.tiles.length;i++) {
	
	g.drawString(Arrays.toString(gameMap.tiles[i]), 0, pos);
	pos+=15;
	}
	pos=0;
}



public static void main(String[] args) throws SlickException {
	AppGameContainer app = new AppGameContainer(new SetupClass("Plant Manager Game"));
	
	app.setDisplayMode(800, 600,false);
	app.start();
}



}
