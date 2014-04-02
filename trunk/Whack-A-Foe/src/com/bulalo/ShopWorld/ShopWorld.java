package com.bulalo.ShopWorld;

import java.util.ArrayList;
import java.util.List;

import com.bulalo.GameWorld.GameWorld;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.Helpers.InputHandler;
import com.bulalo.UI.Button;

public class ShopWorld {
	ShopInputHandler shopInputHandler;

	private static List<Button> shopButtons;
	private static List<Button> useButtons;
	private static List<Button> buyButtons;
	private static List<Button> hammerButtons;

	private Button backButton;
	private Button timeUpgradeButton;
	private Button scoreUpgradeButton;
	private Button buyKahoy;
	private Button buyBakal;
	private Button buyGinto;
	private Button useKahoy;
	private Button useBakal;
	private Button useGinto;
	private Button buyTimeUpgrade;
	private Button buyScoreUpgrade;

	private Button kahoy;
	private Button bakal;
	private Button ginto;

	float runTime = 0;

	public ShopWorld() {
		shopInputHandler = new ShopInputHandler();

		shopButtons = new ArrayList<Button>();
		useButtons = new ArrayList<Button>();
		buyButtons = new ArrayList<Button>();
		hammerButtons = new ArrayList<Button>();

		// backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
		// Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
		// AssetLoader.backButton, AssetLoader.backPressed);
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);

		timeUpgradeButton = new Button(25, 165, 43, 53,
				AssetLoader.timeBoostUp, AssetLoader.timeBoostDown);
		scoreUpgradeButton = new Button(90, 165, 43, 53,
				AssetLoader.scoreBoostUp, AssetLoader.scoreBoostDown);

		buyKahoy = new Button(14, 117, 34.5f, 13.5f, AssetLoader.buyUp,
				AssetLoader.buyDown);
		buyBakal = new Button(64, 117, 34.5f, 13.5f, AssetLoader.buyUp,
				AssetLoader.buyDown);
		buyGinto = new Button(114, 117, 34.5f, 13.5f, AssetLoader.buyUp,
				AssetLoader.buyDown);
		useKahoy = new Button(14, 117, 34.5f, 13.5f, AssetLoader.useUp,
				AssetLoader.useDown);
		useBakal = new Button(64, 117, 34.5f, 13.5f, AssetLoader.useUp,
				AssetLoader.useDown);
		useGinto = new Button(114, 117, 34.5f, 13.5f, AssetLoader.useUp,
				AssetLoader.useDown);
		buyTimeUpgrade = new Button(30, 220, 34.5f, 13.5f, AssetLoader.buyUp,
				AssetLoader.buyDown);
		buyScoreUpgrade = new Button(95, 220, 34.5f, 13.5f, AssetLoader.buyUp,
				AssetLoader.buyDown);

		kahoy = new Button(9, 60, 43, 53, AssetLoader.kahoy,
				AssetLoader.kahoyDown);
		bakal = new Button(59, 60, 43, 53, AssetLoader.bakal,
				AssetLoader.bakalDown);
		ginto = new Button(109, 60, 43, 53, AssetLoader.ginto,
				AssetLoader.gintoDown);

		hammerButtons.add(kahoy);
		hammerButtons.add(bakal);
		hammerButtons.add(ginto);

		buyButtons.add(buyKahoy);
		buyButtons.add(buyBakal);
		buyButtons.add(buyGinto);
		buyButtons.add(buyTimeUpgrade);
		buyButtons.add(buyScoreUpgrade);

		useButtons.add(useKahoy);
		useButtons.add(useBakal);
		useButtons.add(useGinto);

		shopButtons.add(backButton);
		shopButtons.add(timeUpgradeButton);
		shopButtons.add(scoreUpgradeButton);
	}

	public void update(float delta) {
		if (buyTimeUpgrade.isJustPressed()) {
			int price = 2;
			if (GameWorld.seconds < 90) {
				if (AssetLoader.getTicket() >= price) {
					GameWorld.seconds = 90;
				}
				shopInputHandler.computeTickets(price);

			}
			buyTimeUpgrade.setJustPressed(false);
		}
		if (buyScoreUpgrade.isJustPressed()) {
			int price = 3;
			if (InputHandler.dummyPoints < 2) {
				if (AssetLoader.getTicket() >= price) {
					InputHandler.dummyPoints = 2;
				}
				shopInputHandler.computeTickets(price);
			}

			buyScoreUpgrade.setJustPressed(false);
		}

		if (buyBakal.isJustPressed()) {
			int price = 5;

			if (AssetLoader.getTicket() >= price) {
				ShopInputHandler.steelIsBought = true;
			}
			shopInputHandler.computeTickets(price);
			buyBakal.setJustPressed(false);
		}
		if (buyGinto.isJustPressed()) {
			int price = 2;

			if (AssetLoader.getTicket() >= price) {
				ShopInputHandler.goldIsBought = true;
			}
			shopInputHandler.computeTickets(price);
			buyGinto.setJustPressed(false);
		}
	}

	public static List<Button> getShopButtons() {
		return shopButtons;
	}

	public static List<Button> getBuyButtons() {
		return buyButtons;
	}

	public static List<Button> getHammerButtons() {
		return hammerButtons;
	}

	public static List<Button> getUseButtons() {
		return useButtons;
	}
}
