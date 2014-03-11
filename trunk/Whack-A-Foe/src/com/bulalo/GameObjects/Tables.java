package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bulalo.CustomizeWorld.CustomizeRenderer;


public class Tables {
	private Vector2 position;
	private Rectangle bounds;
	private int width;
	private int height;
	private boolean isPressed = false;
	
	public Tables(float x, float y, int width, int height){
		this.width = 22;
		this.height = 42;
		position = new Vector2(x,y);
		
		bounds = new Rectangle(x, y, width, height);
		
	}
	
	public boolean onClick(int screenX, int screenY){
		System.out.println("table on GameScreen changed");
		setPressed(true);
		return bounds.contains(screenX, screenY);
	}
	
	public boolean isTouchDown(float screenX, float screenY) {
	
<<<<<<< HEAD
       /* if (bounds.contains(screenX,screenY)) {
        	AssetLoader.getBackground();
=======
        if (bounds.contains(screenX,screenY)) {
        	System.out.println("table1 on GameScreen changed");
            String boundS1 = bounds.toString();
            System.out.println(boundS1);
        	//background = 
        	setPressed(true);
>>>>>>> bac9c1b009c398e52d6057a9d9496b71e26aade3
        	return true;
        } */
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed()) {
        	
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
    
    public boolean isClicked(){
    	if(table.isPressed()){
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
