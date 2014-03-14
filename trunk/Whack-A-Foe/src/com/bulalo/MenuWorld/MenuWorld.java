package com.bulalo.MenuWorld;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class MenuWorld {
	private static List<Button> menuButtons;

	private Button playButton;
	private Button shopButton;
	private Button customButton;
	private Button pauseButton;

	float runTime = 0;

	public MenuWorld() {
		menuButtons = new ArrayList<Button>();

		// playButton = new Button(Gdx.graphics.getWidth() / 2 - 144.05f,
		// Gdx.graphics.getHeight() / 2 - 147.6f, 43, 41,
		// AssetLoader.redButton, AssetLoader.redPressed);
		// shopButton = new Button(Gdx.graphics.getWidth() / 2 - 144.05f,
		// Gdx.graphics.getHeight() / 2 - 108.24f, 43, 41,
		// AssetLoader.yellowButton, AssetLoader.yellowPressed);
		// customButton = new Button(Gdx.graphics.getWidth() / 2 - 144.05f,
		// Gdx.graphics.getHeight() / 2 - 68.47f, 43, 41,
		// AssetLoader.blueButton, AssetLoader.bluePressed);

		playButton = new Button(15.95f, 108.4f, 43, 41, AssetLoader.redButton,
				AssetLoader.redPressed);
		shopButton = new Button(15.95f, 147.46f, 43, 41,
				AssetLoader.yellowButton, AssetLoader.yellowPressed);
		customButton = new Button(15.95f, 187.53f, 43, 41,
				AssetLoader.blueButton, AssetLoader.bluePressed);

		menuButtons.add(playButton);
		menuButtons.add(shopButton);
		menuButtons.add(customButton);
	}

	public void update(float delta) {
		runTime += delta;
	}

	public static List<Button> getMenuButtons() {
		return menuButtons;
	}
}
