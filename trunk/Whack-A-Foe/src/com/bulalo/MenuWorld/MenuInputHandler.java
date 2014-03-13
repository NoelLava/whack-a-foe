//This is a temporary class for handling inputs in title screen
package com.bulalo.MenuWorld;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.UI.Button;

public class MenuInputHandler implements InputProcessor {

	private MenuWorld menuWorld;
	
	float scaleFactorX;
	float scaleFactorY;
	
	private static List<Button> menuButtons;
	
	public MenuInputHandler(MenuWorld menuWorld, float scaleFactorX, float scaleFactorY){
		this.menuWorld = menuWorld;		
		menuButtons = MenuWorld.getMenuButtons();
		
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
        for(Button thisButton : menuButtons){
        	thisButton.isTouchDown(screenX, screenY);
        }
    	return true;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	screenX = scaleX(screenX);
        screenY = scaleY(screenY);
    	
    	for(Button thisButton : menuButtons){
    		if(thisButton.isTouchUp(screenX, screenY)){
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    
	private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }
    
}
