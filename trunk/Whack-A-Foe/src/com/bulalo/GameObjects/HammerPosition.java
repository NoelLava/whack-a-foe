package com.bulalo.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class HammerPosition {
	private float x, y, width, height;
	private int position;
	TextureRegion hammerAngle;
	TextureRegion hamLeft, hamMid, hamRight;
	
	private Rectangle bounds;
	
	boolean isPressed = false;
	boolean justPressed = false;
	
	public HammerPosition(float x, float y, float width, float height,
			int position){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.position = position;
		
		bounds = new Rectangle(x, y, width, height);
		//this.hitSound = hitSound;
	}

	public boolean isClicked(int screenX, int screenY){
		return bounds.contains(screenX, screenY);
	}
	
	public void draw(SpriteBatch batcher, TextureRegion hamLeft, TextureRegion hamMid, TextureRegion hamRight) {
		
        if (this.isPressed) {
        	if(position == 0 || position == 3 || position == 6){
        		batcher.draw(hamLeft, x - (hamLeft.getRegionWidth()/12), y + (hamLeft.getRegionHeight()/(x*2.75f)), hamLeft.getRegionWidth()/2, hamLeft.getRegionHeight()/2);
        	}else if(position == 1 || position == 4 || position == 7){
        		batcher.draw(hamMid, x - (hamMid.getRegionWidth()/12), y + (hamMid.getRegionHeight()/(x*0.75f)), hamMid.getRegionWidth()/2, hamMid.getRegionHeight()/2);
        	}else if(position == 2 || position == 5 || position == 8){
        		batcher.draw(hamRight, x - (hamLeft.getRegionWidth()/12), y + (hamRight.getRegionHeight()/(x*0.5f)), hamRight.getRegionWidth()/2, hamRight.getRegionHeight()/2);
        	}
        } else {
        	if(position == 9){
        		batcher.draw(hamMid, x - (hamMid.getRegionWidth()/12), y, hamMid.getRegionWidth()/2, hamMid.getRegionHeight()/2);
        	}
        }
    }

    public boolean isTouchDown(int screenX, int screenY) {

        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            return true;
        }
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
            isPressed = false;
            justPressed = true;
            return true;
        }
        
        // Whenever a finger is released, we will cancel any presses.
        isPressed = false;
        justPressed = false;
        return false;
    }

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public TextureRegion getHammerTexture() {
		return hammerAngle;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public boolean isJustPressed() {
		return justPressed;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setHammerTexture(TextureRegion hammerAngle) {
		this.hammerAngle = hammerAngle;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

	public void setJustPressed(boolean justPressed) {
		this.justPressed = justPressed;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
