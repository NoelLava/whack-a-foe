//This is a temporary class for handling inputs in title screen
package com.bulalo.MenuWorld;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.UI.Button;

public class MenuInputHandler implements InputProcessor {

	private MenuWorld menuWorld;
	
	float scaleFactorX;
	float scaleFactorY;
	
	private static boolean sfxTrue, bgmTrue;
	
	private static List<Button> menuButtons;
	private static List<Button> sfxButtonsOn;
	private static List<Button> bgmButtonsOn;
	private static List<Button> sfxButtonsOff;
	private static List<Button> bgmButtonsOff;
	
	public MenuInputHandler(MenuWorld menuWorld, float scaleFactorX, float scaleFactorY){
		this.menuWorld = menuWorld;		
		
		menuButtons = MenuWorld.getMenuButtons();
		sfxButtonsOn = MenuWorld.getSFXButtonOn();
		bgmButtonsOn = MenuWorld.getBGMButtonOn();
		sfxButtonsOff = MenuWorld.getSFXButtonOff();
		bgmButtonsOff = MenuWorld.getBGMButtonOff();
		
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	}
	
	public MenuInputHandler(){
		System.out.println("initialize");
	}
	
	public boolean checkSFX(){
		return sfxTrue;
	}
	
	public boolean checkBGM(){
		return bgmTrue;
	}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		int index = 0;
		
		menuButtons.get(0).isTouchDown(screenX, screenY);
		menuButtons.get(1).isTouchDown(screenX, screenY);
		menuButtons.get(2).isTouchDown(screenX, screenY);
	
		for(Button thisUseButton : sfxButtonsOn){
			thisUseButton.isTouchDown(screenX, screenY);
			
			if(sfxButtonsOn.get(index).isJustPressed()){
				sfxTrue = false;
				sfxButtonsOff.get(index).isTouchDown(screenX, screenY);
				sfxButtonsOn.get(index).setJustPressed(false);
			
			}
			
			if(sfxButtonsOff.get(index).isJustPressed()){
				sfxTrue = true;
				sfxButtonsOn.get(index).isTouchDown(screenX, screenY);
				sfxButtonsOff.get(index).setJustPressed(false);
			}
			
		}
		
		for(Button thisUseButton : bgmButtonsOn){
			thisUseButton.isTouchDown(screenX, screenY);
		
			if(bgmButtonsOn.get(index).isJustPressed()){
				bgmTrue = false;
				bgmButtonsOff.get(index).isTouchDown(screenX, screenY);
				bgmButtonsOn.get(index).setJustPressed(false);
			}
			
			if(bgmButtonsOff.get(index).isJustPressed()){
				bgmTrue = true;
				bgmButtonsOn.get(index).isTouchDown(screenX, screenY);
				bgmButtonsOff.get(index).setJustPressed(false);
			}
		}
		
    	return false;
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
    	
    	for(Button thisButton : sfxButtonsOn){
    		if(thisButton.isTouchUp(screenX, screenY)){
    			return true;
    		}
    	}
    	
    	for(Button thisButton : bgmButtonsOn){
    		if(thisButton.isTouchUp(screenX, screenY)){
    			return true;
    		}
    	}
    	
    	for(Button thisButton : sfxButtonsOff){
    		if(thisButton.isTouchUp(screenX, screenY)){
    			return true;
    		}
    	}
    	
    	for(Button thisButton : bgmButtonsOff){
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