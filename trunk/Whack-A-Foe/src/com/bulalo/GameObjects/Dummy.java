package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Dummy {
	private Vector2 position;
	private Vector2 velocity;
	//private Vector2 acceleration;

	private int width;
	private int height;
	private int life;
	
	public Dummy(int life, float x, float y, int width, int height) {
		System.out.println("try");
		this.life = life;
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, -5);
		//acceleration = new Vector2(0, -5);
	}

	public void update(float delta) {
		/*velocity.add(acceleration.cpy().scl(delta));
		if (velocity.y > -5) {
			velocity.y = -5;
		}*/
		life -= delta * 100;
		
		position.add(velocity.cpy().scl(delta));
		
		if(position.y < position.y - height){
			position.y = position.y;
		}
		
		if (isReadyToReturn()) {
			velocity.y += 480 * delta;
			
			position.add(velocity.cpy().scl(delta));
		}
	}

	public boolean isReadyToReturn() {
		return life == 0;
	}

	
	public void onClick() {
		velocity.y = height;
	}

	// ==============================================================
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
