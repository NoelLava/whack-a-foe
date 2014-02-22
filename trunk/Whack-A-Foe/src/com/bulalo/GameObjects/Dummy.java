package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Dummy {
	private Vector2 position;
	private Vector2 velocity;

	private int life;
	private int width;
	private int height;
	private Dummy myDummy;
	
	private boolean markedForRemoval;
	
	public Dummy(int life, float x, float y, int width, int height){
		this.life = 500;
		this.width = 33;
		this.height = 48;
		position = new Vector2(x,y);
		velocity = new Vector2(0, -5);
	}
	
	public void update(float delta){
		life--;
		System.out.println(life);
		
		if(position.y < 47)
			velocity.y = 0;
			if(life < 1){
				life = 0;
				System.out.println(velocity.y);
			}
		
		position.add(velocity.cpy().scl(delta));
		System.out.println(position);
	}
	
	public void onClick(){
		position.y = 95;
		System.out.println("clicked");
	}
	
	public void spawn(float x, float y){
		System.out.println("Dummy - spawn");
		myDummy = new Dummy(life, x, y, width, height);
		position = new Vector2(x,y);
		velocity = new Vector2(0, -30);
		
		markedForRemoval = false;
	}
	
	public void remove(){
		markedForRemoval = true;
	}	
	
	public boolean isMarked(){
		return markedForRemoval;
	}
	
	public void setX(float counter){
		position.x = counter;
	}
	
	public void setY(float counter){
		position.y = counter;
	}
	
    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}
