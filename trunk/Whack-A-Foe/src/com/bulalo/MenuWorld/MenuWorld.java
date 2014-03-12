package com.bulalo.MenuWorld;

import java.util.ArrayList;
import java.util.List;

import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class MenuWorld {
	private static List<Button> menuButtons;
	
	private Button playButton;
	private Button shopButton;
	private Button customButton;
	
	float runTime = 0;
	
	public MenuWorld(){
		menuButtons = new ArrayList<Button>();
		
//		playButton = new Button(10.5f, 111.75f, 65 , 65, AssetLoader.redButton, AssetLoader.redPressed);
//		shopButton = new Button(22.5f, 149.75f, 65, 65, AssetLoader.yellowButton, AssetLoader.yellowPressed);
//		customButton = new Button(22.5f, 187.75f, 65, 65, AssetLoader.blueButton, AssetLoader.bluePressed);
		
		playButton = new Button(320/2 - (AssetLoader.redButton.getRegionWidth() * 2.12f), 512/2 - (AssetLoader.redButton.getRegionWidth() * 2.22f), 65 / 2 , 65 / 2, AssetLoader.redButton, AssetLoader.redPressed);
		shopButton = new Button(320/2 - (AssetLoader.redButton.getRegionWidth() * 2.12f), 512/2 - (AssetLoader.redButton.getRegionWidth() * 1.63f), 65 / 2, 65 / 2, AssetLoader.yellowButton, AssetLoader.yellowPressed);
		customButton = new Button(320/2 - (AssetLoader.redButton.getRegionWidth() * 2.12f), 512/2 - (AssetLoader.redButton.getRegionWidth() * 1.05f), 65 / 2, 65 / 2, AssetLoader.blueButton, AssetLoader.bluePressed);
		//111.75f, 149.75f, 187.75f
		
		menuButtons.add(playButton);
		menuButtons.add(shopButton);
		menuButtons.add(customButton);
	}
	
	public void update(float delta){	
		runTime += delta;
	}

	private void updateReady(float delta) {
		
	}

	private void updatePlay(float delta) {
		
	}

	private void updateOptions(float delta) {
		
	}

	private void updateCustom(float delta) {
		
	}
	
    public static List<Button> getMenuButtons() {
        return menuButtons;
    }
}
