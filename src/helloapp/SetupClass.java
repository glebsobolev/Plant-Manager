package helloapp;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class SetupClass extends BasicGame {
public SetupClass(String title) {
		super(title);	
	}



private TiledMap map;
private Image image;
private double x,y;
private int mapX, mapY;
private float RectX,RectY;


public void init(GameContainer container) throws SlickException {
map= new TiledMap("res/testing.tmx");
image = new Image("res/Tuscan_Idle_00000.png");

}

public void update(GameContainer container, int delta) throws SlickException {
	//Player movement
	if(container.getInput().isKeyDown(Input.KEY_RIGHT))
	{
		x -= delta/3.0f;
	}
	
	if(container.getInput().isKeyDown(Input.KEY_LEFT))
	{
		x += delta/3.0f;
	}
	
	if(container.getInput().isKeyDown(Input.KEY_UP))
	{
		y += delta/3.0f;
	}
	
	if(container.getInput().isKeyDown(Input.KEY_DOWN))
	{
		y -= delta/3.0f;
	}
	
	//RectX += 0.01 * delta;
	//RectY += 0.01 * 0.5* delta;
	}


public void render(GameContainer container, Graphics g) throws SlickException {
	
	map.render((int)x,(int)y,mapX,mapY, 5, 5);
	
	image.draw((int)x+RectX,(int)y+RectY,120,60);
}
public static void main(String[] args) throws SlickException {
	AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
	
	app.setDisplayMode(800, 600, false);
	
	app.start();
}

}
