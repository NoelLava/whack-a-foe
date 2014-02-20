package com.bulalo.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.WaFHelpers.AssetLoader;

public class GameRenderer {
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batcher;
	
	private int gameHeight;

	public GameRenderer(GameWorld world, int gameHeight) {
		myWorld = world;
		
		this.gameHeight = gameHeight;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, gameHeight);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {
		Dummy dummy = myWorld.getDummy();
		// 1. We draw a black background. This prevents flickering.
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// 2. We draw the Filled rectangle
		// Tells shapeRenderer to begin drawing filled shapes
		shapeRenderer.begin(ShapeType.Filled);

		// Chooses RGB Color of 87, 109, 120 at full opacity
		shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
		
		//Draw black shape for bg
		shapeRenderer.rect(0, 0, 136, gameHeight);

		shapeRenderer.end();

		//Begin SpriteBatch
		batcher.begin();
		
		// Disable transparency 
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        batcher.draw(AssetLoader.table, 0, 0, 136, gameHeight);

        // The bird needs transparency, so we enable that again.
        batcher.enableBlending();
        
        // Draw bird at its coordinates. Retrieve the Animation object from AssetLoader
        // Pass in the runTime variable to get the current frame.
        batcher.draw(AssetLoader.dummy, 17, 65, dummy.getWidth(), dummy.getHeight());
        
        // End SpriteBatch
        batcher.end();

	}

}
