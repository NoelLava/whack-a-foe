package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Tables1 {
	private Vector2 position;
	private Rectangle bounds1;
	private int width;
	private int height;
	private boolean isPressed;
	private Tables1 table1;
	
	
	public Tables1(float x, float y, int width, int height){
		this.width = 22;
		this.height = 42;
		position = new Vector2(60,50);
		
		bounds1 = new Rectangle(x, y, width, height);
		
	}
	
	public boolean onClick1(int screenX, int screenY){
		System.out.println("table1 on GameScreen changed");
		return bounds1.contains(60, 50);
	}
	
	public boolean isTouchDown1(float screenX, float screenY) {
	
        if (bounds1.contains(screenX,screenY)) {
        	System.out.println("table1 on GameScreen changed");
            String boundS1 = bounds1.toString();
            System.out.println(boundS1);
            return true;
        } 
        return false;
    }

    public boolean isTouchUp1(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds1.contains(screenX, screenY) && isPressed) {
            System.out.println("Dummy - touch up");
            return true;
        }
        // Whenever a finger is released, we will cancel any presses.
        return false;

    }
    
    public void displayResult1(){
    	//System.out.println("pic2 clicked");
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
