package com.bulalo.CustomizeWorld;

import com.badlogic.gdx.InputProcessor;

public class CustomInputHandler implements InputProcessor{

	private CustomWorld customWorld;
	
	public CustomInputHandler(CustomWorld customWorld){
		this.customWorld = customWorld;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

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
