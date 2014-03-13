//This is a temporary class for handling inputs in title screen
package com.bulalo.MenuWorld;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.UI.Button;

public class MenuInputHandler implements InputProcessor {

	private MenuWorld menuWorld;
	
	private static List<Button> menuButtons;
	
	public MenuInputHandler(MenuWorld menuWorld){
		this.menuWorld = menuWorld;		
		menuButtons = MenuWorld.getMenuButtons();
	}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        for(Button thisButton : menuButtons){
        	thisButton.isTouchDown(screenX / 2, screenY / 2);
        }
    	return true;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	
    	for(Button thisButton : menuButtons){
    		if(thisButton.isTouchUp(screenX / 2, screenY / 2)){
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
    

}
