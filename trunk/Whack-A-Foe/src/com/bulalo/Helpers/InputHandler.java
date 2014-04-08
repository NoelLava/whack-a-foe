package com.bulalo.Helpers;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.HammerPosition;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.UI.Button;

public class InputHandler implements InputProcessor {
	private GameWorld myWorld;
	Dummy myDummy;

	private static List<Dummy> dummies;
	private static List<Dummy> friends;
	private static List<Button> gameButtons;
	private static List<Button> gameOverButtons;
	private static List<Button> gamePausedButtons;
	private static List<HammerPosition> hammerAngles;

	static boolean woodTrue, steelTrue, carbonTrue, bossTrue,
			farmerTrue, boyTrue;

	float scaleFactorX;
	float scaleFactorY;
	public static int dummyPoints = 1;

	public InputHandler(GameWorld myWorld, float scaleFactorX,
			float scaleFactorY) {
		this.myWorld = myWorld;
		dummies = GameWorld.getDummies();
		friends = GameWorld.getFriends();
		gameButtons = GameWorld.getGameButtons();
		gameOverButtons = GameWorld.getGameOverButtons();
		gamePausedButtons = GameWorld.getGamePausedButtons();
		hammerAngles = GameWorld.getHammerAngles();

		this.scaleFactorX = scaleFactorX;
		this.scaleFactorY = scaleFactorY;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		if (myWorld.isRunning()) {

			for (Button thisButton : gameButtons) {
				thisButton.isTouchDown(screenX, screenY);
			}

			for (Dummy dummy : dummies) {
				dummy.isTouchDown(screenX, screenY);
				for (HammerPosition hammerAngle : hammerAngles) {
					hammerAngle.isTouchDown(screenX, screenY);
					if (dummy.isPressed() && hammerAngle.isPressed()) {
						addScore(dummyPoints);
						AssetLoader.hitSmash.play();
						AssetLoader.hitEmpty.stop();
					} else if (hammerAngle.isPressed()) {
						AssetLoader.hitEmpty.play();
					}
				}
			}

			for (Dummy friend : friends) {
				friend.isTouchDown(screenX, screenY);
				if (friend.isPressed()) {
					addScore(-5);
					AssetLoader.hitFriend.play();
					AssetLoader.hitEmpty.stop();
				}
				// if(friend.isPressed() && hammerAngle.isPressed()){
				// AssetLoader.hitFriend.play();
				// }
			}

		} else if (myWorld.isPaused()) {

			for (Button Pbutton : gamePausedButtons) {
				Pbutton.isTouchDown(screenX, screenY);
			}

		} else if (myWorld.isGameOver()) {
			for (Button Gbutton : gameOverButtons) {
				Gbutton.isTouchDown(screenX, screenY);
			}
		}

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);

		if (myWorld.isRunning()) {
			for (Button thisButton : gameButtons) {

				if (thisButton.isTouchUp(screenX, screenY)) {
					return true;
				}
			}
			for (Dummy dummy : dummies) {
				if (dummy.isTouchUp(screenX, screenY)) {
					return true;
				}
			}
			for (Dummy friend : friends) {
				if (friend.isTouchUp(screenX, screenY)) {
					return true;
				}
			}
			for (HammerPosition hammerAngle : hammerAngles) {
				if (hammerAngle.isTouchUp(screenX, screenY)) {
					return true;
				}
			}
		} else if (myWorld.isPaused()) {

			for (Button PButton : gamePausedButtons) {
				if (PButton.isTouchUp(screenX, screenY)) {
					return true;
				}
			}

		} else if (myWorld.isGameOver()) {
			for (Button GButton : gameOverButtons) {
				if (GButton.isTouchUp(screenX, screenY)) {
					return true;
				}
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

	private void addScore(int increment) {
		myWorld.addScore(increment);
	}

	void subtractScore(int decrement) {
		myWorld.subtractScore(decrement);
	}

	public static List<Dummy> getDummies() {
		return dummies;
	}
}
