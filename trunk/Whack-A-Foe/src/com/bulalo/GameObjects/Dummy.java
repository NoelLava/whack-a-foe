package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Dummy {
	private Vector2 position;
	private Vector2 velocity;

	private int life;
	private int width;
	private int height;
	
	public Dummy(int life, float x, float y, int width, int height){
		this.life = life;
		this.width = width;
		this.height = height;
		position = new Vector2(x,y);
		velocity = new Vector2(0, -5);
	}
	
	public void update(float delta){
		life--;
		System.out.println(life);
		
		if(life < 0){
			velocity.y = 50;
			
			System.out.println(velocity.y);
		}
		
		position.add(velocity.cpy().scl(delta));
		System.out.println(position);
	}
	
	public void onClick(){
		position.y = 95;
		System.out.println("clicked");
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
