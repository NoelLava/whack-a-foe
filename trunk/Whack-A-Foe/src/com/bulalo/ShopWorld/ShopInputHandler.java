package com.bulalo.ShopWorld;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.Helpers.AssetLoader;
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

	public static boolean steelIsBought = false;
	public static boolean goldIsBought = false;
	public static boolean woodIsBought = true;
	public static boolean insufficientTickets;

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

		shopButtons.get(0).isTouchDown(screenX, screenY);

		for (int index = 1; index < 3; index++) {
			shopButtons.get(index).isTouchDown(screenX, screenY);
			if (shopButtons.get(index).isJustPressed()) {
				buyButtons.get(index + 2).isTouchDown(screenX, screenY);
				shopButtons.get(index).setJustPressed(false);
			}
		}

		for (int index = 0; index < 3; index++) {
			hammerButtons.get(index).isTouchDown(screenX, screenY);
			if (hammerButtons.get(index).isJustPressed()) {
				if (index == 1) {
					if (steelIsBought == false) {
						buyButtons.get(index).isTouchDown(screenX, screenY);
					} else {
						useButtons.get(index).isTouchDown(screenX, screenY);
					}
				} else if (index == 2) {
					if (goldIsBought == false) {
						buyButtons.get(index).isTouchDown(screenX, screenY);
					} else {
						useButtons.get(index).isTouchDown(screenX, screenY);
					}
				} else if (index == 0) {
					if (woodIsBought == false) {
						buyButtons.get(index).isTouchDown(screenX, screenY);
					} else {
						useButtons.get(index).isTouchDown(screenX, screenY);
					}
				}
				hammerButtons.get(index).setJustPressed(false);
			}

			if (useButtons.get(index).isJustPressed()) {
				if (index == 0) {
					hammer1True = false;
					hammer2True = false;
					hammerTrue = true;
				} else if (index == 1) {
					hammerTrue = false;
					hammer2True = false;
					hammer1True = true;
				} else if (index == 2) {
					hammer1True = false;
					hammerTrue = false;
					hammer2True = true;
				}
				useButtons.get(index).setJustPressed(false);
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

	public void computeTickets(int price) {
		if (AssetLoader.getTicket() >= price) {
			int ticketVal = AssetLoader.getTicket() - price;
			AssetLoader.setTicket(ticketVal);

			insufficientTickets = false;
		} else {
			insufficientTickets = true;
		}
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
