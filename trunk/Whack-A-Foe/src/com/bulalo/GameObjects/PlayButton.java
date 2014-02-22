package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class PlayButton {

	private Vector2 position;
	private int height, width;
	
	public PlayButton(int width, int height){
		this.height = height;
		this.width = width;
		position = new Vector2(60,284);
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

    public void update(float delta){
    	System.out.println(position);
    	
    }
	
	public void onClick(){
		
	}
	
	
	
}
