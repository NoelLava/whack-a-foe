//This Class is the one responsible for rendering the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.CustomizeWorld.CustomInputHandler;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.HammerPosition;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.ShopWorld.ShopInputHandler;
import com.bulalo.UI.Button;

public class GameRenderer {
	private GameWorld myWorld;
	private ShapeRenderer shapeRenderer;

	private OrthographicCamera cam;
	private CustomInputHandler custom = new CustomInputHandler();
	private ShopInputHandler shop = new ShopInputHandler();
	private SpriteBatch batcher;

	private Dummy dummy;
	private List<Dummy> dummies;
	private List<Button> gameButtons;
	private List<Button> gameOverButtons;
	private Button resumeButton;
	
	private List<HammerPosition> hammerPositions;
	private TextureRegion hamLeft, hamMid, hamRight;
	private TextureRegion table;
	private Animation dummyDefault;
	private Animation dummyDefaultDies;
	private Animation dummyJanitor;
	private Animation dummyJanitorDies;
	private Animation dummyOffice;
	private Animation dummyOfficeDies;
	private Animation thisAnimation;
	private Animation thisAnimationDies;
	private Animation dummyAnimation;
	private Animation dummyDies;
	private Animation tableScreen;

	public GameRenderer(GameWorld world) {
		myWorld = world;
		// this.dummies = InputHandler.getDummies();
		this.gameButtons = GameWorld.getGameButtons();
		this.gameOverButtons = GameWorld.getGameOverButtons();
		this.hammerPositions = GameWorld.getHammerAngles();

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		initGameObjects();
		initAssets();
	}

	private void initGameObjects() {
		dummies = GameWorld.getDummies();
		resumeButton = myWorld.getResumeButton();
	}

	private void initAssets() {
		table = AssetLoader.table;

		hamLeft = AssetLoader.HamWoodLeft;
		hamMid = AssetLoader.HamWoodMid;
		hamRight = AssetLoader.HamWoodRight;

		thisAnimation = AssetLoader.defaultDummyAnimation;
		thisAnimationDies = AssetLoader.defaultDummyDies;

		dummyAnimation = AssetLoader.dummyAnimation;
		dummyDies = AssetLoader.dummyDies;
		tableScreen = AssetLoader.tableScreen;
	}

	public void drawDummy(Animation animation, Animation animationDies,
			float runTime) {
		for (Dummy dummy : dummies) {
			if (dummy.isAlive()) {

				batcher.draw(animation.getKeyFrame(runTime), dummy.getX(),
						dummy.getY(), dummy.getWidth(), dummy.getHeight());
			} else {
				System.out.println("Renderer draw dies");
				batcher.draw(animationDies.getKeyFrame(runTime), dummy.getX(),
						dummy.getY(), dummy.getWidth(), dummy.getHeight());
			}
		}
	}

	private void drawButtons() {
		if (myWorld.isReady() || myWorld.isRunning()) {
			for (Button button : gameButtons) {
				button.draw(batcher);
			}
		} else if (myWorld.isGameOver() || myWorld.isPaused()) {
			resumeButton.draw(batcher);
			
			for (Button thisButton : gameOverButtons) {
				thisButton.draw(batcher);
			}
		}
	}

	private void drawHammers() {
		if (hammerPositions.get(0).isPressed()
				|| hammerPositions.get(1).isPressed()
				|| hammerPositions.get(2).isPressed()
				|| hammerPositions.get(3).isPressed()
				|| hammerPositions.get(4).isPressed()
				|| hammerPositions.get(5).isPressed()
				|| hammerPositions.get(6).isPressed()
				|| hammerPositions.get(7).isPressed()
				|| hammerPositions.get(8).isPressed()) {
			hammerPositions.get(9).setPressed(true);
		} else {
			hammerPositions.get(9).setPressed(false);
		}

		for (HammerPosition hammerPosition : hammerPositions) {
			hammerPosition.draw(batcher, hamLeft, hamMid, hamRight);
		}
	}

