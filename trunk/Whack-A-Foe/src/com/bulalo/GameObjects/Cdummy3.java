package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Cdummy3 {
	private Vector2 position;
	private Rectangle c3bound;
	private int width;
	private int height;
	private boolean isPressed;

	
	
	public Cdummy3(float x, float y, int width, int height){
		this.width = 22;
		this.height = 42;
		position = new Vector2(20,50);
		
		c3bound = new Rectangle(x, y, width, height);
		
	}
	
	public boolean onClick(int screenX, int screenY){
		System.out.println("table on GameScreen changed");
		return c3bound.contains(screenX, screenY);
	}
	
	public boolean isTouchDown(float screenX, float screenY) {
	
        if (c3bound.contains(screenX,screenY)) {
        	System.out.println("table on GameScreen changed");
            String boundS = c3bound.toString();
            System.out.println(boundS);
            return true;
        } 
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (c3bound.contains(screenX, screenY) && isPressed) {
            System.out.println("Dummy - touch up");
            return true;
        }
        // Whenever a finger is released, we will cancel any presses.
        return false;

    }
    
    public void displayResult(){
		//System.out.println("pic1 clicked");
    	/*if(table.isTouchDown(20,-50)){
			System.out.println("table - clicked");
		}else{
			System.out.println("Dummy - not hit");
		}*/
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

}
