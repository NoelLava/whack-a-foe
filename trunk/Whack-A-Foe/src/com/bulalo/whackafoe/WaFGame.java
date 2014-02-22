package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Screens.MainMenuScreen;
import com.bulalo.Helpers.AssetLoader;

public class WaFGame extends Game {

	MainMenuScreen mainMenu;
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		System.out.println("Game created");
		mainMenu = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
