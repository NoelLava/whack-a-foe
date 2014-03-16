package com.bulalo.Helpers;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.HammerPosition;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.UI.Button;

public class InputHandler implements InputProcessor {
	private GameWorld myWorld;
	private Dummy myDummy;
	
	private static List<Dummy> dummies;	
	private static List<Button> gameButtons;
	private static List<HammerPosition> hammerAngles;

	float scaleFactorX;
	float scaleFactorY;

	public InputHandler(GameWorld myWorld, float scaleFactorX,
			float scaleFactorY) {
		this.myWorld = myWorld;
		dummies = GameWorld.getDummies();
		gameButtons = GameWorld.getGameButtons();
		hammerAngles = GameWorld.getHammerAngles();

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
			
			for(HammerPosition hammerAngle : hammerAngles){
				hammerAngle.isTouchDown(screenX, screenY);
				if(dummy.isPressed() || hammerAngle.isPressed()){
					hammerAngle.setHitSound(AssetLoader.hitSmash);
				}else{
					hammerAngle.setHitSound(AssetLoader.hitEmpty);
				}
			}
		}

		for (Button thisButton : gameButtons) {
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
		
		for (Button thisButton : gameButtons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
				return true;
			}
		}
		
		for(HammerPosition hammerAngle : hammerAngles){
			if(hammerAngle.isTouchUp(screenX, screenY)){
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
