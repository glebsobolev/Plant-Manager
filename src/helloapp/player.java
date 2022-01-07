package helloapp;

public class player {

private String name;
private double x,y;

public player(String name){
	this.name=name;
}

public void spawn(double x, double y)
{
	this.x = x;
	this.y = y;
}

public double getX(){
	return this.x;
}

public double getY(){
	return this.y;
}

public String getName(){
	return this.name;
}

public void moveVertical(double distance){
	this.y += distance;
	System.out.println(y);
}

public void moveHorizontal(double distance){
	this.x += distance;
	System.out.println(x);
}

}
