//This is a temporary class for handling inputs in title screen
package com.bulalo.MenuWorld;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class MenuInputHandler implements InputProcessor {
	//private Dummy myDummy;
	private MenuWorld menuWorld;
	
	private static List<Button> menuButtons;
	
	private Button playButton, customButton, optionsButton;
	
	public MenuInputHandler(MenuWorld menuWorld){
		this.menuWorld = menuWorld;		
		menuButtons = new ArrayList<Button>();
		playButton = new Button(320/2 - (AssetLoader.redButton.getRegionWidth() * 2.12f), 512/2 - (AssetLoader.redButton.getRegionWidth() * 2.22f), 65 ,65, AssetLoader.redButton, AssetLoader.redPressed);
		optionsButton = new Button(320/2 - (AssetLoader.redButton.getRegionWidth() * 2.12f), 512/2 - (AssetLoader.redButton.getRegionWidth() * 1.63f), 65, 65, AssetLoader.yellowButton, AssetLoader.yellowPressed);
		customButton = new Button(320/2 - (AssetLoader.redButton.getRegionWidth() * 2.12f), 512/2 - (AssetLoader.redButton.getRegionWidth() * 1.05f), 65, 65, AssetLoader.blueButton, AssetLoader.bluePressed);
		//111.75f, 149.75f, 187.75f
		menuButtons.add(playButton);
		//menuButtons.add(optionsButton);
		//menuButtons.add(customButton);
	}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //screenX = (screenX);
        //screenY = (screenY);
        
        System.out.println(screenX + " " + screenY);
        playButton.isTouchDown(screenX, screenY);
        //optionsButton.isTouchDown(screenX, screenY);
        //customButton.isTouchDown(screenX, screenY);
    	
    	//myDummy.onClick(screenX,screenY);
    	return true;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	if (playButton.isTouchUp(screenX, screenY)) {
            //myWorld.ready();
            return true;
        }
    	
//    	if (optionsButton.isTouchUp(screenX, screenY)) {
//            //myWorld.ready();
//            return true;
//        }
//    	
//    	if (customButton.isTouchUp(screenX, screenY)) {
//            //myWorld.ready();
//            return true;
//        }
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
    
    public static List<Button> getMenuButtons() {
        return menuButtons;
    }

}
