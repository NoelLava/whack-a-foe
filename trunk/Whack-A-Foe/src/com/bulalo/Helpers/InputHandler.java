package com.bulalo.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameWorld.GameWorld;

public class InputHandler implements InputProcessor {
	private Dummy myDummy;
	private GameWorld myWorld;
	
	public InputHandler(GameWorld myWorld){
		this.myWorld = myWorld;
		myDummy = myWorld.getDummy();
	}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	myDummy.isTouchDown(screenX/2,screenY/2);
    	myDummy.displayResult();
    	return true;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(myDummy.isTouchUp(screenX/2,screenY/2)){
        	return true;
        }
        myDummy.displayResult();
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
