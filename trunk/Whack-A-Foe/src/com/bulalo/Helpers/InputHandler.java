package com.bulalo.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Dummy;

public class InputHandler implements InputProcessor {
	private Dummy myDummy;
	
	public InputHandler(Dummy dummy){
		myDummy = dummy;
	}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myDummy.onClick();
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
