package com.bulalo.MenuWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.MenuButton;
import com.bulalo.Helpers.AssetLoader;

public class MenuRenderer {
	private ShapeRenderer shapeRenderer;
	private MenuWorld menu;
	private OrthographicCamera cam;
	private SpriteBatch batcher;

	public MenuRenderer(MenuWorld world) {
		menu = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

	}

	public void render(float runTime) {
		MenuButton playButton = menu.getPlayButton();
		MenuButton optionsButton = menu.getOptionsButton();
		MenuButton customButton = menu.getCustomButton();

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
		batcher.draw(AssetLoader.titleBg, 0, 0, 160, 256);

		// The bird needs transparency, so we enable that again.
		batcher.enableBlending();

		// Draw buttons at its coordinates. Retrieve the Animation object from
		// AssetLoader
		// Pass in the runTime variable to get the current frame.
		batcher.draw(AssetLoader.redPressed, playButton.getX(),
				playButton.getY(), playButton.getWidth() / 2,
				playButton.getHeight() / 2);

		batcher.draw(AssetLoader.redButton, playButton.getX() - 1.3f, playButton.getY(),
				playButton.getWidth() / 2, playButton.getHeight() / 2);

		batcher.draw(AssetLoader.yellowPressed, optionsButton.getX(),
				optionsButton.getY(), optionsButton.getWidth() / 2,
				optionsButton.getHeight() / 2);
		
		batcher.draw(AssetLoader.yellowButton, optionsButton.getX() - 1.3f,
				optionsButton.getY(), optionsButton.getWidth() / 2,
				optionsButton.getHeight() / 2);
		
		batcher.draw(AssetLoader.bluePressed, customButton.getX(),
				customButton.getY(), customButton.getWidth() / 2,
				customButton.getHeight() / 2);
		
		batcher.draw(AssetLoader.blueButton, customButton.getX() - 1.3f,
				customButton.getY(), customButton.getWidth() / 2,
				customButton.getHeight() / 2);

		// End SpriteBatch
		batcher.end();

	}
}
