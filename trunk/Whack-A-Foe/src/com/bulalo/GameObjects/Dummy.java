package com.bulalo.GameObjects;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dummy {
	private Vector2 position;

	private int life;
	private int width;
	private int height;
	private Dummy myDummy;
	
	private Rectangle bounds;
	private boolean markedForRemoval;
	private boolean isPressed = false;
	
	public Dummy(int life, float x, float y, int width, int height){
		this.life = life;
		this.width = 35;
		this.height = 50;
		position = new Vector2(x,y);
		
		bounds = new Rectangle(x*2, y*2, width*2, height*2);
	}
	
	public void update(float delta){
		life--;
		if(life <= 0){
			life = 0;
		}
		//System.out.println(life);
		//System.out.println(position);
	}
	
	public boolean onClick(int screenX, int screenY){
		System.out.println("Dummy - clicked");
		return bounds.contains(screenX, screenY);
	}
	
	public void displayResult(){
		if(isPressed){
			System.out.println("Dummy - hit");
		}else{
			System.out.println("Dummy - not hit");
		}
	}
	
	public boolean isTouchDown(int screenX, int screenY) {

        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            life = 0;
            System.out.println("Dummy - hit");
            return true;
        }
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
            isPressed = false;
            System.out.println("Dummy - touch up");
            return true;
        }
        // Whenever a finger is released, we will cancel any presses.
        isPressed = false;
        return false;
    }
	
	
	public void spawn(float x, float y){
		System.out.println("Dummy - spawn");
		myDummy = new Dummy(life, x, y, width, height);
		position = new Vector2(x,y);
		
		bounds = new Rectangle(x, y, (float)width, (float)height);
		markedForRemoval = false;
	
	}
	
	public void remove(){
		markedForRemoval = true;
	}	
	
	public void isNotMarked(){
		markedForRemoval = false;
	}
	
	public boolean isMarked(){
		return markedForRemoval;
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
    
    public boolean isAlive(){
    	if(life < 1){
    		return false;
    	}else{ 
    		return true;
    	}
    }

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
