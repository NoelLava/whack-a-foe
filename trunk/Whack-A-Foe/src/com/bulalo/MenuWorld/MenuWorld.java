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

		playButton = new Button(Gdx.graphics.getWidth() / 2 - (AssetLoader.redButton.getRegionWidth() * 1.675f),
				Gdx.graphics.getHeight() / 2 - (AssetLoader.redButton.getRegionHeight() * 1.8f),
				AssetLoader.redButton.getRegionWidth() / 2,
				AssetLoader.redButton.getRegionHeight() / 2,
				AssetLoader.redButton, AssetLoader.redPressed);
		shopButton = new Button(Gdx.graphics.getWidth() / 2	- (AssetLoader.redButton.getRegionWidth() * 1.675f),
				Gdx.graphics.getHeight() / 2 - (AssetLoader.redButton.getRegionHeight() * 1.32f),
				AssetLoader.redButton.getRegionWidth() / 2,
				AssetLoader.redButton.getRegionHeight() / 2,
				AssetLoader.yellowButton, AssetLoader.yellowPressed);
		customButton = new Button(Gdx.graphics.getWidth() / 2 - (AssetLoader.redButton.getRegionWidth() * 1.675f),
				Gdx.graphics.getHeight() / 2 - (AssetLoader.redButton.getRegionHeight() * 0.835f),
				AssetLoader.redButton.getRegionWidth() / 2,
				AssetLoader.redButton.getRegionHeight() / 2,
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
