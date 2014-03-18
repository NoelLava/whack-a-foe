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

	private Hammers hammer;
	private Hammers hammer1;
	private Hammers hammer2;
	
	private Upgrades upgradeOn;
	private Upgrades upgradeOff;
	private Upgrades upgradeOn1;
	private Upgrades upgradeOff1;

	float runTime = 0;

	public ShopWorld() {
		shopButtons = new ArrayList<Button>();

//		backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
//				Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
//				AssetLoader.backButton, AssetLoader.backPressed);
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);

		shopButtons.add(backButton);
		
		hammer = new Hammers (9, 60, 43, 53);
		
		hammer1 = new Hammers (59, 60, 43, 53);
		
		hammer2 = new Hammers (109, 60, 43, 53);
		
		upgradeOn = new Upgrades(20, 180, 22, 42);
		
		upgradeOff = new Upgrades(60, 180, 22, 42);
		
		upgradeOn1 = new Upgrades(100, 180, 22, 42);
		
		upgradeOff1 = new Upgrades(140, 180, 22, 42);
		
	}

	public void update(float delta) {
		hammer.update(delta);
		hammer1.update(delta);
		hammer2.update(delta);
		
		upgradeOn.update(delta);
		upgradeOff.update(delta);
		upgradeOn1.update(delta);
		upgradeOff1.update(delta);
		
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
	
	public Upgrades getUpgradeOn(){
		return upgradeOn;
	}
	
	public Upgrades getUpgradeOff(){
		return upgradeOff;
	}
	
	public Upgrades getUpgradeOn1(){
		return upgradeOn1;
	}
	
	public Upgrades getUpgradeOff1(){
		return upgradeOff1;
	}

	public static List<Button> getShopButtons() {
		return shopButtons;
	}

}
