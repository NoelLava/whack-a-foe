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
	private static List<Button> sfxButtons;
	private static List<Button> bgmButtons;
	
	public MenuInputHandler(MenuWorld menuWorld, float scaleFactorX, float scaleFactorY){
		this.menuWorld = menuWorld;		
		
		menuButtons = MenuWorld.getMenuButtons();
		sfxButtons = MenuWorld.getSFXButtonOn();
		bgmButtons = MenuWorld.getBGMButtonOn();		
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
	
		// eto lang kim.sabi sayo boolean lang ===========
		if(MenuWorld.sfxOn){
			sfxButtons.get(index).isTouchDown(screenX, screenY);
		}else{
			sfxButtons.get(index + 1).isTouchDown(screenX, screenY);
		}
		
		if(MenuWorld.bgmOn){
			bgmButtons.get(index).isTouchDown(screenX, screenY);
		}else{
			bgmButtons.get(index + 1).isTouchDown(screenX, screenY);
		}
//		for(Button sfxButtonOn : sfxButtons){
//			
//			if(sfxButtons.get(index).isJustPressed()){
//				sfxTrue = false;
//				sfxButtons.get(index + 1).isTouchDown(screenX, screenY);
//				sfxButtons.get(index).setJustPressed(false);
//			}
//			if(sfxButtons.get(index + 1).isJustPressed()){
//				sfxTrue = true;
//				sfxButtons.get(index).isTouchDown(screenX, screenY);
//				sfxButtons.get(index + 1).setJustPressed(false);
//			}
//			
//		}
		
//		for(Button thisUseButton : bgmButtons){
//			thisUseButton.isTouchDown(screenX, screenY);
//		
//			if(bgmButtons.get(index).isJustPressed()){
//				bgmTrue = false;
//				bgmButtons.get(index + 1).isTouchDown(screenX, screenY);
//				bgmButtons.get(index).setJustPressed(false);
//			}
//			
//			if(bgmButtons.get(index + 1).isJustPressed()){
//				bgmTrue = true;
//				bgmButtons.get(index).isTouchDown(screenX, screenY);
//				bgmButtons.get(index + 1).setJustPressed(false);
//			}
//		}
		
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
    	
    	for(Button thisButton : sfxButtons){
    		if(thisButton.isTouchUp(screenX, screenY)){
    			return true;
    		}
    	}
    	
    	for(Button thisButton : bgmButtons){
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