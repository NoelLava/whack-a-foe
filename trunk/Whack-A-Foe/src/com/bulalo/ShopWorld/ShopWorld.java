package com.bulalo.ShopWorld;

import java.util.ArrayList;
import java.util.List;

import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Upgrades;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class ShopWorld {
	private static List<Button> shopButtons;
	
	private Button backButton;
	private Button timeUpgradeButton;
	private Button scoreUpgradeButton;

	private Hammers hammer;
	private Hammers hammer1;
	private Hammers hammer2;

	float runTime = 0;

	public ShopWorld() {
		shopButtons = new ArrayList<Button>();

//		backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
//				Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
//				AssetLoader.backButton, AssetLoader.backPressed);
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);
		
		timeUpgradeButton = new Button(25, 165, 50, 60,
				AssetLoader.timeBoostUp, AssetLoader.timeBoostDown);
		scoreUpgradeButton = new Button(90 , 165, 50, 60,
				AssetLoader.scoreBoostUp, AssetLoader.scoreBoostDown);

		shopButtons.add(backButton);
		shopButtons.add(timeUpgradeButton);
		shopButtons.add(scoreUpgradeButton);
		
		hammer = new Hammers (9, 60, 43, 53);
		hammer1 = new Hammers (59, 60, 43, 53);
		hammer2 = new Hammers (109, 60, 43, 53);
		
	}

	public void update(float delta) {
		hammer.update(delta);
		hammer1.update(delta);
		hammer2.update(delta);
				
	}

	public Hammers getHammer() {
		return hammer;
	}

	public Hammers getHammer1() {
		return hammer1;
	}

	public Hammers getHammer2() {
		return hammer2;
	}

	public static List<Button> getShopButtons() {
		return shopButtons;
	}

}
