package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.Screens.CustomizeScreen;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Screens.MenuScreen;

public class WaFGame extends Game {

	MenuScreen mainMenu;
	public GameScreen gameScreen;
	public CustomizeScreen customizeScreen;
	
	@Override
	public void create() {
		System.out.println("Game created");
		mainMenu = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		customizeScreen = new CustomizeScreen(this);
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
