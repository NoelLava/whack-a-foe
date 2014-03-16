package com.bulalo.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.bulalo.Helpers.AssetLoader;

public class Button {

	private float x, y, width, height;

	private TextureRegion buttonUp;
	private TextureRegion buttonDown;

	private Rectangle bounds;

	boolean isPressed = false;
	boolean justPressed = false;
	
	public Button(float x, float y, float width, float height,
			TextureRegion buttonUp, TextureRegion buttonDown) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.buttonUp = buttonUp;
		this.buttonDown = buttonDown;
		
		bounds = new Rectangle(x, y, width, height);
	}
	
	public boolean isClicked(int screenX, int screenY){
		return bounds.contains(screenX, screenY);
	}
	
	public void draw(SpriteBatch batcher) {
        if (this.isPressed) {
            batcher.draw(buttonDown, x, y, width, height);
        } else {
            batcher.draw(buttonUp, x, y, width, height);
        }
    }

    public boolean isTouchDown(int screenX, int screenY) {

        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            AssetLoader.buttonDown.play();
            return true;
        }
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        
        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
        	AssetLoader.buttonUp.play();
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

	public Rectangle getBounds() {
		return bounds;
	}

	public boolean isPressed() {
		return isPressed;
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

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

	public TextureRegion getButtonUp() {
		return buttonUp;
	}

	public TextureRegion getButtonDown() {
		return buttonDown;
	}

	public void setButtonUp(TextureRegion buttonUp) {
		this.buttonUp = buttonUp;
	}

	public void setButtonDown(TextureRegion buttonDown) {
		this.buttonDown = buttonDown;
	}

	public boolean isJustPressed() {
		return justPressed;
	}

	public void setJustPressed(boolean justPressed) {
		this.justPressed = justPressed;
	}
}