	private void drawScoreTime(float runTime) {
		// batcher.draw(tableScreen.getKeyFrame(runTime), 32f, 24, 94, 38.5f);
		int length = ("" + myWorld.getScore()).length();

		if (myWorld.isReady()) {
			AssetLoader.digital.setScale(.75f, -.75f);
			AssetLoader.digitalShadow.setScale(.75f, -.75f);

			AssetLoader.digitalShadow.draw(batcher,
					"" + myWorld.getReadyCount(), 79, 35);
			AssetLoader.digital.draw(batcher, "" + myWorld.getReadyCount(), 79,
					35);

		} else {
			batcher.draw(AssetLoader.timeScore, 32f, 24, 94, 38.5f);
			AssetLoader.digital.setScale(.5f, -.5f);
			AssetLoader.digitalShadow.setScale(.5f, -.5f);

			AssetLoader.digitalShadow.draw(batcher, "" + myWorld.getScore(),
					54 - (3 * length), 44.75f);
			AssetLoader.digital.draw(batcher, "" + myWorld.getScore(),
					54 - (3 * length), 43.75f);

			AssetLoader.digitalShadow.draw(batcher, "" + myWorld.getSeconds()
					+ ":" + myWorld.getMilis(), 94, 44.75f);
			AssetLoader.digital.draw(batcher, "" + myWorld.getSeconds() + ":"
					+ myWorld.getMilis(), 94, 43.75f);
		}
	}

	private void drawGameOver() {
		int length = ("" + myWorld.getScore()).length();

		batcher.draw(AssetLoader.gameOverScreen, 7.5f, 7.5f,
				AssetLoader.gameOverScreen.getRegionWidth() / 2,
				AssetLoader.gameOverScreen.getRegionHeight() / 2);

		batcher.draw(AssetLoader.ticket, 55, 105,
				AssetLoader.ticket.getRegionWidth() / 2,
				AssetLoader.ticket.getRegionHeight() / 2);

		AssetLoader.bit.draw(batcher, "" + myWorld.getScore(),
				66 - (8 * length), 74);
		AssetLoader.bitWhite.draw(batcher, "" + myWorld.getScore(),
				69 - (8 * length), 72);

	}

	private void drawPause() {
		batcher.draw(AssetLoader.pause, -15, 63.5f,
				AssetLoader.pause.getRegionWidth() / 2,
				AssetLoader.pause.getRegionHeight() / 2);
	}

	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// tells the shaperenderer to begin
		shapeRenderer.begin(ShapeType.Filled);

		// Draw Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 160, 256);

		// Tells the shapeRenderer to finish rendering
		// We MUST do this every time.
		shapeRenderer.end();

		// Begin SpriteBatch
		batcher.begin();

		// Disable transparency
		// This is good for performance when drawing images that do not require
		// transparency.
		batcher.disableBlending();

		getTable();
		batcher.draw(table, 0, 0, 160, 256);

		batcher.enableBlending();

		changeDummyAnimation();
		changeHammer();
		drawScoreTime(runTime);

		if (myWorld.isRunning()) {
			drawDummy(thisAnimation, thisAnimationDies, runTime);
			drawHammers();
			
		} else if(myWorld.isPaused()){
			drawPause();
			
		}else if (myWorld.isGameOver()) {
			drawGameOver();
		}

		drawButtons();
		// End SpriteBatch
		batcher.end();
	}

	private TextureRegion getTable() {
		if (custom.checkTable() == true) {
			this.table = AssetLoader.wood;
			custom.falseCheck();
		} else if (custom.checkTable1() == true) {
			this.table = AssetLoader.steel;
			custom.falseCheck1();
		} else if (custom.checkTable2() == true) {
			this.table = AssetLoader.carbon;
			custom.falseCheck2();
		}

		return this.table;
	}

	private void changeDummyAnimation() {
		if (custom.checkDummy2() == true) {
			this.thisAnimation = AssetLoader.defaultDummyAnimation;
			this.thisAnimationDies = AssetLoader.defaultDummyDies;

			custom.falseDummy2();
		} else if (custom.checkDummy() == true) {
			this.thisAnimation = AssetLoader.officeDummyAnimation;
			this.thisAnimationDies = AssetLoader.officeDummyDies;

			custom.falseDummy();
		} else if (custom.checkDummy1() == true) {
			this.thisAnimation = AssetLoader.janitorDummyAnimation;
			this.thisAnimationDies = AssetLoader.janitorDummyDies;

			custom.falseDummy1();
		}
	}

	private void changeHammer() {
		if (shop.checkHammer() == true) {
			this.hamLeft = AssetLoader.HamWoodLeft;
			this.hamMid = AssetLoader.HamWoodMid;
			this.hamRight = AssetLoader.HamWoodRight;
			shop.falseCheck();
		} else if (shop.checkHammer1() == true) {
			this.hamLeft = AssetLoader.HamSteelLeft;
			this.hamMid = AssetLoader.HamSteelMid;
			this.hamRight = AssetLoader.HamSteelRight;
			shop.falseCheck1();
		} else if (shop.checkHammer2() == true) {
			this.hamLeft = AssetLoader.HamGoldLeft;
			this.hamMid = AssetLoader.HamGoldMid;
			this.hamRight = AssetLoader.HamGoldRight;
			shop.falseCheck2();
		}
	}

}
