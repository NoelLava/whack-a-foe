package com.bulalo.ShopWorld;

import java.util.ArrayList;
import java.util.List;

import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Upgrades;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class ShopWorld {
	private static List<Button> shopButtons;
	private static List<Button> useButtons;
	private static List<Button> buyButtons;
	private static List<Button> hammerButtons;
	
	private Button backButton;
	private Button timeUpgradeButton;
	private Button scoreUpgradeButton;
	private Button buyButton;
	private Button buyButton1;
	private Button buyButton2;
	private Button useButton;
	private Button useButton1;
	private Button useButton2;
	private Button buyButton3;
	private Button buyButton4;
	
	private Button hammer;
	private Button hammer1;
	private Button hammer2;

	float runTime = 0;

	public ShopWorld() {
		shopButtons = new ArrayList<Button>();
		useButtons = new ArrayList<Button>();
		buyButtons = new ArrayList<Button>();
		hammerButtons = new ArrayList<Button>();

//		backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
//				Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
//				AssetLoader.backButton, AssetLoader.backPressed);
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);
		
		timeUpgradeButton = new Button(25, 165, 43, 53,
				AssetLoader.timeBoostUp, AssetLoader.timeBoostDown);
		scoreUpgradeButton = new Button(90 , 165, 43, 53,
				AssetLoader.scoreBoostUp, AssetLoader.scoreBoostDown);
		
		buyButton = new Button(14,117,34.5f,13.5f,AssetLoader.buyUp,AssetLoader.buyDown);
		buyButton1 = new Button(64,117,34.5f,13.5f,AssetLoader.buyUp,AssetLoader.buyDown);
		buyButton2 = new Button(114,117,34.5f,13.5f,AssetLoader.buyUp,AssetLoader.buyDown);
		useButton = new Button(14,132,34.5f,13.5f,AssetLoader.useUp,AssetLoader.useDown);
		useButton1 = new Button(64,132,34.5f,13.5f,AssetLoader.useUp,AssetLoader.useDown);
		useButton2 = new Button(114,132,34.5f,13.5f,AssetLoader.useUp,AssetLoader.useDown);
		buyButton3 = new Button(30,220,34.5f,13.5f,AssetLoader.buyUp,AssetLoader.buyDown);
		buyButton4 = new Button(95,220,34.5f,13.5f,AssetLoader.buyUp,AssetLoader.buyDown);
		
		
		hammer = new Button(9, 60, 43, 53,AssetLoader.kahoy,AssetLoader.kahoyDown);
		hammer1 = new Button(59, 60, 43, 53,AssetLoader.bakal,AssetLoader.bakalDown);
		hammer2 = new Button(109, 60, 43, 53,AssetLoader.ginto,AssetLoader.gintoDown);
		hammerButtons.add(hammer);
		hammerButtons.add(hammer1);
		hammerButtons.add(hammer2);
		buyButtons.add(buyButton);
		buyButtons.add(buyButton1);
		buyButtons.add(buyButton2);
		useButtons.add(useButton);
		useButtons.add(useButton1);
		useButtons.add(useButton2);
		buyButtons.add(buyButton3);
		buyButtons.add(buyButton4);
		shopButtons.add(backButton);
		shopButtons.add(timeUpgradeButton);
		shopButtons.add(scoreUpgradeButton);
	}

	public void update(float delta) {
	}

		public static List<Button> getShopButtons() {
		return shopButtons;
	}

	public static List<Button> getBuyButtons(){
		return buyButtons;
	}
	
	public static List<Button> getHammerButtons(){
		return hammerButtons;
	}
	
	public static List<Button> getUseButtons(){
		return useButtons;
	}
}
