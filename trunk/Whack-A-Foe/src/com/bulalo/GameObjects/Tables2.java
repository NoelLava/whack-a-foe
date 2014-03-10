package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Tables2 {
	private Vector2 position;
	private Rectangle bounds2;
	private int width;
	private int height;
	private boolean isPressed = false;
	private Tables table2;
	
	
	public Tables2(float x, float y, int width, int height){
		this.width = 22;
		this.height = 42;
		position = new Vector2(100,50);
		
		bounds2 = new Rectangle(x, y, width, height);
		
	}
	
	public boolean onClick2(int screenX, int screenY){
		System.out.println("table2 on GameScreen changed");
		setPressed(true);
		return bounds2.contains(100, 50);
	}
	
	public boolean isTouchDown2(float screenX, float screenY) {
	
        if (bounds2.contains(screenX,screenY)) {
        	System.out.println("table2 on GameScreen changed");
            String boundS2 = bounds2.toString();
            System.out.println(boundS2);
            isPressed = true;
            return true;
        } 
        return false;
    }

    public boolean isTouchUp2(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds2.contains(screenX, screenY) && isPressed) {
            System.out.println("Dummy - touch up");
            return true;
        }
        // Whenever a finger is released, we will cancel any presses.
        return false;

    }
    
    public void displayResult2(){
    	//System.out.println("pic3 clicked");
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
    
    public boolean isClicked(){
    	if(table2.isPressed()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

}
