package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Screens.MenuScreen;
import com.bulalo.Helpers.AssetLoader;

public class WaFGame extends Game {

	MenuScreen mainMenu;
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		System.out.println("Game created");
		mainMenu = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		AssetLoader.load();
		setScreen(new MenuScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
