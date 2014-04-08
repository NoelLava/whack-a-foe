package com.bulalo.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dummy {
	private Vector2 position;

	private int life;
	private int width;
	private int height;
	Dummy myDummy;
	
	private Rectangle bounds;
	private boolean markedForRemoval;
	private boolean isPressed = false;
	
	public Dummy(int life, float x, float y, int width, int height){
		this.life = life;
		this.width = 32;
		this.height = 46;
		position = new Vector2(x,y);
		
		bounds = new Rectangle(x*2, y*2, width*2, height*2);
	}
	
	public void update(float delta){
		life--;
		if(life < 1){
			life = 0;
		}		
		System.out.println(life);
	}
	
	public boolean onClick(int screenX, int screenY){
		return bounds.contains(screenX, screenY);
	}
	
	public boolean isTouchDown(int screenX, int screenY) {

        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            life = 0;
            return true;
        }
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
            isPressed = false;
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
	
//	public int getPosition(){
//		if(position.x == 28 && position.y == 69){
//			return 0;
//		}else if(position.x == 64.25f && position.y == 69){
//			return 1;
//		}else if(position.x == 100 && position.y == 69){
//			return 2;
//		}else if(position.x == 22.5f && position.y == 124){
//			return 3;
//		}else if(position.x == 64.25f && position.y == 124){
//			return 4;
//		}else if(position.x == 105 && position.y == 124){
//			return 5;
//		}else if(position.x == 19 && position.y == 179.5f){
//			return 6;
//		}else if(position.x == 64 && position.y == 124){
//			return 7;
//		}else{// if(position.x == 109.25f && position.y == 124)
//			return 8;
//		}
//	}
	
	public void markToRemove(){
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
    	if(life == 0){
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

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

}
