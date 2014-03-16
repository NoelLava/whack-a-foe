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
import com.bulalo.Helpers.InputHandler;
import com.bulalo.UI.Button;

public class GameRenderer {
	private GameWorld myWorld;
	private ShapeRenderer shapeRenderer;

	private OrthographicCamera cam;
	private CustomInputHandler custom = new CustomInputHandler();
	private SpriteBatch batcher;

	private Dummy dummy;
	private List<Dummy> dummies;
	private List<Button> gameButtons;
	private List<HammerPosition> hammerPositions;

	private TextureRegion hammerAngle;
	private TextureRegion table;
	private Animation dummyAnimation;
	private Animation dummyDies;

	public GameRenderer(GameWorld world) {
		myWorld = world;
		this.dummies = InputHandler.getDummies();
		this.gameButtons = GameWorld.getGameButtons();
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
	}

	private void initAssets() {
		table = AssetLoader.table;
		
		hammerAngle = AssetLoader.HamWoodMid;
		
		dummyAnimation = AssetLoader.dummyAnimation;
		dummyDies = AssetLoader.dummyDies;
	}

	public void drawDummy(float runTime) {
		for (Dummy dummy : dummies) {
			if (dummy.isAlive()) {

				batcher.draw(dummyAnimation.getKeyFrame(runTime), dummy.getX(),
						dummy.getY(), dummy.getWidth(), dummy.getHeight());
			} else {
				System.out.println("Renderer draw dies");
				batcher.draw(dummyDies.getKeyFrame(runTime), dummy.getX(),
						dummy.getY(), dummy.getWidth(), dummy.getHeight());
			}
		}
	}

	private void drawButtons() {
		for (Button button : gameButtons) {
			button.draw(batcher);
		}
	}

	private void drawHammers(){
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
		}else{
			hammerPositions.get(9).setPressed(false);
		}
		
		for(HammerPosition hammerPosition : hammerPositions){
			hammerPosition.draw(batcher);
		}
	}
	
	private TextureRegion getTable() {
		return this.table;
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
		
		getTable();
		batcher.draw(table, 0, 0, 160, 256);

		batcher.enableBlending();

		drawDummy(runTime);
		drawButtons();
		drawHammers();

		// End SpriteBatch
		batcher.end();

	}
}
