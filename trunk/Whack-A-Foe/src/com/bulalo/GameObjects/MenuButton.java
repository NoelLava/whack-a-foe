package com.bulalo.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.bulalo.Screens.GameScreen;

public class MenuButton {

	private Vector2 position;
	private int height, width;
	
	public MenuButton(float x, float y,int width, int height){
		this.height = height;
		this.width = width;
		//60, 284
		position = new Vector2(x,y);
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
		System.out.println("Button - Clicked");
	}
	
	
	
}
