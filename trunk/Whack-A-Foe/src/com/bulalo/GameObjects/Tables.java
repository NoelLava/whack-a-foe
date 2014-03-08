package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Tables {
	private Vector2 position;
	private Rectangle bounds;
	private int width;
	private int height;
	private boolean isPressed;
	
	public Tables(float x, float y, int width, int height){
		this.width = 22;
		this.height = 42;
		position = new Vector2(x,y);
		
		bounds = new Rectangle(x*2, y*2, width*2, height*2);
	}
	
	public boolean isTouchDown(int screenX, int screenY) {

        if (bounds.contains(screenX, screenY)) {
            System.out.println("Dummy - hit");
            return true;
        } 
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
            System.out.println("Dummy - touch up");
            return true;
        }
        // Whenever a finger is released, we will cancel any presses.
        return false;

    }
    
    public void displayResult(){
		if(isPressed){
			System.out.println("table - clicked");
		}else{
			System.out.println("Dummy - not hit");
		}
	}
    public void update(float delta){
		System.out.println("table shown");
		System.out.println(position);
	}
    public void setX(float newX){
		position.x = newX;
	}
	
	public void setY(float newY){
		position.y = newY;
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
