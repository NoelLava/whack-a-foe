package com.bulalo.Helpers;

import java.util.ArrayList;
import java.util.List;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.ShopWorld.ShopWorld;
import com.bulalo.UI.Button;

public class InputHandler implements InputProcessor {
	private Dummy myDummy;
	private static List<Dummy> dummies;
	private GameWorld myWorld;
	private CustomWorld customize;
	private Tables table;
	private Tables table1;
	private Tables table2;
	
	private static List<Button> buttons;

	float scaleFactorX;
	float scaleFactorY;

	public InputHandler(GameWorld myWorld, float scaleFactorX,
			float scaleFactorY) {
		this.myWorld = myWorld;
		dummies = myWorld.getDummies();
//		buttons = new ArrayList<Button>();

		this.scaleFactorX = scaleFactorX;
		this.scaleFactorY = scaleFactorY;

	}

	public InputHandler(CustomWorld customize, float scaleFactorX,
			float scaleFactorY) {
		buttons = new ArrayList<Button>();
		
		this.customize = customize;
		table = customize.getTable();
		table1 = customize.getTable();
		table2 = customize.getTable();
		
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		for (Dummy dummy : dummies) {
			dummy.isTouchDown(screenX, screenY);
			dummy.displayResult();
		}

		for (Button thisButton : buttons) {
			thisButton.isTouchDown(screenX, screenY);
		}

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		for (Dummy dummy : dummies) {
			if (dummy.isTouchUp(screenX, screenY)) {
				return true;
			}
			dummy.displayResult();
		}
		
		for (Button thisButton : buttons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
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

	public static List<Dummy> getDummies() {
		return dummies;
	}

}
