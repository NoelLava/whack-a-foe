package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bulalo.GameWorld.GameWorld;

public class Hammers {
	private Vector2 position;
	private Rectangle bounds;
	private float x, y, width, height;
	private boolean isPressed = false;
	
	public Hammers(float x, float y, float width, float height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		position = new Vector2(x,y);
		
		bounds = new Rectangle(x, y, width, height);	
	}
	
	public boolean onClick(int screenX, int screenY){
		System.out.println("Hammer is changed");
		return bounds.contains(screenX, screenY);
	}
	
	public boolean isTouchDown(float screenX, float screenY) {
	
        if (bounds.contains(screenX,screenY)) {
        	isPressed = true;
        	System.out.println("hammer - hit");
        	return true;
        } 
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed()) {
        	isPressed = false;
            System.out.println("hammer - touch up");
            return true;
        }
        // Whenever a finger is released, we will cancel any presses.
        isPressed = false;
        return false;

    }
    
    public void displayResult(){
		System.out.println("pic1 clicked");
    	if(isPressed){
			System.out.println("hammer - clicked");
		}else{
			System.out.println("hammer - not hit");
		}
	}
    public void update(float delta){
		//System.out.println("table shown");
		//System.out.println(position);
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
    
    /*public boolean isClicked(){
    	if(table.isPressed()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }*/

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

}

