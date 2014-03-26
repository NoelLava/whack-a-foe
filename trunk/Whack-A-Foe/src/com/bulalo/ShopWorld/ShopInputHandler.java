package com.bulalo.ShopWorld;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Upgrades;
import com.bulalo.UI.Button;

public class ShopInputHandler implements InputProcessor {
	private ShopWorld shopWorld;

	private static boolean hammerTrue;
	private static boolean hammer1True;
	private static boolean hammer2True;

	private static List<Button> shopButtons;
	private static List<Button> hammerButtons;
	private static List<Button> buyButtons;
	private static List<Button> useButtons;

	float scaleFactorX;
	float scaleFactorY;

	public ShopInputHandler(ShopWorld shopWorld, float scaleFactorX,
			float scaleFactorY) {
		this.shopWorld = shopWorld;

		shopButtons = ShopWorld.getShopButtons();
		hammerButtons = ShopWorld.getHammerButtons();
		buyButtons = ShopWorld.getBuyButtons();
		useButtons = ShopWorld.getUseButtons();

		this.scaleFactorX = scaleFactorX;
		this.scaleFactorY = scaleFactorY;
	}

	public ShopInputHandler() {
		System.out.println("initialized");

	}

	public boolean checkHammer() {
		return hammerTrue;
	}

	public boolean checkHammer1() {
		return hammer1True;
	}

	public boolean checkHammer2() {
		return hammer2True;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		for (Button thisButton : shopButtons) {
			thisButton.isTouchDown(screenX, screenY);
		}

		for (int index = 0; index < 3; index++) {
			hammerButtons.get(index).isTouchDown(screenX, screenY);
			if (hammerButtons.get(index).isJustPressed()) {
				buyButtons.get(index).isTouchDown(screenX, screenY);
				hammerButtons.get(index).setJustPressed(false);
				if(buyButtons.get(index).isJustPressed()){
					useButtons.get(index).isTouchDown(screenX, screenY);
					if (useButtons.get(0).isJustPressed()) {
						hammer1True = false;
						hammer2True = false;
						hammerTrue = true;
						useButtons.get(index).setJustPressed(false);
					} else if (useButtons.get(1).isJustPressed()) {
						hammerTrue = false;
						hammer2True = false;
						hammer1True = true;
						useButtons.get(index).setJustPressed(false);
					} else if (useButtons.get(2).isJustPressed()) {
						hammer1True = false;
						hammerTrue = false;
						hammer2True = true;
						useButtons.get(index).setJustPressed(false);
					}
					buyButtons.get(index).setJustPressed(false);
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		for (Button thisButton : hammerButtons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
				return true;
			}
		}
		for (Button thisButton : useButtons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
				return true;
			}
		}

		for (Button thisButton : shopButtons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
				return true;
			}
		}
		for (Button thisButton : buyButtons) {
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

	public boolean falseCheck() {
		return hammerTrue = false;

	}

	public boolean falseCheck1() {
		return hammer1True = false;

	}

	public boolean falseCheck2() {
		return hammer2True = false;

	}

}
