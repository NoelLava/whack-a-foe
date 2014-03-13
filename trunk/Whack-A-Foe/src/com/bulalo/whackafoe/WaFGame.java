package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.Screens.CustomizeScreen;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Screens.MenuScreen;

public class WaFGame extends Game {

	public MenuScreen mainMenu;
	public GameScreen gameScreen;
	public CustomizeScreen customizeScreen;
	
	@Override
	public void create() {
		System.out.println("Game created");
		//mainMenu = new MenuScreen(this);
		gameScreen = new GameScreen();
		customizeScreen = new CustomizeScreen();
		AssetLoader.load();
		setScreen(new MenuScreen(this));
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
