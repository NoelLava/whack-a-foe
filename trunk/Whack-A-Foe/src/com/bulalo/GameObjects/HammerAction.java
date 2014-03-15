package com.bulalo.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.bulalo.Helpers.AssetLoader;

public class HammerAction {
	private float x, y, width, height;
	private int position;
	TextureRegion hammerAngle;
	TextureRegion hamLeft, hamMid, hamRight;
	
	private Rectangle bounds;
	
	boolean isPressed = false;
	boolean justPressed = false;
	
	public HammerAction(float x, float y, float width, float height,
			int position){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.position = position;
		
		bounds = new Rectangle(x, y, width, height);
	}

	public boolean isClicked(int screenX, int screenY){
		return bounds.contains(screenX, screenY);
	}
	
	public void draw(SpriteBatch batcher) {
		hamLeft = AssetLoader.HamWoodLeft;
		hamMid = AssetLoader.HamWoodMid;
		hamRight = AssetLoader.HamWoodRight;
		
        if (this.isPressed) {
        	if(position == 0 || position == 3 || position == 6){
        		batcher.draw(hamLeft, x, y, AssetLoader.HamWoodLeft.getRegionWidth()/2, AssetLoader.HamWoodLeft.getRegionHeight()/2);
        	}else if(position == 1 || position == 4 || position == 7){
        		batcher.draw(hamMid, x, y, AssetLoader.HamWoodMid.getRegionWidth()/2, AssetLoader.HamWoodMid.getRegionHeight()/2);
        	}else if(position == 2 || position == 5 || position == 8){
        		batcher.draw(hamRight, x, y, AssetLoader.HamWoodRight.getRegionWidth()/2, AssetLoader.HamWoodRight.getRegionHeight()/2);
        	}
        } else {
            batcher.draw(hamMid, 42.75f, 211.5f, width * 1.5f, height * 1.5f);
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
}
